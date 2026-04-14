java.Aula08
public class Dado {
    public int valor;
    public int x;//linha
    public int y;//coluna

    public Dado(int valor, int x, int y){
        this.valor = valor;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dado other = (Dado) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dado [valor=" + valor + ", x=" + x + ", y=" + y + "]";
    }
}
