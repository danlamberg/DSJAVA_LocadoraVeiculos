package Controllers;

import Models.*;
import Utils.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;
    private List<Aluguel> alugueis;
    private ReservaController reservaController;
    private GestaoVeiculos gestaoVeiculos;

    public ClienteController() {
        
        this.clientes = ArquivoUtil.carregarClientes();
        if (this.clientes == null) {
            this.clientes = new ArrayList<>(); 
        }
        
      
        this.alugueis = ArquivoUtil.carregarAlugueis();
        if (this.alugueis == null) {
            this.alugueis = new ArrayList<>(); 
        }
        
    
        this.reservaController = new ReservaController();
        this.gestaoVeiculos = new GestaoVeiculos();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente verificarCredenciais(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getLogin().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    public void realizarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public void realizarReserva(Reserva reserva) {
        reservaController.adicionarReserva(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaController.listarReservas();
    }

    public GestaoVeiculos getGestaoVeiculos() {
        return gestaoVeiculos;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Aluguel> listarAlugueis() {
        return alugueis;
    }

    public void salvarDados() {
        ArquivoUtil.salvarClientes(clientes);
        ArquivoUtil.salvarAlugueis(alugueis);
        ArquivoUtil.salvarReservas(reservaController.listarReservas());
    }
}
