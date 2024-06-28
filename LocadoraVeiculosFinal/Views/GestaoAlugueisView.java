package Views;

import Controllers.GestaoAlugueisController;
import Models.ClientePF;
import Models.Veiculo;

import java.time.LocalDate;

public class GestaoAlugueisView {
    private GestaoAlugueisController gestaoAlugueisController;

    public GestaoAlugueisView(GestaoAlugueisController gestaoAlugueisController) {
        this.gestaoAlugueisController = gestaoAlugueisController;
    }

    public void alugarVeiculo(Veiculo veiculo, ClientePF cliente, LocalDate dataAluguel, LocalDate dataDevolucao) {
        gestaoAlugueisController.alugarVeiculo(veiculo, cliente, dataAluguel, dataDevolucao);
     
    }
}
