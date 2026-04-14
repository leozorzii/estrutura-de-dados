class Dado:
    def __init__(self, valor, x, y):
        self.valor = valor
        self.x = x 
        self.y = y

    def __eq__(self, other):
        if not isinstance(other, Dado):
            return False 
        return self.x == other.x and self.y == other.y

    def __repr__(self):
        return f"Dado [valor={self.valor}, x={self.x}, y={self.y}]"
