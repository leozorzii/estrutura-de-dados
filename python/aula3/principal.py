from glicemia import Glicemia
lista_glicemica = []
nome_arquivo = './glicemia.txt'

with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        partes = linha.strip().split(',')
        if len(partes) == 3:
            valor, data, hora = partes
        novo = Glicemia(valor,data,hora)
       
        if novo not in lista_glicemica:
            lista_glicemica.append(novo)

lista_glicemica.sort(key=lambda g: int(g.valor))

if lista_glicemica:
    media = Glicemia.calcular_media(lista_glicemica)
    mediana = Glicemia.calcular_mediana(lista_glicemica)

print('Quantidade de dados lidos: ', len(lista_glicemica))
for linha in lista_glicemica:
    print(linha, end="")

print("\n")
print('Media glicemica: ', Glicemia.calcular_media(lista_glicemica))
print('Mediana glicemica: ', Glicemia.calcular_mediana(lista_glicemica))
