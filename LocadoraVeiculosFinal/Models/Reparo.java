package Models;

import java.util.Date;

public class Reparo {
    private Date data;
    private String descricao;
    private boolean concluido;
    private double custoEstimado;

    public Reparo(Date data, String descricao, boolean concluido, double custoEstimado) {
        this.data = data;
        this.descricao = descricao;
        this.concluido = concluido;
        this.custoEstimado = custoEstimado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public double getCustoEstimado() {
        return custoEstimado;
    }

    public void setCustoEstimado(double custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    @Override
    public String toString() {
        return "Reparo{" +
                "data=" + data +
                ", descricao='" + descricao + '\'' +
                ", concluido=" + concluido +
                ", custoEstimado=" + custoEstimado +
                '}';
    }
}
