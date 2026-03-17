from glicemia import Glicemia

lista_glicemica = []
nome_arquivo = './glicemia.txt'

with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        partes = linha.strip().split(',')

        if len(partes) == 3:
            valor, data, hora = partes
            novo = Glicemia(valor, data, hora)

            if novo not in lista_glicemica:
                lista_glicemica.append(novo)

lista_glicemica.sort(key=lambda g: int(g.valor))

print('Quantidade de dados lidos:', len(lista_glicemica))
for item in lista_glicemica:
    print(item)

print()
if lista_glicemica:
    print('Media glicemica:', Glicemia.calcular_media(lista_glicemica))
    print('Mediana glicemica:', Glicemia.calcular_mediana(lista_glicemica))

turnos = {
    'MANHA': [],
    'TARDE': [],
    'NOITE': []
}

for medicao in lista_glicemica:
    turno = medicao.obter_turno()
    turnos[turno].append(medicao)

<<<<<<< HEAD
turnos = {
        'MANHA': [],
        'TARDE': [],
        'NOITE': []
}   
for medicao in lista_glicemica:
    turno = medicao.obter_turno()
    turnos[turno].append(int(medicao.valor))
    
    #Exemplo do que esse for faz
    #turnos = {
    #'MANHA': [90, 110, 105],
    #'TARDE': [130, 140],
    #'NOITE': [100, 150, 120]
    #}

    #calcular media entre os turnos

media_turnos = {}

for turno, valores in turnos.items():
    if len(valores) > 0:
        medias_turnos[turno] = sum(valores) / len(valores)
    else:
        medias_turnos[turno] = 0

    #metodo que pega maior valor entre os indices
    turno_mais_alto = max(medias_turnos, key=medias_turnos.get)
    print(f'Turno com glicemia mais alta: {turno_mais_alto}')

    print('\nAlertas:')
    encontrou_alerta = false

    for medicao in lista_glicemica:
        if medicao.glicemia_alta():
            encontrou_alerta = True
            print(f'glicemia alta({medicao.valor}) em {medicao.data} no horario: {medicao.hora} - TURNO: {medicao.obter_turno()}')

    if not encontrou_alerta:
        print('Nenhum alerta de glicemia alta, ta tranquilo galo cinza')
    else:
        print('Nenhum dado valido foi lido')

=======
print('\nLISTA MANHA')
for item in turnos['MANHA']:
    print(item)

print('\nLISTA TARDE')
for item in turnos['TARDE']:
    print(item)

print('\nLISTA NOITE')
for item in turnos['NOITE']:
    print(item)

medias_turnos = {}

for turno, lista in turnos.items():
    if len(lista) > 0:
        medias_turnos[turno] = Glicemia.calcular_media(lista)
    else:
        medias_turnos[turno] = 0

print('\nMEDIAS POR TURNO:')
for turno, media in medias_turnos.items():
    print(f'{turno}: {media}')

turno_mais_alto = max(medias_turnos, key=medias_turnos.get)
print(f'\nTurno com glicemia mais alta: {turno_mais_alto}')

print('\nALERTAS:')
encontrou_alerta = False

for medicao in lista_glicemica:
    if medicao.glicemia_alta():
        encontrou_alerta = True
        print(f'ATENÇÃO: glicemia alta ({medicao.valor}) em {medicao.data} no horário {medicao.hora} - TURNO: {medicao.obter_turno()}')

if not encontrou_alerta:
    print('Nenhum alerta de glicemia alta.')
>>>>>>> 6f3ae3aafdf5e490544f685af101e670f9af7285