package Models;

import java.util.List;

public class Estatisticas {

    public double calcularMediaAvaliacoes(List<Avaliacao> avaliacoes) {
        // Lógica para calcular a média das avaliações
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }

        double somaAvaliacoes = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            somaAvaliacoes += avaliacao.getNota();
        }

        return somaAvaliacoes / avaliacoes.size();
    }

    public int contarTotalAlugueis(List<Aluguel> alugueis) {
        // Lógica para contar o total de aluguéis
        return alugueis.size();
    }

    public int contarTotalReservas(List<Reserva> reservas) {
        // Lógica para contar o total de reservas
        return reservas.size();
    }

    // Outros métodos conforme necessário para calcular outras estatísticas
}
