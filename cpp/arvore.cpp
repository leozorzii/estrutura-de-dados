#include <iostream>
#include <stdlib.h>
using namespace std;

typedef struct no{
    int valor;
    struct no *esq;
    struct no *dir;
}Arvore;
//metodo inserir recursivo em arvore binaria ordenada
Arvore *inserir(int valor, Arvore *raiz){
    if(raiz){
        //controle de duplicados
        if(valor == raiz->valor) return raiz;

        if(valor < raiz->valor){//ir para esquerda
            raiz->esq = inserir(valor, raiz->esq);
        }else{ //ir para direita
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;
    }else{
        Arvore *novo;
        novo = (Arvore *)malloc(sizeof(Arvore));
        novo->valor = valor;
        novo->esq = NULL;
        novo->dir = NULL;
        return novo;
    }
}

void red(Arvore *raiz){
    if(raiz){
        cout << "RED -- ";
        cout << raiz->valor << "\t" << endl;
        red(raiz->esq);
        red(raiz->dir);
    }
}


void erd(Arvore *raiz){
    if(raiz){
        erd(raiz->esq);
        cout << "ERD -- ";
        cout << raiz->valor << "\t" << endl;
        erd(raiz->dir);
    }
}

void edr(Arvore *raiz){
    if(raiz){
        edr(raiz->esq);
        edr(raiz->dir);
        cout << "EDR -- ";
        cout << raiz->valor << "\t" << endl;
    }
}

void exibir(int nivel, Arvore *raiz){
    if(raiz){
        exibir(nivel + 1, raiz->dir);

        for(int i =0; i < nivel; i++){
            cout << " ";
        }
        cout << raiz->valor << "(" << nivel << ")\n"; 

        exibir(nivel + 1, raiz->esq);
    }
}

int contar(Arvore *raiz) {
    if(raiz) {
        return 1 + contar(raiz->esq) + contar(raiz->dir);
    }
    return 0;
}

int contarFolhas(Arvore *raiz){
    if(raiz){
        if(!raiz->esq && !raiz->dir){
            return 1;
        }
        return contarFolhas(raiz->esq) + contarFolhas(raiz->dir);
    }
    return 0;
}
int encontrarMenorValorDaArvore(Arvore *raiz){
    if(!raiz) return -27; //se a arvore tiver vazia

    Arvore *p;
    for( p = raiz; p->esq; p = p->esq){

        return p->valor;
    }
}
int encontrarMaiorValorDaArvore(Arvore *raiz){
    if(!raiz) return -27; //se a arvore tiver vazia

    Arvore *p;
    for( p = raiz; p->dir; p = p->dir){
        
        return p->valor;
    }
}
 
bool encontrar(int valor, Arvore *raiz){
    if(raiz) {
        if(valor == raiz->valor){
            
        }
        if(valor < raiz->valor){
            return encontrar(valor, raiz->esq);
        }
        return encontrar(valor, raiz->dir);
    }
    return 0;//nao encontrou valor
}
int nivel(int valor, Arvore *raiz){
    if(!raiz) {
        return -1;
    }
    
    if(valor == raiz->valor){
        return 0;
    }
    
    if(valor < raiz->valor){
        int res = nivel(valor, raiz->esq);
        if(res == -1) return -1;
        return res + 1;
    } else {
        int res = nivel(valor, raiz->dir);
        if(res == -1) return -1;
        return res + 1;
    }
}

int main() {
    Arvore *raiz = NULL;
    srand(time(NULL));
    for(int i = 0; i < 20; i++){
        raiz = inserir(rand() % 30, raiz);
    }
    //  raiz = inserir(100, raiz);
    //  raiz = inserir(150, raiz);
    //  raiz = inserir(50, raiz);
    //  raiz = inserir(80, raiz);
    //  raiz = inserir(60, raiz);
    //  raiz = inserir(120, raiz);
    //  raiz = inserir(90, raiz);
    //red(raiz);
    //erd(raiz);
    //edr(raiz);
    //contar folhas

    exibir(0, raiz);
    cout << "qtd de nos: " << contar(raiz) << endl;
    cout <<  "contador de folhas: "<< contarFolhas(raiz) << endl;
    cout << "Maior valor: " << encontrarMaiorValorDaArvore(raiz) << endl;
    cout << "Menor valor: " << encontrarMenorValorDaArvore(raiz) << endl;

    int valor = 5;
    cout << "Encontrou " << valor << "?: " << encontrar(valor, raiz) << "\n";
    cout << "Nivel " << valor << "?:" << nivel(valor,raiz) << "\n";
    return 1;
}