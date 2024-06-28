package Models;

public class Pagamento {

    private double valor;
    private MetodoPagamento metodoPagamento;

    public Pagamento(double valor, MetodoPagamento metodoPagamento) {
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    @Override
    public String toString() {
        return "Valor: R$ " + valor + " | Método de Pagamento: " + metodoPagamento;
    }
}
