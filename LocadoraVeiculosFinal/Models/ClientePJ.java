package Models;

import java.io.Serializable;

public class ClientePJ extends Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cnpj;

    // Construtor com argumentos
    public ClientePJ(String nome, String cnpj, String telefone, String rua, String numero, String cidade, String estado, String cep) {
        super(nome, new Endereco(rua, numero, cidade, estado, cep), telefone);
        this.cnpj = cnpj;
    }

    // Construtor sem argumentos para serialização
    public ClientePJ() {
        super(null, new Endereco(null, null, null, null, null), null);
    }

    // Getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getIdentificacao() {
        return cnpj;
    }

    @Override
    public String getLogin() {
        return cnpj;
    }
}
