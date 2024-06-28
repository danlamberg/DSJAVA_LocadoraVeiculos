package Controllers;

import Models.*;
import Utils.ArquivoUtil;

import java.util.ArrayList;
import java.util.List;

public class AdministradorController {
    private List<Administrador> administradores;
    private FuncionarioController funcionarioController;
    private ClienteController clienteController;
    private AluguelController aluguelController;
    private ReservaController reservaController;
    private GestaoVeiculos gestaoVeiculos;

    public AdministradorController(GestaoVeiculos gestaoVeiculos) {
        this.administradores = new ArrayList<>();
        this.funcionarioController = new FuncionarioController();
        this.clienteController = new ClienteController();
        this.aluguelController = new AluguelController();
        this.reservaController = new ReservaController();
        this.gestaoVeiculos = gestaoVeiculos; 

        
        Administrador adminPadrao = new Administrador("admin", "senha123");
        administradores.add(adminPadrao);
    }

   

    public void adicionarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public void removerAdministrador(Administrador administrador) {
        administradores.remove(administrador);
    }

    public List<Administrador> listarAdministradores() {
        return administradores;
    }

   

    public Administrador realizarLogin(String login, String senha) {
        for (Administrador administrador : administradores) {
            if (administrador.autenticar(login, senha)) {
                return administrador;
            }
        }
        return null;
    }



    public void adicionarFuncionario(Funcionario funcionario, String loginPadrao, String senhaPadrao) {
        funcionarioController.adicionarFuncionario(funcionario, loginPadrao, senhaPadrao);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioController.listarFuncionarios();
    }


    public List<Cliente> listarClientes() {
        return clienteController.listarClientes();
    }



    public void adicionarAluguel(Aluguel aluguel) {
        aluguelController.adicionarAluguel(aluguel);
    }

    public List<Aluguel> listarAlugueis() {
        return aluguelController.listarAlugueis();
    }


    public void adicionarReserva(Reserva reserva) {
        reservaController.adicionarReserva(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaController.listarReservas();
    }

    public void salvarDados() {
        ArquivoUtil.salvarDados(
                funcionarioController.listarFuncionarios(),
                aluguelController.listarAlugueis(),
                reservaController.listarReservas(),
                clienteController.listarClientes(),
                gestaoVeiculos.listarVeiculos()
        );
    }
    
    public void carregarDados() {
        ArquivoUtil.carregarDados(
                funcionarioController.listarFuncionarios(),
                aluguelController.listarAlugueis(),
                reservaController.listarReservas(),
                clienteController.listarClientes(),
                gestaoVeiculos.listarVeiculos() 
        );
    }
}
