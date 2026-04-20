#include <iostream>
#include <ctime>
#include <cstdlib>
 
#define TAM 5
 
using namespace std;
 
void popularVetor(int vetor[], int n) {
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        vetor[i] = rand() % 100;
    }
}
 
void exibirVetor(int vetor[], int n) {
    for (int i = 0; i < n; i++) {
        cout << vetor[i] << endl;
    }
}
 
int main() {
    int vetor[TAM];
 
    popularVetor(vetor,TAM);
    exibirVetor(vetor, TAM);
 
    return 1;
}