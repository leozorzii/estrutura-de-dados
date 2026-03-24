import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class ClimaService{

      //metodo para ler o arquivo, publico e estatico
    /**
     * Lê o arquivo CSV informado e converte cada linha em um objeto Clima.
     * Ignora a primeira linha (cabeçalho) e linhas vazias.
     * @param caminho caminho do arquivo CSV a ser lido
     * @return lista de objetos Clima com os dados do arquivo
     * @throws IOException se o arquivo não for encontrado ou não puder ser lido
     */
    public static ArrayList<Clima> lerArquivo(String caminho) throws IOException { //caminho = dadosClimaticos.csv
        ArrayList<Clima> climas = new ArrayList<>();
        BufferedReader lerLinhaPorLinha = new BufferedReader(new FileReader(caminho));
        lerLinhaPorLinha.readLine(); // 
        String linha = lerLinhaPorLinha.readLine();

        while(linha != null){
            if(!linha.isEmpty()){
                String [] valores = linha.split(",");
                int precipitacao = 0;
                switch (valores[3]){
                    case "muita" :
                        precipitacao = 3;
                        break;
                    case "média":
                        precipitacao = 2;
                        break;
                    case "pouca":
                        precipitacao = 1;
                        break;
                    case "nada":
                        precipitacao = 0;
                        break;
                }
                Clima c = new Clima(valores[0], valores[1], valores[2], precipitacao);
                climas.add(c);
            }
            linha = lerLinhaPorLinha.readLine();
        }

        return climas;
    }
    /**
     * Retorna a estação do ano correspondente ao mês informado.
     * @param mes nome do mês em português
     * @return nome da estação correspondente
     */
    private static String retornarEstacao(String mes){
        switch (mes){
            case "Dezembro":
            case "Janeiro":
            case "Fevereiro":
                return "Verao";
            case "Março":
            case "Abril":
            case "Maio":
                return "Outono";
            case "Junho":
            case "Julho":
            case "Agosto":
                return "Inverno";
            case "Setembro":
            case "Outubro":
            case "Novembro":
                return "Primavera";
            default:
                return "desconhecido";
        }

    }
    /**
 * Processa a lista de climas utilizando HashMaps para contabilizar
 * precipitação e temperatura por estação, inicializando os valores em zero.
 * Exibe no console a estação que mais chove, menos chove,
 * mais quente, mais amena e mais fria.
 *
 * @param climas lista de objetos Clima a ser processada
 */
    public static void processarClimas(ArrayList<Clima> climas){

        HashMap<String, Integer> somaChuva = new HashMap<>();
        HashMap<String, Integer> contQuente = new HashMap<>();
        HashMap<String, Integer> contFrio = new HashMap<>();
        HashMap<String, Integer> contAmeno = new HashMap<>();

    for(String est : new String[]{"Verao", "Outono", "Inverno", "Primavera"}){
        somaChuva.put(est, 0);
        contQuente.put(est, 0);
        contFrio.put(est, 0);
        contAmeno.put(est, 0);
    }
    //percorrer o array de climas
    for(Clima c : climas) {
        String estacao = retornarEstacao(c.mes);
        somaChuva.put(estacao, somaChuva.get(estacao) + c.precipitacao);
        contQuente.put(estacao, contQuente.get(estacao) + (c.temperatura.equals("Quente") ? 1 : 0));
        contFrio.put(estacao, contFrio.get(estacao) + (c.temperatura.equals("Frio") ? 1 : 0));
        contAmeno.put(estacao, contAmeno.get(estacao) + (c.temperatura.equals("Ameno") ? 1 : 0));

    }
    System.out.println("Estação que mais chove: " + maiorDoMapa(somaChuva));
    System.out.println("Estação que menos chove: " + menorDoMapa(somaChuva));
    System.out.println("Estação mais quente: " + maiorDoMapa(contQuente));
    System.out.println("Estação mais Amena: " + maiorDoMapa(contAmeno));
    System.out.println("Estação mais fria: " + maiorDoMapa(contFrio));
    

    }
    /**
     * Retorna a estação com o maior valor no HashMap informado.
    * Percorre todas as entradas e retorna a chave com maior valor.
    *
    * @param mapa HashMap com estações e seus valores
    * @return nome da estação com maior valor
    */
    public static String maiorDoMapa(HashMap<String, Integer> mapa) {
        String maior = "";
        int valor = 0;
        for(String estacao : mapa.keySet()){
            if(mapa.get(estacao) > valor){
                valor = mapa.get(estacao);
                maior = estacao;
            }
        }
        return maior;
    }
        /**
    * Retorna a estação com o menor valor no HashMap informado.
    * Utiliza Integer.MAX_VALUE como valor inicial para garantir
    * que qualquer valor real seja menor na comparação.
    *
    * @param menorMapa HashMap com estações e seus valores
    * @return nome da estação com menor valor
    */
    public static String menorDoMapa(HashMap<String, Integer> menorMapa){
        String menor = "";
        int valorMenor = Integer.MAX_VALUE;//maior numero possivel para nao quebrar a logica
        for(String estacao : menorMapa.keySet()){
            if(menorMapa.get(estacao) < valorMenor){
                valorMenor = menorMapa.get(estacao);
                menor = estacao;
            }
        }
        return menor;
    }

}