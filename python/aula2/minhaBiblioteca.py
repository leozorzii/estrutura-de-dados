from random import randint

def popular_aleatorio(lista:int, quantidade:int):
    """_summary_
    Método que recebe uma lista e a popula com números aleatórios.
    
    Args:
        lista (_type_): Lista de números.
        quantidade (_type_): Quantidade de números a serem gerados.
    """
    for i in range(quantidade):
        lista.append(randint(0, 100))

def popular_de_arquivo(lista, nome_arquivo):
    """_summary_
    Método que recebe uma lista e a popula com dados vindo de um arquivo.
    Args:
        lista (_type_): Lista genérica
    nome_arquivo (_type_): Nome do arquivo fonte que contém os dados
        """
    with open(nome_arquivo, "r", enconding = 'utf8') as leitor:
        for linha in leitor:
            lista.append(linha.strip())
def exibir(lista):
       """_summary_
    Método que recebe uma lista genérica, exibe todos os seus elementos na tela(um abaixo do outro) e 
    no final exibe a quantidade de elementos  da lista
    Args:
        lista (_type_): Lista genérica
    """
       for i in lista:
            print("numero da lista: ", i)
            print("------------------")
            print('total de registros: ', len(lista))
 
def copiarListaSemDuplicatas(lista_origem, lista_destino):
       """_summary_
    Função que recebe uma lista de origem e copia seus elementos para uma lista destino, removendo as duplicatas
    Args:
        lista_origem (_type_): Lista com os dados de origem
        lista_destino (_type_): Lista para receber os dados tratados
    """
       for i in lista_origem:
            if i not in lista_destino:
                 lista_destino.append(i)