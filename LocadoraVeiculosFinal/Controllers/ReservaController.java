package Controllers;

import Models.Reserva;
import Models.StatusReserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaController {
    private List<Reserva> reservas;

    public ReservaController() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    public void atualizarStatusReserva(Reserva reserva, StatusReserva novoStatus) {
        reserva.setStatus(novoStatus);
    }
}
