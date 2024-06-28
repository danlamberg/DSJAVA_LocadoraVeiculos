package Models;

import java.util.Date;

public class Avaliacao {
    private Date data;
    private String tipo; // Pode ser "Veículo" ou "Atendimento"
    private int nota;
    private String comentario;

    public Avaliacao(Date data, String tipo, int nota, String comentario) {
        this.data = data;
        this.tipo = tipo;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliação{" +
                "data=" + data +
                ", tipo='" + tipo + '\'' +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
