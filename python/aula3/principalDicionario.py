nome_arquivo = './glicemia.txt'
lista_dicionarios_glicemica = []


def calcular_media(lista):
    if not lista: return 0
    soma = sum(int(item["valor"]) for item in lista)
    return soma / len(lista)

def calcular_mediana(lista):
    if not lista: return 0
    
    
    valores = [int(item["valor"]) for item in lista]
    n = len(valores)
    meio = n // 2
    
    if n % 2 != 0:
        return float(valores[meio])
    else:
        return (valores[meio - 1] + valores[meio]) / 2



def esta_contido(dicionario, lista_dicionarios):
    for item in lista_dicionarios:
        if item["data"] == dicionario["data"] and item["hora"] == dicionario["hora"]:
            return True
    return False

#  LOGICA PRINCIPAL
    with open(nome_arquivo, 'r', encoding='utf8') as leitor:
        for linha in leitor:
            
            partes = linha.strip().split(',')
            
            if len(partes) == 3:
                valor, data, hora = partes
                dados = {
                    "valor": valor,
                    "data": data,
                    "hora": hora
                }
                
              
                if not esta_contido(dados, lista_dicionarios_glicemica):
                    lista_dicionarios_glicemica.append(dados)

    
    lista_dicionarios_glicemica.sort(key=lambda d: int(d["valor"]))

    print(f'Quantidade de dados únicos: {len(lista_dicionarios_glicemica)}')
    
    if lista_dicionarios_glicemica:
        media = calcular_media(lista_dicionarios_glicemica)
        mediana = calcular_mediana(lista_dicionarios_glicemica)
        
        print(f'Média Glicêmica: {media:.2f}')
        print(f'Mediana Glicêmica: {mediana:.2f}')
        
        print("\nLista Ordenada:")
        for item in lista_dicionarios_glicemica:
            print(item)