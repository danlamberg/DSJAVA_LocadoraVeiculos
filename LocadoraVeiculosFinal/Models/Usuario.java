package Models;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão para garantir compatibilidade serial

    protected String nome;
    protected String cpf;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha, String cpf) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
