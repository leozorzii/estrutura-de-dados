package aula11;

import java.util.Scanner;

/**
 * ponto de origem do programa de gerenciamento de figurinha
 */
public class Main {

       /**
        * inicializa o gerenciador de figurinhas e faz exibição do menu interativo ao usuário
        * @param Args argumentos que sao passados pela linha de comando
        */
    public static void main(String Args[]){
        String opcao;
        Scanner teclado = new Scanner(System.in);
        GerenciadorFigurinhas gerenciador = new GerenciadorFigurinhas();

        do{
           System.out.println("MENU FIGS DA COPA 2026");
           System.out.println("1 - cadastrar figs repetidas(pessoais)");
           System.out.println("2 - Listar figs repetidas");
           System.out.println("3 - cadastrar figuras desejadas pessoais");
           System.out.println("4 - listar figs desejadas pessoais");
           System.out.println("5 - carregar, listar e mostrar match(pessoais)");
           System.out.println("6 - carregar figuras desejadas do Outro");
           System.out.println("7 - sair");
           System.out.println("Opcao: ");
           opcao = teclado.nextLine();

           switch(opcao){
            case "1":
                gerenciador.cadastrarRepetida(teclado);
                break;
                case "2":
                gerenciador.listarRepetidas();
                break;
            case "3":
                gerenciador.cadastrarDesejada(teclado);
                break;
            case "4":
                gerenciador.listarDesejadas();
                break;
            case "5":
                gerenciador.verificarRepetidasOutro(teclado);
                break;
            case "6":
                 gerenciador.verificarDesejadasOutro(teclado);
                break;
           }

            
    }while(!opcao.equals("7"));
    }
    
    }


