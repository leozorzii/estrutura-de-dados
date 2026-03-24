import java.util.Objects;
/**
 * Representa um registro climático mensal.
 * Contém informações de ano, mês, temperatura e precipitação.
 * Dois objetos Clima são considerados iguais se possuírem
 * o mesmo ano e mês.
 */
public class Clima {
    String ano;//2024 2025 2026
    String mes;
    String temperatura; //frio(ate 15 graus), quente(acima de 25), ameno(16 a 25)
    int precipitacao; //nada, pouca(ate 20mm), media(21 a 40mm), muita(mais de 40)

        public Clima(String ano, String mes, String temperatura, int precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public int getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(int precipitacao) {
        this.precipitacao = precipitacao;
    }

    /**
 * Converte o objeto Clima em uma representação textual,
 * exibindo todos os atributos: ano, mês, temperatura e precipitação.
 *
 * @return String com os dados do objeto Clima
 */
    @Override
    public String toString() {
        return "Clima{" +
                "ano='" + ano + '\'' +
                ", mes='" + mes + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", precipitacao=" + precipitacao +
                '}';
    }

    /**
 * Verifica se dois objetos Clima são iguais,
 * comparando apenas o ano e o mês.
 *
 * @param o objeto a ser comparado
 * @return true se ano e mês forem iguais, false caso contrário
 */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clima clima = (Clima) o;
        return Objects.equals(ano, clima.ano) && Objects.equals(mes, clima.mes);
    }

    /**
 * Gera um código hash baseado no ano e mês do objeto.
 * Objetos com mesmo ano e mês produzirão o mesmo hash,
 * sendo utilizados em coleções como HashSet e HashMap.
 *
 * @return código hash do objeto
 */
    @Override
    public int hashCode() {
        return Objects.hash(ano, mes);
    }
}

