package Controllers;

import Models.*;

import java.util.List;

public class GestaoVeiculosController {
    private GestaoVeiculos gestaoVeiculos;

    public GestaoVeiculosController() {
        this.gestaoVeiculos = new GestaoVeiculos();
        inicializarVeiculosFixosDisponiveis();
    }

    private void inicializarVeiculosFixosDisponiveis() {
        gestaoVeiculos.adicionarVeiculo(new Carro("Volkswagen", "Gol G4", 2018, 100.0, "ABC-1234", 4));
        gestaoVeiculos.adicionarVeiculo(new Carro("Volkswagen", "Jetta", 2024, 190.0, "DEF-5678", 4));
        gestaoVeiculos.adicionarVeiculo(new Carro("Renault", "Kwid", 2021, 120.0, "GHI-9012", 4));
        gestaoVeiculos.adicionarVeiculo(new Carro("Hyundai", "HB20", 2020, 150.0, "JKL-3456", 4));
        gestaoVeiculos.adicionarVeiculo(new Moto("Honda", "CG Fan", 2020, 90.0, "MNO-6789", 160));
        gestaoVeiculos.adicionarVeiculo(new Moto("Yamaha", "Yamaha Fazer", 2020, 130.0, "PQR-1234", 250));
        gestaoVeiculos.adicionarVeiculo(new Caminhao("Scania", "R450", 2025, 25.0, "STU-5678", 300.0, 6));
        gestaoVeiculos.adicionarVeiculo(new Caminhao("Volvo", "FH540", 2025, 30.0, "VWX-9012", 350.0, 6));
    }

    public void adicionarCarro(String marca, String modelo, int ano, double valorDiaria, String placa, int numPortas) {
        Carro carro = new Carro(marca, modelo, ano, valorDiaria, placa, numPortas);
        gestaoVeiculos.adicionarVeiculo(carro);
    }

    public void adicionarMoto(String marca, String modelo, int ano, double valorDiaria, String placa, int cilindradas) {
        Moto moto = new Moto(marca, modelo, ano, valorDiaria, placa, cilindradas);
        gestaoVeiculos.adicionarVeiculo(moto);
    }

    public void adicionarCaminhao(String marca, String modelo, int ano, double valorDiaria, String placa, double capacidadeCarga, int numEixos) {
        Caminhao caminhao = new Caminhao(marca, modelo, ano, valorDiaria, placa, capacidadeCarga, numEixos);
        gestaoVeiculos.adicionarVeiculo(caminhao);
    }

    public void removerVeiculo(Veiculo veiculo) {
        gestaoVeiculos.removerVeiculo(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return gestaoVeiculos.listarVeiculos();
    }

    public void listarVeiculosConsole() {
        gestaoVeiculos.listarVeiculos().forEach(System.out::println);
    }
}
