package aula11;
/**
 * classe que representa uma figurinha do álbum da Copa do Mundo 2026.
 */
public class Figurinha{
   private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean figRara;
  /**
   * construtor que define os atributos da figurinha 
   * @param nomeSelecao nome da selecao da figurinha
   * @param numeroFigura numero da figurinha 
   * @param descricao  descricao da figurinha 
   * @param quantidade quantidade de copias disponiveis da figurinha 
   * @param figRara raridade da figurinha 
    */  
public Figurinha(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean figRara){
    this.nomeSelecao = nomeSelecao;
    this.numeroFigura = numeroFigura;
    this.descricao = descricao;
    this.quantidade = quantidade;
    this.figRara = figRara;
    }
/**
 *  metodo que retorna formatado os atributos das figurinhas
 * @return linha no formato CSV para persistencia em arquivo
 */
public String paraCSV(){
    return nomeSelecao + ", " + numeroFigura + ", " + descricao + ", " + quantidade + ", " + figRara;
    }
    /**
    metodo que retorna representação da figurinha para exibição no console.
    *  @return String formatada com número, seleção, descrição, quantidade e indicação de raridade
     */
    @Override
    public String toString(){
        return String.format("[%d], %s - %s (%d) %s",
            numeroFigura, nomeSelecao, descricao, quantidade, figRara ? "[RARA]" : "");
    }
    /**
     * metodo get para buscar nome da selacao
     * @return nome da selecao da figurinha
     */
    public String getNomeSelecao() {
        return nomeSelecao;
    }
      /**
     * metodo get para buscar numero da figurinha
     * @return numero da figurinha
     */
    public int getNumeroFigura() {
        return numeroFigura;
    }
  /**
     * metodo get para buscar descricao da figurinha
     * @return descritivo da figurinha
     */
    public String getDescricao() {
        return descricao;
    }
  /**
     * metodo get para quantidade da figurinha
     * @return quantidade daquela figurinha
     */
    public int getQuantidade() {
        return quantidade;
    }
  /**
     * metodo get para buscar se a fig é rara
     * @return é figurinha rara
     */
    public boolean isFigRara() {
        return figRara;
    }
}
