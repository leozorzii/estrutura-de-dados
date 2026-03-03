#include <iostream>
#include <vector>
#include <string>
#include "util.h"

using namespace std;

int main() {
    vector<string> lista;
    
    lista = lerArquivoLista("numeroscpp.txt");
    
    for (string i : lista) {
        cout << i << endl;
    }
    
    return 0;
}