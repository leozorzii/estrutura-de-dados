package aula07;

import java.util.Scanner;
import java.util.Queue;

/**
 * Servico responsavel pela logica de geracao e chamada de fichas de atendimento.
 * Utiliza duas filas: uma normal e uma prioritaria.
 * A cada 3 atendimentos, um prioritario e chamado primeiro.
 */
public class FichaService {

    /**
     * Metodo de classe que gera uma ficha normal e a adiciona na fila.
     * @param filaNormal - fila contendo fichas ditas nao prioritarias
     * @param contadorNormal - controla o numero de fichas
     * @return proximo numero de ficha normal a ser gerado
     */
 public static int geraFichaNormal(Queue<Integer> filaNormal, int contadorNormal) {
        System.out.print("Imprimindo ficha normal.... ");
        System.out.println(contadorNormal);
        filaNormal.offer(contadorNormal);
        contadorNormal++;
        return contadorNormal;
    }
    /**
     * Metodo de classe que gera uma ficha prioritaria e a adiciona na fila.
     * @param filaPrioritaria - fila que contem fichas prioritarias
     * @param contadorPrioritario - controla o numero de fichas prioritarias
     * @return proximo numero de ficha prioritaria a ser gerado
     */
    public static int geraFichaPrioritaria(Queue<Integer> filaPrioritaria, int contadorPrioritario) {
        System.out.print("Imprimindo ficha prioritaria.... ");
        System.out.println(contadorPrioritario);
        filaPrioritaria.offer(contadorPrioritario);
        contadorPrioritario++;
        return contadorPrioritario;
    }
        /**
         * metodo de uma classe que simula o atendimento verificando se as filas nao estao vazias
         * @param filaNormal - fila que contem fichas normais
         * @param filaPrioritaria - fila que contem fichas prioritarias
         * @param contadorAtendimentos - variavel contadora
         * @return quantidade de atendimentos totais
         */
    public static int geraAtendimento(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria, int contadorAtendimentos) {
        if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) {
            System.out.println("Nao ha fichas para chamar");
            return contadorAtendimentos;
        }
        System.out.print("Chamando ficha.... ");
        int ficha;
        if (contadorAtendimentos % 3 == 0 || filaNormal.isEmpty()) {
            //chamar prioritario
            if (!filaPrioritaria.isEmpty()) {
                ficha = filaPrioritaria.poll();
                System.out.println(" PRIORITARIA: "+ ficha);
                contadorAtendimentos++;
                return contadorAtendimentos;
            }
        } 
        if (!filaNormal.isEmpty()) {
            ficha = filaNormal.poll();
            System.out.println(" NORMAL: "+ ficha);
            contadorAtendimentos++;
        }
        return contadorAtendimentos;
    }
    /**
     * metodo de um classe que mostra quais fichas estao na sequencia
     * @param filaNormal - fila que contem fichas normais
     * @param filaPrioritaria -  fila que contem fichas prioritarias
     */
    public static void mostrarFichasFaltantes(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria){
        if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) {
        System.out.println("Nao ha fichas para chamar");
            return;
        }
        System.out.println("Mostrando fichas faltantes.... ");
        if (!filaNormal.isEmpty()) {
            System.out.println("Total de fichas faltantes NORMAL... " + filaNormal.size() + " - " + filaNormal);
        }
        if (!filaPrioritaria.isEmpty()) {
            System.out.println("Total de fichas faltantes PRIORITARIA... " + filaPrioritaria.size() + " - " + filaPrioritaria);
        }
    }

    /**
     * Metodo de classe que exibe o menu e gerencia as opcoes do usuario em loop.
     * @param filaNormal - fila de atendimento normal
     * @param filaPrioritaria - fila de atendimento prioritario
     */
    public static void menu(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria) {
        String opcao = "";
        Scanner teclado = new Scanner(System.in);
        int contadorPrioritario = 501;
        int contadorNormal = 1;
        int contadorAtendimentos = 0; 

        do {
            System.out.println("M E N U");
            System.out.println("1 - Ficha normal");
            System.out.println("2 - Ficha prioritaria");
            System.out.println("3 - Chamar ficha");
            System.out.println("4 - Mostrar fichas faltantes");
            System.out.println("5 - Sair");
            System.out.print("Opcao: ");
            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    contadorNormal = geraFichaNormal(filaNormal, contadorNormal);
                    break;
                case "2":
                    contadorPrioritario = geraFichaPrioritaria(filaPrioritaria, contadorPrioritario);
                    break;
                case "3":
                    contadorAtendimentos = geraAtendimento(filaNormal, filaPrioritaria, contadorAtendimentos);
                    break;
                case "4":
                    mostrarFichasFaltantes(filaNormal, filaPrioritaria);
                    break;
                case "5":
                    System.out.println("saindo... ");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (!opcao.equals("5"));

        teclado.close();
    }
 }