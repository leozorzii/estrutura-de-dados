def popularListaArquivo(lista, nomeArquivo):
    """Salva o conteúdo de uma lista em um arquivo de texto.

    Args:
        lista (list): Lista com os dados a serem salvos.
        nomeArquivo (str): Caminho do arquivo de destino.
    """
    with open(nomeArquivo, "w", encoding='utf8') as escritor:
        escritor.writelines(str(lista))

def lerArquivoLista(nomeArquivo):
    """Lê um arquivo de texto e adiciona cada linha à lista.

    Args:
        nomeArquivo (str): Caminho do arquivo a ser lido.
    """
    with open(nomeArquivo, 'r', encoding='uft8') as leitor:
         for linha in leitor:
            linha.replace('\n', '\0')
            lista.append(linha.strip())
