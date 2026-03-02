#operacoes sobre lista: inserir(append), percorrer(for), remover ou deletar(remove)
from minhaBiblioteca import popular_aleatorio, popular_arquivo, exibir, copiarListaSemDuplicatas
lista_numerosA = []
lista_numerosB = []

popular_aleatorio(lista_numerosA, 100)

nome_arquivo = 'numeros.txt'
popular_de_arquivo(lista_numerosB, nome_arquivo)

exibir(lista_numerosA)
exibir(lista_numerosB)

lista_resultado = []
copiarListaSemDuplicatas(lista_numerosB, lista_resultado)
