package Views;

import Controllers.ClienteController;
import Models.*;
import Utils.ArquivoUtil;

import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class ClienteView {
    private final Scanner scanner;
    private final ClienteController clienteController;
    private Cliente clienteLogado;

    public ClienteView() {
        this.scanner = new Scanner(System.in);
        this.clienteController = new ClienteController();
    }

    public void exibirMenuCliente() {
        int opcao;
        do {
            System.out.println("\n### Menu Cliente ###");
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2 - Login");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            switch (opcao) {
                case 1:
                    exibirMenuCadastroCliente();
                    break;
                case 2:
                    realizarLogin();
                    if (clienteLogado != null) {
                        exibirMenuPrincipal();
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private void exibirMenuCadastroCliente() {
        int opcao;
        do {
            System.out.println("\n### Cadastro de Cliente ###");
            System.out.println("Selecione o tipo de cliente:");
            System.out.println("1 - Cliente PF");
            System.out.println("2 - Cliente PJ");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            switch (opcao) {
                case 1:
                    cadastrarClientePF();
                    break;
                case 2:
                    cadastrarClientePJ();
                    break;
                case 0:
                    System.out.println("Voltando ao menu cliente...");
                    return; // Retorna ao menu do cliente
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private void realizarLogin() {
        System.out.println("\n### Login ###");
        System.out.print("CPF/CNPJ: ");
        String documento = scanner.nextLine();
    
        clienteLogado = clienteController.verificarCredenciais(documento);
    
        if (clienteLogado != null) {
            System.out.println("Login realizado com sucesso!");
            // Exibir mensagem de boas-vindas
            System.out.println("\nSeja bem-vindo, " + clienteLogado.getNome() + "!"); // Aqui assume que Cliente tem um método getNome()
            exibirMenuPrincipal();
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
        }
    }
    

    private void exibirMenuPrincipal() {
        if (clienteLogado == null) {
            System.out.println("Você deve estar logado para acesso a este menu.");
            return;
        }

        int opcao;
        do {
            System.out.println("\n### Operações de Cliente ###");
            System.out.println("Selecione a operação desejada:");
            System.out.println("1 - Alugar Veículo");
            System.out.println("2 - Reservar Veículo");
            System.out.println("3 - Pagar Locação");
            System.out.println("4 - Menu Avaliação");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarAluguel();
                    break;
                case 2:
                    realizarReserva();
                    break;
                case 3:
                    pagarLocacao();
                    break;
                case 4:
                    exibirMenuAvaliacao();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    salvarDados();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private void realizarReserva() {
        System.out.println("\n### Realizar Reserva ###");

        Veiculo veiculo = selecionarVeiculo();
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.print("Data de início da reserva (AAAA-MM-DD): ");
        String dataInicioStr = scanner.nextLine();
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);

        System.out.print("Data de fim da reserva (AAAA-MM-DD): ");
        String dataFimStr = scanner.nextLine();
        LocalDate dataFim = LocalDate.parse(dataFimStr);

        LocalDate dataReserva = LocalDate.now();
        StatusReserva status = StatusReserva.PENDENTE;

        Reserva reserva = new Reserva(veiculo, clienteLogado, dataReserva, dataInicio, dataFim);
        clienteController.realizarReserva(reserva);

        System.out.println("Reserva realizada com sucesso para o veículo:");
        System.out.println(veiculo);

        veiculo.setDisponivel(false); 
    }

    private void realizarAluguel() {
        System.out.println("\n### Realizar Aluguel ###");
        Veiculo veiculo = selecionarVeiculo();
    
        if (clienteLogado != null && veiculo != null) {
            String clienteId = clienteLogado.getLogin(); 
            String veiculoId = veiculo.getPlaca(); 
            Date dataAluguel = new Date(); // Data atual
            Date dataDevolucaoPrevista = new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000);
            double valorTotal = 200.0; 
            
            Aluguel aluguel = new Aluguel(clienteId, veiculoId, dataAluguel, dataDevolucaoPrevista, valorTotal);
            clienteController.realizarAluguel(aluguel);
            System.out.println("Veículo alugado com sucesso para o cliente " + clienteLogado.getNome());
        } else {
            System.out.println("Não foi possível realizar o aluguel.");
        }
    }

    private void pagarLocacao() {
        System.out.println("\n### Pagar Locação ###");
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1 - Boleto");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Cartão de Débito");
        System.out.println("4 - Transferência Bancária");
        System.out.println("5 - PIX");

        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Pagamento realizado com sucesso.");
    }

    private void exibirMenuAvaliacao() {
        System.out.println("\n### Menu Avaliação ###");
        System.out.println("Selecione a opção de avaliação:");
        System.out.println("1 - Avaliar Veículo");
        System.out.println("2 - Avaliar Serviço");
        System.out.println("0 - Voltar");

        int opcaoAvaliacao = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoAvaliacao) {
            case 1:
                avaliarVeiculo();
                break;
            case 2:
                avaliarServico();
                break;
            case 0:
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                break;
        }
    }

    private void avaliarVeiculo() {
        System.out.println("\n### Avaliar Veículo ###");
        System.out.println("Digite a placa do veículo que deseja avaliar:");
        String placa = scanner.nextLine();
        System.out.println("Digite sua avaliação sobre o veículo (de 1 a 5):");
        System.out.println("1 - Insatisfeito, 3 - Satisfeito, 5 - Totalmente satisfeito");
        int avaliacao = scanner.nextInt();
        scanner.nextLine();

        if (avaliacao >= 1 && avaliacao <= 5) {
            String mensagem;
            if (avaliacao == 1) {
                mensagem = "Insatisfeito";
            } else if (avaliacao == 3) {
                mensagem = "Satisfeito";
            } else if (avaliacao == 5) {
                mensagem = "Totalmente Satisfeito";
            } else {
                mensagem = "Avaliação inválida";
            }
            System.out.println("Avaliação do veículo com placa " + placa + ": " + mensagem);
        } else {
            System.out.println("Valor de avaliação inválido. Por favor, escolha um valor de 1 a 5.");
        }
    }

    private void avaliarServico() {
        System.out.println("\n### Avaliar Serviço ###");
        System.out.println("Descreva sua experiência com o serviço:");
        String descricao = scanner.nextLine();
        System.out.println("Avaliação enviada: " + descricao);
    }

    private Veiculo selecionarVeiculo() {
        String placa = "ABC-1234";
        String modelo = "Modelo Exemplo";
        String marca = "Marca Exemplo";
        int ano = 2020;
        double valorDiaria = 100.0;
        int numPortas = 4;

        Carro carro = new Carro(marca, modelo, ano, valorDiaria, placa, numPortas);
        return carro;
    }

    private void cadastrarClientePF() {
        System.out.println("\n### Cadastro de Cliente PF ###");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        ClientePF clientePF = new ClientePF(nome, cpf, telefone, rua, numero, cidade, estado, cep);
        clienteController.adicionarCliente(clientePF);
        System.out.println("Cliente PF cadastrado com sucesso.");

        clienteLogado = clientePF;

        exibirMenuPrincipal();
    }

    private void cadastrarClientePJ() {
        System.out.println("\n### Cadastro de Cliente PJ ###");
        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        ClientePJ clientePJ = new ClientePJ(razaoSocial, cnpj, telefone, rua, numero, cidade, estado, cep);
        clienteController.adicionarCliente(clientePJ);
        System.out.println("Cliente PJ cadastrado com sucesso.");

        clienteLogado = clientePJ;

        exibirMenuPrincipal();
    }

    private void salvarDados() {
        ArquivoUtil.salvarDados(
                null, // Coloque os dados que você deseja salvar aqui
                clienteController.listarAlugueis(),
                clienteController.listarReservas(),
                clienteController.listarClientes(),
                clienteController.getGestaoVeiculos().listarVeiculos()
        );
        System.out.println("Dados salvos com sucesso.");
    }
}
