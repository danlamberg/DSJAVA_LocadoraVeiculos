package Controllers;

import Models.Aluguel;
import Models.Cliente;
import Models.Funcionario;
import Models.Reserva;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios;
    private AluguelController aluguelController;

    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
        this.aluguelController = new AluguelController(); // Instância do controlador de aluguéis
        // Adiciona um funcionário padrão para teste
        Funcionario funcionarioPadrao = new Funcionario("Atendente Padrão", "00000000000", "Atendente", "atendente", "senha123");
        funcionarios.add(funcionarioPadrao);
    }

    public void adicionarFuncionario(Funcionario funcionario, String login, String senha) {
        funcionario.setLogin(login);
        funcionario.setSenha(senha);
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado: " + funcionario);
    }

    public Funcionario realizarLogin(String login, String senha) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
                return funcionario;
            }
        }
        return null;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public List<Aluguel> listarAlugueis() {
        return aluguelController.listarAlugueis();
    }

    public List<Reserva> listarReservas() {
        
        return new ArrayList<>();
    }

    public List<Cliente> listarClientes() {
        
        return new ArrayList<>();
    }
}
