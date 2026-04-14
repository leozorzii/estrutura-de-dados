package java.Aula08;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args){
        int dimensao = 5;
        int matriz[][] = new int [dimensao][dimensao];
        Matriz.iniciarMatriz(matriz, dimensao, dimensao);

        matriz[0][0] = 10;
        matriz[1][1] = 10;
        matriz[2][2] = 10;
        matriz[3][3] = 10;

        

        Matriz.exibirMatriz(matriz,dimensao, dimensao);
        ArrayList<Dado> lista = new ArrayList<>();
        Matriz.converterMatrizLista(matriz, dimensao, dimensao, lista);
        Matriz.exibirLista(lista);
    }
}