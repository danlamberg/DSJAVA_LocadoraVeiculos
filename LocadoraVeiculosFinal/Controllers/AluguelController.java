package Controllers;

import Models.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelController {
    private List<Aluguel> alugueis;

    public AluguelController() {
        this.alugueis = new ArrayList<>();
    }

    public void adicionarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public List<Aluguel> listarAlugueis() {
        return alugueis;
    }
}
