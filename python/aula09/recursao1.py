import random

def exibir_lista(lista):
    for i in range(0,len(lista)):
        print(lista[i])
        
def exibir_lista_r(lista, n):
    if(n >=1):
        exibir_lista_r(lista[n-1])#ponto de recursao com transformacao de variavel de controle
        if lista[n-1] % 2 ==0:
            print(lista[n-1])
        
def popular_lista(lista, n):
    for i in range(n):
        lista.append(random.randInt(0,100))
        
def popular_lista_r(lista, qtd):
    if qtd >=1:
        lista.append(random.randInt(0,100))
        popular_lista_r(lista[qtd-1])
        print(lista, qtd-1)
     

lista = [10,20,30,40]
popular_lista_r(lista,5)
exibir_lista_r(lista)