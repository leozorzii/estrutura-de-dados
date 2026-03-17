import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



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
     * Analisa a lista de climas e exibe no console:
     * a estação que mais chove, a que menos chove,
     * a mais quente e a mais amena.
     * @param climas lista de objetos Clima a ser analisada
     */
    public static void analisarDados(ArrayList<Clima> climas){
        int somaVerao = 0;
        int somaOutono =0;
        int somaInverno = 0 ;

        int quenteVerao = 0;
        int quenteOutono = 0;
        int quenteInverno = 0;

        int amenoVerao = 0;
        int amenoOutono = 0;
        int amenoInverno = 0;

        int somasPrimavera = 0;
        int quentePrimavera = 0;
        int amenoPrimavera = 0;

        //percorrer o array de climas
        for(Clima c : climas) {
            String estacao = retornarEstacao(c.mes);
            if(estacao.equals("Verao")) {
                somaVerao += c.precipitacao;
        }else if(estacao.equals("Outono")) {
                somaOutono += c.precipitacao;
            } else if (estacao.equals("Inverno")) {
                somaInverno += c.precipitacao;
            }else if(estacao.equals("Primavera")) {
                somasPrimavera += c.precipitacao;
            }
            //Quente
            if(estacao.equals("Verao") &&  c.temperatura.equals("Quente")){
                quenteVerao++;
            } else if (estacao.equals("Outono") && c.temperatura.equals("Quente")) {
                quenteOutono++;
            }else if(estacao.equals("Inverno") && c.temperatura.equals("Quente")){
                quenteInverno++;
            }else if(estacao.equals("Primavera") && c.temperatura.equals("Quente")){
                quentePrimavera++;
            }
            //AMENO
            if(estacao.equals("Verao") &&  c.temperatura.equals("Ameno")){
                amenoVerao++;
            } else if (estacao.equals("Outono") && c.temperatura.equals("Ameno")) {
                amenoOutono++;
            }else if(estacao.equals("Inverno") && c.temperatura.equals("Ameno")){
                amenoInverno++;
            } else if(estacao.equals("Primavera") && c.temperatura.equals("Ameno") ) {
                amenoPrimavera++;
            }
        }
        if(somaVerao > somaOutono && somaVerao > somaInverno && somaVerao > somasPrimavera){
            System.out.println("estação que mais chove é o verão!");
        } else if (somaOutono > somaVerao && somaOutono > somaInverno && somaOutono > somasPrimavera) {
            System.out.println("Estação que mais chove é o outono");
        }else if(somaInverno > somaVerao && somaInverno > somaOutono && somaInverno > somasPrimavera){
            System.out.println("Estação que mais chove é o Inverno");
        } else {
            System.out.println("Estação que mais chove é a primavera");
        }


        if(somaVerao < somaOutono && somaVerao < somaInverno && somaVerao < somasPrimavera){
            System.out.println("Estação que menos chove é o Verão");
        } else if (somaOutono < somaVerao && somaOutono < somaInverno && somaOutono < somasPrimavera) {
            System.out.println("Estação que menos chove é o Outono");
        } else if(somaInverno < somaVerao && somaInverno < somaOutono && somaInverno < somasPrimavera){
            System.out.println("Estação que menos chove é o Inverno");
        }else{
            System.out.println("Estação que menos chove é a primavera");
        }


        if(quenteVerao > quenteOutono && quenteVerao > quenteInverno && quenteVerao > quentePrimavera){
            System.out.println("Estação mais quente é o Verão");
        } else if (quenteOutono > quenteVerao && quenteOutono > quenteInverno && quenteOutono > quentePrimavera) {
            System.out.println("Estação mais quente é o Outono");
        } else if(quenteInverno > quenteVerao && quenteInverno > quenteOutono && quenteInverno > quentePrimavera){
            System.out.println("Estação mais quente é o Inverno");
        }else{
            System.out.println("Estação mais quente é a primavera");
        }

        //ameno

        if(amenoVerao > amenoOutono && amenoVerao > amenoInverno && amenoVerao > amenoPrimavera){
            System.out.println("Estação mais amena é o verão");
        }else if(amenoOutono > amenoVerao && amenoOutono > amenoInverno && amenoOutono >amenoPrimavera){
            System.out.println("Estação mais amena é o outono");
        }else if(amenoInverno > amenoVerao && amenoInverno > amenoOutono && amenoInverno > amenoPrimavera){
            System.out.println("Estação mais amena é o inverno");
        }else{
            System.out.println("Estação mais amena é a primavera");
        }
    }

}