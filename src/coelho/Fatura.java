package coelho;

import java.util.*;

public class Fatura {

	private Date dataEmissao;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private double valor;
    private boolean quitada;
    private Imovel imovel;
    
    public Fatura(double ultimaLeitura, double penultimaLeitura, Imovel imovel) {
    	
        this.dataEmissao = new Date();
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.valor = calcularValor();
        this.quitada = false;
        this.imovel = imovel;
    }
    
    private double calcularValor() {
        
        return 10 * (ultimaLeitura - penultimaLeitura);
    }
    
    public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public double getUltimaLeitura() {
		return ultimaLeitura;
	}

	public void setUltimaLeitura(double ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}

	public double getPenultimaLeitura() {
		return penultimaLeitura;
	}

	public void setPenultimaLeitura(double penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isQuitada() {
		return quitada;
	}

	public void setQuitada(boolean quitada) {
		this.quitada = quitada;
	}
}
