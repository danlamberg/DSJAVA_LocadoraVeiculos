package Models;

import java.time.LocalDate;

public class Agendamento {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDate dataAgendamento;
    private LocalDate dataPrevista;
    private double valorTotal;

    public Agendamento(Veiculo veiculo, Cliente cliente, LocalDate dataAgendamento, LocalDate dataPrevista, double valorTotal) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataAgendamento = dataAgendamento;
        this.dataPrevista = dataPrevista;
        this.valorTotal = valorTotal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", dataAgendamento=" + dataAgendamento +
                ", dataPrevista=" + dataPrevista +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
