package Controllers;

import Models.*;

import java.util.List;

public class VeiculoController {
    private GestaoVeiculos gestaoVeiculos;

    public VeiculoController(GestaoVeiculos gestaoVeiculos) {
        this.gestaoVeiculos = gestaoVeiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        gestaoVeiculos.adicionarVeiculo(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        gestaoVeiculos.removerVeiculo(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return gestaoVeiculos.listarVeiculos();
    }
}
