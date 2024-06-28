package Models;

import java.util.Date;

public class Manutencao {
    private Date data;
    private String descricao;
    private double custo;

    public Manutencao(Date data, String descricao, double custo) {
        this.data = data;
        this.descricao = descricao;
        this.custo = custo;
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

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return "Manutenção{" +
                "data=" + data +
                ", descricao='" + descricao + '\'' +
                ", custo=" + custo +
                '}';
    }
}
