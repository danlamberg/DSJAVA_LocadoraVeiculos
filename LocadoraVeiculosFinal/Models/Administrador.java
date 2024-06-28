package Models;

public class Administrador implements Autenticavel {
    private String nome;
    private Endereco endereco;
    private String cpf;
    private String cargo;
    private String senha;

    // Construtor para inicialização completa
    public Administrador(String nome, Endereco endereco, String cpf, String cargo, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cargo = cargo;
        this.senha = senha;
    }

    // Construtor para inicialização simplificada (apenas nome e senha)
    public Administrador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    // Getters e Setters omitidos para brevidade

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", cpf='" + cpf + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

    // Implementação do método da interface Autenticavel
    @Override
    public boolean autenticar(String login, String senha) {
        return this.nome.equals(login) && this.senha.equals(senha);
    }
}
