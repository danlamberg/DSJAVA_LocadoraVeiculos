package Controllers;

import Models.*;

import java.time.LocalDate;

public class AgendamentoController {
    public void agendarVeiculo(Veiculo veiculo, Cliente cliente, LocalDate dataPrevista, double valorTotal) {
        
        Agendamento agendamento = new Agendamento(veiculo, cliente, LocalDate.now(), dataPrevista, valorTotal);
        
    }
}
