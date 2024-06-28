package Controllers;

import Models.*;

import java.util.List;

public class GestaoClientesController {
    private GestaoClientes gestaoClientes;

    public GestaoClientesController(GestaoClientes gestaoClientes) {
        this.gestaoClientes = gestaoClientes;
    }

    public void adicionarCliente(Cliente cliente) {
        gestaoClientes.adicionarCliente(cliente);
    }

    public void removerCliente(Cliente cliente) {
        gestaoClientes.removerCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return gestaoClientes.getClientes();
    }

    public void listarClientesConsole() {
        gestaoClientes.listarClientes();
    }
}
