class Aluno:
    def __init__(self, nome):
        """Inicializa um objeto Aluno com nome e email gerado automaticamente.

        Args:
            nome (str): Nome completo do aluno.
        """
        self.nome = nome;
        self.email = self.gerarEmail(nome)

    def gerarEmail(self, email):
        """Gera um email institucional a partir do nome do aluno.

        Args:
            email (str): Nome completo do aluno usado para gerar o email.

        Returns:
            str: Email no formato primeiro.ultimo@ufn.edu.br.
        """
        partes = nome.lower().split()
        return partes[0] + "." + partes[-1] + "@ufn.edu.br"



def cadastrarAlunos(listaDeAlunos):
    """Cadastra 3 alunos via input do usuário e os adiciona à lista.

    Args:
        listaDeAlunos (list): Lista onde os objetos Aluno serão inseridos.
    """
    for i in range(3):
        nome = input("Insira o nome do aluno: ")
        aluno = Aluno(nome)  # cria novo aluno
        listaDeAlunos.append(aluno)
