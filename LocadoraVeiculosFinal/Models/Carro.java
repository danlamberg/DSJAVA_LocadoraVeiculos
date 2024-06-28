package Models;

import java.io.Serializable;

public class Carro extends Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numPortas;

    public Carro(String marca, String modelo, int ano, double valorDiaria, String placa, int numPortas) {
        super(marca, modelo, ano, valorDiaria, placa);
        this.numPortas = numPortas;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    @Override
    public String getTipoVeiculo() {
        return "Carro";
    }

    @Override
    public String toString() {
        return super.toString() + " - " +
                "Num. Portas: " + numPortas;
    }
}
