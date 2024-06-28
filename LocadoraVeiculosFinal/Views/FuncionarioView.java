package Views;

import Controllers.FuncionarioController;
import Controllers.GestaoVeiculosController;
import Controllers.AluguelController; 
import Models.Aluguel;
import Models.Cliente;
import Models.Funcionario;
import Models.Reserva;
import Models.Veiculo;
import Utils.ArquivoUtil;

import java.util.List;
import java.util.Scanner;

public class FuncionarioView {
    private Funcionario funcionarioLogado;
    private FuncionarioController funcionarioController;
    private GestaoVeiculosController gestaoVeiculosController;
    private AluguelController aluguelController; 
    private Scanner scanner;

    public FuncionarioView() {
        this.funcionarioController = new FuncionarioController();
        this.gestaoVeiculosController = new GestaoVeiculosController();
        this.aluguelController = new AluguelController(); 
        this.scanner = new Scanner(System.in);
        this.funcionarioLogado = null;
    }

    public void realizarLogin() {
        System.out.println("\n### Login do Funcionário ###");
        for (int tentativas = 3; tentativas > 0; tentativas--) {
            System.out.print("Digite seu login: ");
            String login = scanner.nextLine();

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            funcionarioLogado = funcionarioController.realizarLogin(login, senha);

            if (funcionarioLogado != null) {
                System.out.println("Login realizado com sucesso!");
                exibirMenuFuncionario();
                return; // Sai do método após login bem-sucedido
            } else {
                System.out.println("Login ou senha incorretos. Tentativas restantes: " + (tentativas - 1));
            }
        }
        System.out.println("Número de tentativas excedido. Encerrando login.");
    }

    public void exibirMenuFuncionario() {
        int opcao;
        do {
            System.out.println("\n### Menu do Funcionário ###");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar Carro");
            System.out.println("2 - Adicionar Moto");
            System.out.println("3 - Adicionar Caminhão");
            System.out.println("4 - Listar Veículos");
            System.out.println("0 - Voltar ao Menu Principal");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    adicionarMoto();
                    break;
                case 3:
                    adicionarCaminhao();
                    break;
                case 4:
                    listarVeiculos();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);

        salvarDados(); 
    }

    private void adicionarCarro() {
        System.out.println("\n### Adicionando Carro ###");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor da Diária: ");
        double valorDiaria = Double.parseDouble(scanner.nextLine());
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Número de Portas: ");
        int numPortas = Integer.parseInt(scanner.nextLine());

        gestaoVeiculosController.adicionarCarro(marca, modelo, ano, valorDiaria, placa, numPortas);
        System.out.println("Carro adicionado com sucesso!");
    }

    private void adicionarMoto() {
        System.out.println("\n### Adicionando Moto ###");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor da Diária: ");
        double valorDiaria = Double.parseDouble(scanner.nextLine());
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Cilindradas: ");
        int cilindradas = Integer.parseInt(scanner.nextLine());

        gestaoVeiculosController.adicionarMoto(marca, modelo, ano, valorDiaria, placa, cilindradas);
        System.out.println("Moto adicionada com sucesso!");
    }

    private void adicionarCaminhao() {
        System.out.println("\n### Adicionando Caminhão ###");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor da Diária: ");
        double valorDiaria = Double.parseDouble(scanner.nextLine());
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Capacidade de Carga: ");
        double capacidadeCarga = Double.parseDouble(scanner.nextLine());
        System.out.print("Número de Eixos: ");
        int numEixos = Integer.parseInt(scanner.nextLine());

        gestaoVeiculosController.adicionarCaminhao(marca, modelo, ano, valorDiaria, placa, capacidadeCarga, numEixos);
        System.out.println("Caminhão adicionado com sucesso!");
    }

    private void listarVeiculos() {
        System.out.println("\n### Listando Veículos ###");
        gestaoVeiculosController.getVeiculos().forEach(System.out::println);
    }

    private void salvarDados() {
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        List<Aluguel> alugueis = funcionarioController.listarAlugueis();
        List<Reserva> reservas = funcionarioController.listarReservas();
        List<Cliente> clientes = funcionarioController.listarClientes();
        List<Veiculo> veiculos = gestaoVeiculosController.getVeiculos();

        ArquivoUtil.salvarDados(funcionarios, alugueis, reservas, clientes, veiculos);
    }
}
