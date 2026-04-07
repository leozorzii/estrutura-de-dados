import java.util.Scanner;

public class MainAluno{
    public static void cadastrarAlunos(Aluno[]lista, Scanner leitor){
        for(int i =0; i < lista.length; i++){
            lista[i] = new Aluno();
            System.out.println("Digite o nome do Aluno: " + (i+1) + ": ");
            lista[i].setNome(leitor.nextLine());
        }
    }
    public static void main(String [] args){
        Scanner leitor = new Scanner(System.in);
        Aluno [] lista = new Aluno[3];

         cadastrarAlunos(lista, leitor);

        for(Aluno aluno : lista){
            System.out.println("Nome do Aluno: " + aluno.getNome()); 
            System.out.println("Email do Aluno: " + aluno.getEmail()); 
        }
    }
}