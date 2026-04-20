#include <iostream>
#include <ctime>
#include <cstdlib>
 
#define TAM 5
 
using namespace std;

/*recursao obedece a 3 situacoes
a - inicializacao de variavel de controle
b - teste de parada/continuidade
c - transformacao da variavel de controle
void mostrar sequencia(a){
for(;b;c){

}}
*/ 
void mostrarSequenciaRecursiva(int numero){
    if(numero > 0){
        //executar codigo no empilhamento
        cout << numero << endl;
        mostrarSequenciaRecursiva(numero - 1); //ponto de recursao com transformacao da variavel de controle
        // executar no desimpilhamento
    }
}


void mostrarSequencia(int numero){
    for(int i=1; i <= numero; numero++){
        cout << numero << endl;
    }
}

void popularVetorR(int vetor[], int n) {
    if(n >= 1){
        vetor[n-1] = rand() % 100;
        popularVetorR(vetor, n - 1);
    }
}
 
void exibirVetorR(int vetor[], int n) {
    if(n >= 1){
        cout << vetor[n-1];
        exibirVetorR(vetor, n-1);
    }
}

int main(){
    int vetor[TAM];
    int numero = 5;
    srand(time(NULL));

    mostrarSequenciaRecursiva(numero);
    popularVetorR(vetor, TAM);
    exibirVetorR(vetor, TAM);

    return 1;
}
 