package coelho;

import java.util.Date;

public class Reembolso {
	private double valor;
	private Date data;
	
	public Reembolso(double valor) {
		this.valor = valor;
		data = new Date();	
	}

	public double getValor() {
		return valor;
	}

	public Date getData() {
		return data;
	}
}
