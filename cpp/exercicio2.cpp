#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_set>
#include <random>
#include <chrono>
#include "util.h"

using namespace std;
void popularListaArquivo(const vector<string>& lista, const string& nomeArquivo);//funcao sobrecarregada

int main() {
    string letras = "abcdefghijklmnopqrstuvwxyz";
    vector<string> lista;
    unordered_set<string> verificaDuplicatas;//verifica se palavras estao duplicadas
    
    int n, tamanhoPalavra;
    
    cout << "Digite quantos nomes quer gerar: ";
    cin >> n;
    
    cout << "Qual o tamanho da palavra a ser sorteada? ";
    cin >> tamanhoPalavra;
    
    if (n <= 0 || tamanhoPalavra <= 0) {
        cout << "Valores devem ser positivos!" << endl;
        return 1;
    }
    
    string palavra;
    
    while ((int)lista.size() < n) {
        palavra = "";
        
        for (int j = 0; j < tamanhoPalavra; j++) {
            int posicaoLetras = rand() % letras.length();
            palavra += letras[posicaoLetras];
        }
        
        if (verificaDuplicatas.find(palavra) == verificaDuplicatas.end()) {
            lista.push_back(palavra);
            verificaDuplicatas.insert(palavra);
        }
    }


    
    sort(lista.begin(), lista.end());
    
    cout << "Palavras geradas:" << endl;
    for (const string p : lista) {
        cout << p << endl;
    }
    
    popularListaArquivo(lista, "nomescpp.txt");
    
    cout << "Palavra sorteada: " << palavra << endl;
    
    return 0;
}