package aula12;
import java.util.TreeSet;

public class Arvore {
    public static void main(String Args[]){
        TreeSet<Integer> arvore = new TreeSet<>();
        arvore.add(5);
        arvore.add(10);
        arvore.add(15);
        arvore.add(7);
        arvore.add(20);
        arvore.add(25);
        arvore.add(3);
        arvore.add(30);
        System.out.println(arvore);

        
        for(Integer elemento : arvore){
            System.out.println("elemento: " + elemento);
        }
        if(arvore.contains(10)){
            System.out.println("a arvore contem elemento 10");
        }else{
            System.out.println("a arvore nao contem elemento 10");
        }
        arvore.remove(10);
    }
}
