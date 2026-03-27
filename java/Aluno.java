public class Aluno{
   private String nome;
   private String email;

   public void aluno(String nome){
    this.nome = nome;
    this.email = gerarEmail(nome);
   }


    private String gerarEmail(String email){
        String [] partes = nome.toLowerCase().split(" ");
        if(partes.length > 1){
        return partes[0] + "." + partes[partes.length - 1] + "@ufn.edu.br";
        }
        return partes[0] + "@ufn.edu.br";
    }
    //gettter e setter para acessar dados privados
    public String getNome(){return nome;}
    public String getEmail(){return email;}

    public void setNome(String nome){
        this.nome = nome;
        this.email = gerarEmail(nome);
    }
    public void setEmail(String email){this.email = email;}

    @Override
    public String toString(){
        return "Aluno: " + nome + "email: " + email;
    }
}