package Models;

import java.io.Serializable;
import java.util.Date;

public class Aluguel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clienteId;
    private String veiculoId;
    private Date dataInicio;
    private Date dataFim;
    private double valorTotal; // Adicionado para armazenar o valor total do aluguel

    public Aluguel(String clienteId, String veiculoId, Date dataInicio, Date dataFim, double valorTotal) {
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(String veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "clienteId='" + clienteId + '\'' +
                ", veiculoId='" + veiculoId + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
