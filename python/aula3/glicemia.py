class Glicemia:
    def __init__(self, valor, data, hora):
        """construtor básico com os 3 atributos de classe

        Args:
            valor (int): de glicemia de sangue
            data (string): data da medição
            hora (string): hora da medição
        """
        self.valor = valor
        self.data = data
        self.hora = hora

    def __eq__(self, outro):
        if not isinstance(outro, Glicemia):
            return False
        return self.data == outro.data and self.hora == outro.hora
    
    def __str__(self):
        return f'\nValor glicemia: {self.valor}. Data: {self.data}. Hora: {self.hora}'
    
    @staticmethod
    def calcular_media(lista):
        soma = 0
        for item in lista:
            soma += int(item.valor)
        
        return int(soma/len(lista))
    
    @staticmethod
    def calcular_mediana(lista):
        if not lista:
            return 0
        valores = sorted([int(obj.valor) for obj in lista])
        n = len(valores)
        meio = n // 2
        if n % 2 != 0:
            return float(valores[meio])
        else: #tamanho da lista eh par
            return (valores[meio - 1] + valores[meio]) / 2.0

    #logica de obter horario
    def obter_turno(self):
        horario = int(self.hora.split(':')[0]) 
        if 5 <= horario < 12:
            return 'MANHA'
        elif 12 <= horario < 18:
            return 'TARDE'
        else:
            return 'NOITE'
            
    #caso a glicemia esteja muito alta
    def glicemia_alta(self):
        return int(self.valor) >= 140