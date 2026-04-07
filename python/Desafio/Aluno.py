class Aluno:
    def __init__(self, nome):
        self.nome = nome;
        self.email = self.gerarEmail(nome)

    def gerarEmail(self, email):
        partes = nome.lower().split()
        return partes[0] + "." + partes[-1] + "@ufn.edu.br"



def cadastrarAlunos(listaDeAlunos):
    for i in range(3):
        nome = input("Insira o nome do aluno: ")
        aluno = Aluno(nome)  # cria novo aluno
        listaDeAlunos.append(aluno)
