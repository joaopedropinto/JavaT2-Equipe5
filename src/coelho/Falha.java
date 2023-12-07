package coelho;

import java.util.Date;

public class Falha {
    private String tipo; 
    private String descricao;
    private boolean resolvida;
    private String previsao;
    private Date dataInicio;
    private Date dataFim;
    private Imovel imovel;

    public Falha(Imovel imovel, String tipo, String descricao, String previsao) {
        this.imovel = imovel;
    	this.tipo = tipo;
        this.descricao = descricao;
        this.previsao = previsao;
        this.resolvida = false;
        this.dataInicio = new Date();
    }

    public Imovel getImovel() {
		return imovel;
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