#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <fstream>
using namespace std;

// Metodo que recebe uma lista e a popula com números aleatórios.
void popularAleatorio(int lista[], int quantidade){
    for(int i = 0; i < quantidade;i++){
        lista[i] = rand() % 101;
    }
}
//metodo que recebe uma lista e popula de acordo com dados de um arquivo
void popularArquivo(int lista[], int quantidade, const string& nomeArquivo){
    ofstream arquivo(nomeArquivo);
    if(!arquivo.is_open()){
        cout << "erro ao abrir o arquivo" << endl;
        return;
    }
    
    for(int i = 0; i < quantidade; i++) {
        int numeroSorteado = rand() % 1000000;
        lista[i] = numeroSorteado;
        arquivo << numeroSorteado << endl;
    }
    
    arquivo.close();
}
//metodo que recebe uma lista generica, exibe todos os elementos um abaixo do outro
//e no final exibe seu total de registros na lista
void exibir(int lista[], int quantidade){
    for(int i = 0; i < quantidade; i++){
        cout << "numero da lista: " << lista[i] << endl;
        cout << "----------------" << endl;
    }
    cout << "total de registros: " << quantidade << endl;
}
//funcao que recebe uma lista de origem e copia os dados para uma lista de destino, removendo duplicados
int copiarListaSemDuplicatas(int listaOrigem[],int tamOrigem, int listaDestino[], int capacidadeDestino){
    int tamDestino = 0;
    for(int i = 0; i < tamOrigem; i++){
        int valor = listaOrigem[i];

    bool existe = false;//verificar se ja existe
    for(int j = 0 ; j < tamDestino; j++){
        if(listaDestino[j] == valor){
            existe = true;
            break;
            }
        }
        if(!existe){
            if(tamDestino < capacidadeDestino){
                listaDestino[tamDestino] = valor;
                tamDestino++;
            }else{
                cout << "destino sem espaco" << endl;
                break;
            }
        }
    }
     return tamDestino;
}