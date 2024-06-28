package Models;

import java.io.Serializable;

public class Funcionario extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão para garantir compatibilidade serial

    private String cargo;

    public Funcionario(String nome, String cpf, String cargo, String login, String senha) {
        super(nome, login, senha, cpf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cargo='" + cargo + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
