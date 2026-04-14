import Matriz
dimensao = 5;
matriz = [[0 for _ in range(dimensao)] for _ in range(dimensao)]
Matriz.iniciar_matriz(dimensao, dimensao)

matriz[0][0] = 10
matriz[1][1] = 10
matriz[2][2] = 10
matriz[3][3] = 10

Matriz.exibir_matriz(matriz, dimensao, dimensao)
lista = []
Matriz.converter_matriz_lista(matriz, lista)
print("-------------------")
print(f"total de elementos da lista: {len(lista)}")
print()
Matriz.exibir_lista(lista)