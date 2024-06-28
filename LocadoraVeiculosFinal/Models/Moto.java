package Models;

import java.io.Serializable;

public class Moto extends Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int cilindradas;

    public Moto(String marca, String modelo, int ano, double valorDiaria, String placa, int cilindradas) {
        super(marca, modelo, ano, valorDiaria, placa);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String getTipoVeiculo() {
        return "Moto";
    }

    @Override
    public String toString() {
        return super.toString() + " - " +
                "Cilindradas: " + cilindradas;
    }
}
