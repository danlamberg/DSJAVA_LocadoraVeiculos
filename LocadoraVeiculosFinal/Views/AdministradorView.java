package Views;

import Controllers.AdministradorController;
import Controllers.GestaoVeiculosController;
import Models.Administrador;
import Models.Aluguel;
import Models.Funcionario;
import Models.Cliente;
import Models.Veiculo;
import Models.GestaoVeiculos;
import Models.Reserva;
import Utils.ArquivoUtil;

import java.util.List;
import java.util.Scanner;

public class AdministradorView {
    private AdministradorController administradorController;
    private GestaoVeiculosController gestaoVeiculosController;
    private Scanner scanner;

    public AdministradorView(GestaoVeiculos gestaoVeiculos) {
        this.administradorController = new AdministradorController(gestaoVeiculos);
        this.gestaoVeiculosController = new GestaoVeiculosController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuAdministrador() {
        Administrador administrador = autenticarAdministrador();
        if (administrador != null) {
            System.out.println("Login realizado com sucesso!");
            exibirMenu(administrador);
            salvarDados(); // Salvar dados ao sair do menu do administrador
        } else {
            System.out.println("Login ou senha incorretos. Tente novamente.");
            exibirMenuAdministrador();
        }
    }

    private Administrador autenticarAdministrador() {
        System.out.println("### Autenticação do Administrador ###");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return administradorController.realizarLogin(login, senha);
    }

    private void exibirMenu(Administrador administrador) {
        int opcao;
        do {
            System.out.println("\n### Menu Administrador ###");
            System.out.println("Selecione a operação desejada:");
            System.out.println("1 - Adicionar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Listar Veículos");
            System.out.println("0 - Voltar");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    listarVeiculos(); // Chamada para listar veículos
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarFuncionario() {
        System.out.println("\n### Cadastro de Funcionário ###");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, cpf, cargo, login, senha);

        administradorController.adicionarFuncionario(novoFuncionario, login, senha);

        System.out.println("Funcionário adicionado com sucesso:");
        System.out.println(novoFuncionario);
    }

    private void listarFuncionarios() {
        List<Funcionario> funcionarios = administradorController.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("\n### Lista de Funcionários ###");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    private void listarClientes() {
        List<Cliente> clientes = administradorController.listarClientes();
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("\n### Lista de Clientes ###");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private void listarVeiculos() {
        System.out.println("\n### Listando Veículos ###");
        gestaoVeiculosController.getVeiculos().forEach(System.out::println);
    }

    private void salvarDados() {
        List<Funcionario> funcionarios = administradorController.listarFuncionarios();
        List<Aluguel> alugueis = administradorController.listarAlugueis();
        List<Reserva> reservas = administradorController.listarReservas();
        List<Cliente> clientes = administradorController.listarClientes();
        List<Veiculo> veiculos = gestaoVeiculosController.getVeiculos();

        ArquivoUtil.salvarDados(funcionarios, alugueis, reservas, clientes, veiculos);
    }
}
