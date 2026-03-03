#include <iostream>
#include "util.h"

int main(){
    srand(time(0));
    vector <int> lista;
    int n;
    
    cout << "Quantos elementos deseja gerar? ";
    cin >> n;
    
    while(lista.size() < n){
        int numerosSorteados = rand() % 1000000;
        if(find(lista.begin(), lista.end(), numerosSorteados) == lista.end()) {
            lista.push_back(numerosSorteados);
        }
    } 
    sort(lista.begin(), lista.end());
    popularListaArquivo(lista.data(), n, "numeroscpp.txt");
    
    
    cout << "Total de elementos: " << lista.size() << endl;
    
    return 0;
}