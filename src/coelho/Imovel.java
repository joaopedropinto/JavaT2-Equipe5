package coelho;

public class Imovel {
	private String matricula;
	private String endereco;
   	private double ultimaLeitura;
    private double penultimaLeitura;

    public Imovel(String matricula, String endereco, double ultimaLeitura, double penultimaLeitura) {
        this.matricula = matricula;
    	this.endereco = endereco;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
    }
    
    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setUltimaLeitura(double ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}

	public void setPenultimaLeitura(double penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}

	

    public String getEndereco() {
        return endereco;
    }

    public double getUltimaLeitura() {
        return ultimaLeitura;
    }

    public double getPenultimaLeitura() {
        return penultimaLeitura;
    }
}
