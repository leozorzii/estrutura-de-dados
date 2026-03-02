#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <fstream>

using namespace std;

int main(){
    srand(time(0));
    vector <int> lista;
    int n;
    
    cout << "Quantos elementos deseja gerar? ";
    cin >> n;
    
    while(lista.size() < n){
        int numerosSorteados = rand() % 1000001;
        if(find(lista.begin(), lista.end(), numerosSorteados) == lista.end()) {
            lista.push_back(numerosSorteados);
        }
    } 
    sort(lista.begin(), lista.end());
    
    ofstream arquivo("numeroscpp.txt");
    for(int num : lista) {
        arquivo << num << endl;
    }
    arquivo.close();
    
    cout << "Total de elementos: " << lista.size() << endl;
    
    return 0;
}