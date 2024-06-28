package Models;

import java.util.List;

public class Relatorio {

    public void gerarRelatorioOperacional() {
        // Lógica para gerar relatório operacional
        System.out.println("Gerando relatório operacional da locadora...");
        // Exemplo: listar aluguéis, reservas, avaliações, etc.
    }

    public void gerarRelatorioEstatistico(List<Aluguel> alugueis, List<Reserva> reservas, List<Avaliacao> avaliacoes) {
        // Lógica para gerar relatório estatístico
        System.out.println("Gerando relatório estatístico da locadora...");

        int totalAlugueis = alugueis.size();
        int totalReservas = reservas.size();
        int totalAvaliacoes = avaliacoes.size();

        System.out.println("Total de Aluguéis: " + totalAlugueis);
        System.out.println("Total de Reservas: " + totalReservas);
        System.out.println("Total de Avaliações: " + totalAvaliacoes);

        // Exemplo: calcular média de avaliações, etc.
    }

    // Outros métodos conforme necessário para gerar relatórios específicos
}
