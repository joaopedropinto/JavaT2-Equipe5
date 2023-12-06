package coelho;

import java.util.Date;

public class Reparo {
    private String descricao;
    private String previsao;
    private Date dataInicio;
    private Date dataFim;
    private boolean resolvido;
    private Falha falhaAssociada;

    public Reparo(String descricao, String previsao, Falha falhaAssociada) {
        this.descricao = descricao;
        this.previsao = previsao;
        this.resolvido = false;
        this.dataInicio = new Date();
        this.falhaAssociada = falhaAssociada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public Falha getFalhaAssociada() {
        return falhaAssociada;
    }

    public void setFalhaAssociada(Falha falhaAssociada) {
        this.falhaAssociada = falhaAssociada;
    }
}
