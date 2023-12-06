package coelho;
import java.util.*;

public class Pagamento {
	private double valor;
	private Date data;
	private Reembolso reembolso;

	public Pagamento(double valor) {
		this.valor = valor;
		data = new Date();
	}

	public void criaReembolso(double valor) {
		reembolso = new Reembolso(valor);
	}
	
	public Reembolso getReembolso() {
		return reembolso;
	}

	public double getValor() {
		return valor;
	}


	public Date getData() {
		return data;
	}
	
	
}
