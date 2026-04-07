package aula07;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Classe principal do sistema de atendimento com fichas.
 * Inicializa as filas e delega o controle ao menu de FichaService.
 */
public class FichaAtendimento {

    public static void main(String[] args) {
        // Fila para clientes sem prioridade
        Queue<Integer> filaNormal = new LinkedList<>();

        // Fila para clientes com prioridade (ex: idosos, gestantes)
        Queue<Integer> filaPrioritaria = new LinkedList<>();

        // Inicia o menu de atendimento
        FichaService.menu(filaNormal, filaPrioritaria);
    }
}
