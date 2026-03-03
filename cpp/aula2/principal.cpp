#include <iostream>
#include <ctime>
#include <cstdlib>
#include <string>
#include "minhaBiblioteca.h"

using namespace std;

int main() {

    //inicia o gerador de numeros aleatorios.
    srand(time(0));

    const int TAM = 100; // define tamanho fixo das listas

    int listaNumerosA[TAM];
    int listaNumerosB[TAM];
    int listaResultado[TAM];

    string nomeArquivo = "numeros.txt";
    popularAleatorio(listaNumerosA, TAM);
    exibir(listaNumerosA, TAM);

    popularArquivo(listaNumerosB, TAM, nomeArquivo);
    exibir(listaNumerosB, TAM);

    int quantidadeResultado = copiarListaSemDuplicatas(listaNumerosB, TAM, listaResultado, TAM);
    exibir(listaResultado, quantidadeResultado);

    return 0;
}