package aula11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * classe que gerencia cadastro, listagem e troca entre colecionadores de figurinhas
 */

public class GerenciadorFigurinhas {

        private  List <Figurinha> repetidasPessoais = new ArrayList<>();
        private  List <Figurinha> desejadasPessoais = new ArrayList<>();
        private  final String REPETIDAS = "aula11/figurinhasRepetidas.csv"; 
        private  final String DESEJADAS = "aula11/figurinhasDesejadas.csv"; 

    /**
    * Inicializa o gerenciador carregando as figurinhas repetidas e desejadas dos arquivos CSV.
     */
    public GerenciadorFigurinhas(){
        carregarArquivo(REPETIDAS, repetidasPessoais);
        carregarArquivo(DESEJADAS, desejadasPessoais);
    }
    /**
     * Metodo que faz o cadastro da figurinha
     * 
     * @param leitor - leitor Scanner utilizado para leitura dos dados do usuário
     * @param lista - lista para salvar as entradas do teclado
     * @param arquivo - para salvar os dados da lista no arquivo
     */
    private void cadastrar(Scanner leitor, List<Figurinha> lista, String arquivo){
        System.out.print("Selecao: ");
        String selecao = leitor.nextLine();
        System.out.print("Numero: ");
        int num = leitor.nextInt();
        leitor.nextLine();
        System.out.print("Descricao: ");
        String desc = leitor.nextLine();
        System.out.print("Quantidade: ");
        int qtd = leitor.nextInt();
        leitor.nextLine();
        System.out.print("Rara(s/n): ");
        boolean rara = leitor.nextLine().equals("s") ? true : false;

        Figurinha f = new Figurinha(selecao, num, desc, qtd, rara);
           lista.add(f);
           salvarListaArquivo(arquivo, f);
    }
    /**
     * Metodo que cadastra figurinhas repetidas
     * @param leitor Scanner utilizado para leitura dos dados do usuário
     */
    public void cadastrarRepetida(Scanner leitor){
        cadastrar(leitor, repetidasPessoais, REPETIDAS);
    }
     /**
     * Metodo que cadastra figurinhas desejadas
     * @param leitor Scanner utilizado para leitura dos dados do usuário
     */
    public void cadastrarDesejada(Scanner leitor){
        cadastrar(leitor, desejadasPessoais, DESEJADAS);
    }
     /**
     * Metodo que lista figurinhas
     * @param lista  serve para verificar se esta vazia e listar
     */
        private void listar(List<Figurinha> lista){
            if(lista.isEmpty()){
                System.out.println("lista vazia");
            }
            for(Figurinha figura : lista){
            System.out.println("Figurinha: " + figura);
            }
        }
        /**
     * Metodo que lista figurinhas repetidas
     */
        public void listarRepetidas(){
            listar(repetidasPessoais);
        }
        /**
     * Metodo que lista figurinhas desejadas
     */
        public void listarDesejadas(){
            listar(desejadasPessoais);
        }
        /**
     * Metodo que salva a lista de figurinhas em um arquivo
     * @param nomeArquivo  parametro que recebe o arquivo para salvar
     * @param f  instancia a figurinha para vir formatada
     */
        private void salvarListaArquivo(String nomeArquivo, Figurinha f){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo, true))){
            bw.write(f.paraCSV());
            bw.newLine();
            }catch(IOException e){
                System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
            }
        }
         /**
     * Metodo que carrega a lista de figurinhas do arquivo
     * @param nomeArquivo  parametro que carrega o arquivo
     * @param lista  parametro que carrega a lista do arquivo
     */
        private void carregarArquivo(String nomeArquivo, List<Figurinha> lista){
            File file = new File(nomeArquivo);
            if(!file.exists()){
                return;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
                String linha;
                while((linha = br.readLine()) != null){
                String[] dados = linha.split(", ");
                String selecao = dados[0].trim();
                int numero = Integer.parseInt(dados[1].trim());
                String descricao = dados[2].trim();
                int qtd = Integer.parseInt(dados[3].trim());
                boolean rara = Boolean.parseBoolean(dados[4].trim());
                lista.add(new Figurinha(selecao, numero, descricao, qtd, rara));
                }
            }catch(IOException e){
                System.out.println("erro ao carregar: " + nomeArquivo);
            }
        }
         /**
     * Metodo que verifica se a lista de figurinhas tem combinacao com outro
     * @param leitor Scanner utilizado para leitura dos dados do usuário
     * @param minhaListaDeFig  parametro que le as figurinhas da minha lista
     */
        private void verificarCombinacaoFig(Scanner leitor, List<Figurinha> minhaListaDeFig){
            System.out.println("Caminho do arquivo do outro colega: ");
            String caminho = leitor.nextLine();
            List<Figurinha> listaOutro = new ArrayList<>();
            carregarArquivo(caminho, listaOutro);

            System.out.println("Figuras do Outro: ");
            System.out.println("---------------");
            listar(listaOutro);

            System.out.println("Combinações encontradas:");
            System.out.println("-----------------------");
            for(Figurinha figOutro : listaOutro){
                for(Figurinha figMinha : minhaListaDeFig){
                    if(figOutro.getNumeroFigura() == figMinha.getNumeroFigura() && figOutro.getNomeSelecao().equalsIgnoreCase(figMinha.getNomeSelecao())){
                        System.out.println("Troca permitida: " + figOutro);
                    }
                }
            }
        }
        /**
     * Metodo que verifica se a lista de figurinhas repetidas tem combinacao com outro
     *@param leitor Scanner utilizado para leitura dos dados do usuário
     */
        public void verificarRepetidasOutro(Scanner leitor){
            verificarCombinacaoFig(leitor, desejadasPessoais);
        }
        /**
     * Metodo que verifica se a lista de figurinhas desejadas tem combinacao com outro
     * @param leitor Scanner utilizado para leitura dos dados do usuário
     */
        public void verificarDesejadasOutro(Scanner leitor){
            verificarCombinacaoFig(leitor, repetidasPessoais);
        }
}
