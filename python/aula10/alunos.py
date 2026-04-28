import csv
class Aluno:
    """Classe que representa um aluno com seus dados acadêmicos."""
    
    
    def __init__(self, nome, curso, sexo, ano_ingresso):
        """Inicializa um objeto Aluno com seus atributos.
        
        Args:
            nome (str): Nome completo do aluno.
            curso (str): Curso do aluno.
            sexo (str): Sexo do aluno.
            ano_ingresso (int): Ano de ingresso do aluno.
        """
        self.nome = nome
        self.curso = curso
        self.sexo = sexo
        self.ano_ingresso = ano_ingresso
    
    def __str__(self):
        """Retorna uma representação em string do aluno.
        
        Returns:
            str: String contendo os dados formatados do aluno.
        """
        return f" Nome:{self.nome} - {self.curso} - {self.sexo} - {self.ano_ingresso}"    
        
        
def carregar_alunos():
    """Le o arquivo alunos.csv e instancia objetos Aluno.
    
    Carrega os dados do arquivo CSV e cria uma lista de objetos Aluno
    com os atributos correspondentes (Nome, Curso, Sexo, AnoIngresso).
    
    Returns:
        list: Lista de objetos Aluno carregados do arquivo.
    """
    alunos = [] 
         
    with open('alunos.csv', mode='r', encoding='utf-8') as arquivo:
      
        leitor = csv.reader(arquivo, delimiter=',') 
          
        for linha in leitor:
            aluno = Aluno(linha[0], linha[1], linha[2], int(linha[3]))
            alunos.append(aluno)
    return alunos
    
def ordenar_alunos(alunos, criterio):
    """Ordena a lista de alunos por um critério especificado.
    
    Ordena os alunos por "nome" ou "ano" de ingresso antes de exibir.
    
    Args:
        alunos (list): Lista de objetos Aluno a serem ordenados.
        criterio (str): Critério de ordenação ('nome' ou 'ano').
    
    Returns:
        list: Lista de alunos ordenada conforme o critério.
    """
    if criterio == "nome":
        alunos.sort(key=lambda a: a.nome)
    elif criterio == "ano":    
        alunos.sort(key=lambda a: a.ano_ingresso )

    return alunos
        
        
def buscar_aluno(alunos, nome):
    """Busca um aluno pela correspondência exata do nome.
    
    Procura na lista um aluno com o nome exato fornecido e retorna
    seus dados completos.
    
    Args:
        alunos (list): Lista de objetos Aluno.
        nome (str): Nome exato do aluno a ser buscado.
    
    Returns:
        Aluno: Objeto Aluno encontrado ou None se não existir.
    """
    for aluno in alunos:
        if aluno.nome == nome:
            return aluno
    return None


def agregar_por_ano(alunos):
    """Calcula quantos alunos ingressaram em cada ano.
    
    Agrega os dados dos alunos contabilizando quantos alunos
    ingressaram em cada ano diferente.
    
    Args:
        alunos (list): Lista de objetos Aluno.
    
    Returns:
        dict: Dicionário com anos como chaves e contagem de alunos como valores.
    """
    contagem = {}
    
    for aluno in alunos:
        ano = aluno.ano_ingresso
        if ano in contagem:
            contagem[ano] += 1
        else:
            contagem[ano] = 1 #em caso de anos novos
        
    return contagem


def executar():
    """Executa o programa principal.
    
    Carrega os alunos do arquivo CSV, ordena por nome, busca um aluno
    especiico, calcula a agregação por ano e exibe os resultados.
    """
    alunos = carregar_alunos()
    alunos = ordenar_alunos(alunos, "nome")
    resultado = buscar_aluno(alunos, "Ana Silva")
    contagem = agregar_por_ano(alunos)
    print(resultado)
    print(contagem)
  
    for aluno in alunos:
        print(aluno)



if __name__ == "__main__":
  executar()
  
 