package Models;

import java.io.Serializable;

public class Caminhao extends Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private double capacidadeCarga;
    private int numEixos;

    public Caminhao(String marca, String modelo, int ano, double valorDiaria, String placa, double capacidadeCarga, int numEixos) {
        super(marca, modelo, ano, valorDiaria, placa);
        this.capacidadeCarga = capacidadeCarga;
        this.numEixos = numEixos;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        this.numEixos = numEixos;
    }

    @Override
    public String getTipoVeiculo() {
        return "Caminhão";
    }

    @Override
    public String toString() {
        return super.toString() + " - " +
                "Capacidade de Carga: " + capacidadeCarga +
                ", Num. Eixos: " + numEixos;
    }
}
