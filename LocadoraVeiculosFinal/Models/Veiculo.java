package Models;

import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    private String marca;
    private String modelo;
    private int ano;
    private double valorDiaria;
    private boolean disponivel;
    private String placa; // Novo atributo para armazenar a placa do veículo

    // Construtor
    public Veiculo(String marca, String modelo, int ano, double valorDiaria, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = true; // Por padrão, veículo está disponível ao ser criado
        this.placa = placa;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public abstract String getTipoVeiculo();
}
