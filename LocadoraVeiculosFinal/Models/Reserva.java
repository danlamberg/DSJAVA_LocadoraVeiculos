package Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDate dataReserva;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private StatusReserva status;

    public Reserva(Veiculo veiculo, Cliente cliente, LocalDate dataReserva, LocalDate dataInicio, LocalDate dataFim) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataReserva = dataReserva;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = StatusReserva.PENDENTE; // Assumindo que o status inicial seja PENDENTE
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }
}
