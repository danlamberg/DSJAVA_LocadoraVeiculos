package Models;

public class Seguro {
    private String tipo;
    private double valor;
    private String detalhes;

    public Seguro(String tipo, double valor, String detalhes) {
        this.tipo = tipo;
        this.valor = valor;
        this.detalhes = detalhes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", detalhes='" + detalhes + '\'' +
                '}';
    }
}
