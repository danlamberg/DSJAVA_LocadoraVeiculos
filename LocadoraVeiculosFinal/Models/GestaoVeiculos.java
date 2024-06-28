package Models;

import java.util.ArrayList;
import java.util.List;

public class GestaoVeiculos {
    private List<Veiculo> veiculos;

    public GestaoVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }
}
