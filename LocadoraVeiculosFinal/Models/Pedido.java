package Models;

import java.time.LocalDate;

public class Pedido {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDate dataPedido;
    private double valorTotal;

    public Pedido(Veiculo veiculo, Cliente cliente, LocalDate dataPedido, double valorTotal) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", dataPedido=" + dataPedido +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
