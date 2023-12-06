package coelho;

import java.util.Date;

public class Falha {
    private String tipo; // Geração ou Distribuição"
    private String descricao;
    private boolean resolvida;
    private String previsao;
    private Date dataInicio;
    private Date dataFim;

    public Falha(String tipo, String descricao, String previsao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.previsao = previsao;
        this.resolvida = false;
        this.dataInicio = new Date();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isResolvida() {
        return resolvida;
    }

    public void setResolvida(boolean resolvida) {
        this.resolvida = resolvida;
    }

    public String getPrevisao() {
        return previsao;
    }

    public void setPrevisao(String previsao) {
        this.previsao = previsao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
