package Models;

import java.time.LocalDate;

public class Documentacao {
    private String numeroDocumento;
    private LocalDate dataExpedicao;
    private String orgaoExpedidor;
    private boolean seguroObrigatorio;

    public Documentacao(String numeroDocumento, LocalDate dataExpedicao, String orgaoExpedidor, boolean seguroObrigatorio) {
        this.numeroDocumento = numeroDocumento;
        this.dataExpedicao = dataExpedicao;
        this.orgaoExpedidor = orgaoExpedidor;
        this.seguroObrigatorio = seguroObrigatorio;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public boolean isSeguroObrigatorio() {
        return seguroObrigatorio;
    }

    public void setSeguroObrigatorio(boolean seguroObrigatorio) {
        this.seguroObrigatorio = seguroObrigatorio;
    }

    @Override
    public String toString() {
        return "Documentacao{" +
                "numeroDocumento='" + numeroDocumento + '\'' +
                ", dataExpedicao=" + dataExpedicao +
                ", orgaoExpedidor='" + orgaoExpedidor + '\'' +
                ", seguroObrigatorio=" + (seguroObrigatorio ? "Sim" : "Não") +
                '}';
    }
}
