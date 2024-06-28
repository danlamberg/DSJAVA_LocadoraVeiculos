package Models;

import java.io.Serializable;

public class ClientePF extends Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cpf;

    // Construtor com argumentos
    public ClientePF(String nome, String cpf, String telefone, String rua, String numero, String cidade, String estado, String cep) {
        super(nome, new Endereco(rua, numero, cidade, estado, cep), telefone);
        this.cpf = cpf;
    }

    // Construtor sem argumentos para serialização
    public ClientePF() {
        super(null, new Endereco(null, null, null, null, null), null);
    }

    // Getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getIdentificacao() {
        return cpf;
    }

    @Override
    public String getLogin() {
        return cpf;
    }
}
