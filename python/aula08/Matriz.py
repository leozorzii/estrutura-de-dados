from Dado import Dado
def iniciar_matriz(qtdL, qtdC):
    return[[0 for _ in range(qtdC)] for _ in range(qtdL)]
    pass

def exibir_matriz(matriz, qtdL, qtdC):
    for i in range(qtdL):
        for j in range(qtdC):
            print(matriz, end="\t")
            
    print()
    
    
def converter_matriz_lista(matriz, lista):
    for i, linha in enumerate(matriz):                
        for j, valor in enumerate(linha):
            if valor != 0:                
                lista.append(Dado(valor, i, j))
                
def exibir_lista(lista):
    for item in lista:
        print(item)