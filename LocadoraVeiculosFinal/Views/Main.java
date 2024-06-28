package Views;

import Controllers.AdministradorController;
import Models.GestaoVeiculos;
import Utils.ArquivoUtil;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GestaoVeiculos gestaoVeiculos = new GestaoVeiculos();
    private static AdministradorController administradorController;

    public static void main(String[] args) {
        administradorController = new AdministradorController(gestaoVeiculos); 

        
        carregarDados();

       
        exibirMenuPrincipal();

       
        salvarDados();

        System.out.println("Sistema encerrado.");
    }

    private static void carregarDados() {
        ArquivoUtil.carregarDados(
                administradorController.listarFuncionarios(),
                administradorController.listarAlugueis(),
                administradorController.listarReservas(),
                administradorController.listarClientes(),
                gestaoVeiculos.listarVeiculos()
        );
    }

    private static void salvarDados() {
        ArquivoUtil.salvarDados(
                administradorController.listarFuncionarios(),
                administradorController.listarAlugueis(),
                administradorController.listarReservas(),
                administradorController.listarClientes(),
                gestaoVeiculos.listarVeiculos()
        );
    }

    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n### Menu Principal ###");
            System.out.println("Selecione o tipo de usuário:");
            System.out.println("1 - Administrador");
            System.out.println("2 - Funcionário");
            System.out.println("3 - Cliente");
            System.out.println("0 - Sair");

            opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    realizarLoginAdministrador();
                    break;
                case 2:
                    realizarLoginFuncionario();
                    break;
                case 3:
                    realizarLoginCliente();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static int obterOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            scanner.next(); 
        }
        int opcao = scanner.nextInt();
        scanner.nextLine(); 
        return opcao;
    }

    private static void realizarLoginAdministrador() {
        AdministradorView administradorView = new AdministradorView(gestaoVeiculos);
        administradorView.exibirMenuAdministrador();
    }

    private static void realizarLoginFuncionario() {
        FuncionarioView funcionarioView = new FuncionarioView();
        funcionarioView.realizarLogin();
    }

    private static void realizarLoginCliente() {
        ClienteView clienteView = new ClienteView();
        clienteView.exibirMenuCliente();
    }
}
