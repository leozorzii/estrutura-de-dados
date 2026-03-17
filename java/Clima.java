import java.util.Objects;

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

    @Override
    public String toString() {
        return "Clima{" +
                "ano='" + ano + '\'' +
                ", mes='" + mes + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", precipitacao=" + precipitacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clima clima = (Clima) o;
        return Objects.equals(ano, clima.ano) && Objects.equals(mes, clima.mes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, mes);
    }
}

