import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Clima> climas = ClimaService.lerArquivo("dadosClimaticos.csv");
        ClimaService.analisarDados(climas);
    }
}