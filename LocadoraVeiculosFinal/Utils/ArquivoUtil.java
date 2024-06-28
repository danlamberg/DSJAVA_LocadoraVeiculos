package Utils;

import Models.*;

import java.io.*;
import java.util.List;

public class ArquivoUtil {
    private static final String DIRETORIO_DADOS = "Dados";
    private static final String ARQUIVO_ALUGUEIS = DIRETORIO_DADOS + "/alugueis.dat";
    private static final String ARQUIVO_RESERVAS = DIRETORIO_DADOS + "/reservas.dat";
    private static final String ARQUIVO_CLIENTES = DIRETORIO_DADOS + "/clientes.dat";
    private static final String ARQUIVO_VEICULOS = DIRETORIO_DADOS + "/veiculos.dat";
    private static final String ARQUIVO_FUNCIONARIOS = DIRETORIO_DADOS + "/funcionarios.dat";

    static {
        criarDiretorioSeNaoExistir(DIRETORIO_DADOS);
    }

    private static void criarDiretorioSeNaoExistir(String diretorio) {
        File directory = new File(diretorio);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void salvarAlugueis(List<Aluguel> alugueis) {
        salvarObjeto(alugueis, ARQUIVO_ALUGUEIS);
    }

    public static List<Aluguel> carregarAlugueis() {
        return carregarObjeto(ARQUIVO_ALUGUEIS);
    }

    public static void salvarReservas(List<Reserva> reservas) {
        salvarObjeto(reservas, ARQUIVO_RESERVAS);
    }

    public static List<Reserva> carregarReservas() {
        return carregarObjeto(ARQUIVO_RESERVAS);
    }

    public static void salvarClientes(List<Cliente> clientes) {
        salvarObjeto(clientes, ARQUIVO_CLIENTES);
    }

    public static List<Cliente> carregarClientes() {
        return carregarObjeto(ARQUIVO_CLIENTES);
    }

    public static void salvarVeiculos(List<Veiculo> veiculos) {
        salvarObjeto(veiculos, ARQUIVO_VEICULOS);
    }

    public static List<Veiculo> carregarVeiculos() {
        return carregarObjeto(ARQUIVO_VEICULOS);
    }

    public static void salvarFuncionarios(List<Funcionario> funcionarios) {
        salvarObjeto(funcionarios, ARQUIVO_FUNCIONARIOS);
    }

    public static List<Funcionario> carregarFuncionarios() {
        return carregarObjeto(ARQUIVO_FUNCIONARIOS);
    }

    private static <T> void salvarObjeto(List<T> lista, String caminhoArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> carregarObjeto(String caminhoArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void carregarDados(List<Funcionario> funcionarios, List<Aluguel> alugueis,
                                     List<Reserva> reservas, List<Cliente> clientes, List<Veiculo> veiculos) {
        List<Funcionario> funcionariosCarregados = carregarFuncionarios();
        if (funcionariosCarregados != null) {
            funcionarios.addAll(funcionariosCarregados);
        }

        List<Aluguel> alugueisCarregados = carregarAlugueis();
        if (alugueisCarregados != null) {
            alugueis.addAll(alugueisCarregados);
        }

        List<Reserva> reservasCarregadas = carregarReservas();
        if (reservasCarregadas != null) {
            reservas.addAll(reservasCarregadas);
        }

        List<Cliente> clientesCarregados = carregarClientes();
        if (clientesCarregados != null) {
            clientes.addAll(clientesCarregados);
        }

        List<Veiculo> veiculosCarregados = carregarVeiculos();
        if (veiculosCarregados != null) {
            veiculos.addAll(veiculosCarregados);
        }
    }

    public static void salvarDados(List<Funcionario> funcionarios, List<Aluguel> alugueis,
                                   List<Reserva> reservas, List<Cliente> clientes, List<Veiculo> veiculos) {
        salvarFuncionarios(funcionarios);
        salvarAlugueis(alugueis);
        salvarReservas(reservas);
        salvarClientes(clientes);
        salvarVeiculos(veiculos);
    }
}
