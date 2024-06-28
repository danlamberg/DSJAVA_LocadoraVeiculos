package Controllers;

import Models.Aluguel;
import Models.Cliente;
import Models.ClientePF;
import Models.Veiculo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class GestaoAlugueisController {
    private final List<Aluguel> listaAlugueis;

    public GestaoAlugueisController(List<Aluguel> listaAlugueis) {
        this.listaAlugueis = listaAlugueis;
    }

    public void alugarVeiculo(Veiculo veiculo, Cliente cliente, LocalDate dataAluguel, LocalDate dataDevolucao) {
        double valorTotal = calcularValorTotal(veiculo, dataAluguel, dataDevolucao);

        Date dataInicio = Date.from(dataAluguel.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataFim = Date.from(dataDevolucao.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Aluguel aluguel = new Aluguel(cliente.getIdentificacao(), veiculo.getPlaca(), dataInicio, dataFim, valorTotal);
        
        listaAlugueis.add(aluguel);

        System.out.println("Veículo alugado com sucesso:\n" + aluguel);
    }

    private double calcularValorTotal(Veiculo veiculo, LocalDate dataAluguel, LocalDate dataDevolucao) {
        long diasAluguel = dataAluguel.until(dataDevolucao).getDays();
        double valorDiaria = veiculo.getValorDiaria();
        return diasAluguel * valorDiaria;
    }

    public List<Aluguel> listarAlugueis() {
        return listaAlugueis;
    }
}
