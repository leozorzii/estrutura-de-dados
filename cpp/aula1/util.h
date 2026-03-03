#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <fstream>
using namespace std;

void popularListaArquivo(int lista[], int n, const char* nomeArquivo) {
    srand(time(0));
    ofstream arquivo(nomeArquivo);
    
    for(int i = 0; i < n; i++) {
        int numeroSorteado = rand() % 1000000;
        lista[i] = numeroSorteado;
        arquivo << numeroSorteado << endl;
    }
    
    arquivo.close();
}

void popularListaArquivo(const vector<string>& lista, const string& nomeArquivo) {
    ofstream arquivo(nomeArquivo);
    
    if (!arquivo) {
        cerr << "Erro ao abrir arquivo para escrita: " << nomeArquivo << endl;
        return;
    }
    
    for (const auto& item : lista) {
        arquivo << item << endl;
    }
    
    arquivo.close();
}

vector<string> lerArquivoLista(const string& nomeArquivo) {
    vector<string> lista;
    ifstream leitor(nomeArquivo);
    
    if (!leitor) {
        cerr << "Erro ao abrir arquivo para leitura: " << nomeArquivo << endl;
        return lista;
    }
    
    string linha;
    while (getline(leitor, linha)) {
        lista.push_back(linha);
    }
    
    leitor.close();
    return lista;
}