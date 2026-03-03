from python.aula2.minhaBiblioteca import popular_aleatorio, popular_de_arquivo, exibir, copiarListaSemDuplicatas

lista_numerosA = []
lista_numerosB = []

popular_aleatorio(lista_numerosA, 100)
exibir(lista_numerosA)

#nome_arquivo = 'numeros.txt'
#popular_de_arquivo(lista_numerosB, nome_arquivo)
#exibir(lista_numerosB)

lista_resultado = []
copiarListaSemDuplicatas(lista_numerosB, lista_resultado)
exibir(lista_resultado)
