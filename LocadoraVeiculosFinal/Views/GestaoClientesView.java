package Views;

import Controllers.GestaoClientesController;
import Models.Cliente;

import java.util.List;

public class GestaoClientesView {
    private GestaoClientesController gestaoClientesController;

    public GestaoClientesView(GestaoClientesController gestaoClientesController) {
        this.gestaoClientesController = gestaoClientesController;
    }

    public void adicionarCliente(Cliente cliente) {
        gestaoClientesController.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso.");
    }

    public void removerCliente(Cliente cliente) {
        gestaoClientesController.removerCliente(cliente);
        System.out.println("Cliente removido com sucesso.");
    }

    public void listarClientes() {
        List<Cliente> clientes = gestaoClientesController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(cliente -> System.out.println(cliente.toString()));
        }
    }
}
