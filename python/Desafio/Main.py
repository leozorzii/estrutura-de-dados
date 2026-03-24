from Aluno import cadastrarAlunos

lista = []

cadastrarAlunos(lista)

for aluno in lista:
    print(f"Nome do aluno: {aluno.nome}\nEmail do aluno: {aluno.email}\n")