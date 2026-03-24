import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Classe principal do programa.
 * Responsável por orquestrar a leitura dos dados climáticos
 * e exibir as análises geral e por ano.
 */
public class Main {
    /** 
    * Método de entrada do programa.
     * Lê o arquivo CSV, coleta os anos únicos via HashSet,
     * exibe a análise geral e depois a análise individual por ano.
     *
     * @param args argumentos da linha de comando (não utilizados)
     * @throws IOException se o arquivo CSV não for encontrado
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Clima> climas = ClimaService.lerArquivo("dadosClimaticos.csv");

         HashSet<String> anos = new HashSet<>();
        for(Clima clima : climas) {
            anos.add(clima.ano);
        }

         System.out.println("-- Analise Geral --");
        ClimaService.analisarDados(climas);
    
    // analise por ano
    for(String ano : anos) {
        System.out.println(" Ano: " + ano);
        ArrayList<Clima> climasDoAno = new ArrayList<>();
        for(Clima c : climas) {
            if(c.ano.equals(ano)) {
                climasDoAno.add(c);
            }
        }
        ClimaService.analisarDados(climasDoAno);
    }
        }
    }