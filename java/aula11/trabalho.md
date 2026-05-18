Fazer um programa em Java ou Python para gerenciar figurinhas da copa 2026. O programa deve persistir e identificar figurinhas para troca entre duas pessoas.
A classe básica de ver ser:
Figura:
nomeSelecao
numeroFigura
descricao //nome do jogador, brasao, ou bandeira
quantidade //opcional, usada nas repetidas
rara (boolean)

O menu deve ser:
Menu
1 - Cadastrar figuras repetidas pessoais (persistidas em arquivo csv figuras_repetidas_pessoais.csv e adicionadas na lista_repetidas_pessoais)
2 - Listar figuras repetidas pessoais (mostrar a lista respectiva)
3 - Cadastrar figuras desejadas pessoais (persistidas em arquivo csv figuras_desejadas_pessoais.csv e adicionadas na lista_desejadas_pessoais)
4 - Listar figuras desejadas pessoais (mostrar a lista respectiva)
5 - Carregar figuras repetidas OUTRO (carregar o arquivo, listar as figuras e mostrar as figuras que dão match com lista_desejadas_pessoais)
6 - Carregar figuras desejadas OUTRO (carregar o arquivo, listar as figuras e mostrar as figuras que dão match com lista_repetidas_pessoais)
7 - Sair
Opção:

Toda vez que o programa for iniciado, os arquivos csv pessoais devem ser populados em suas listas respectivas.
