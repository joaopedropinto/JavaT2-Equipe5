package coelho;
import java.util.*;

public class Cliente {
	
    private String cpf;
    private String nome;
	private ArrayList<Imovel> imoveis;

    
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.imoveis = new ArrayList<>();
    }
    
    public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}

	public void adicionarImovel(Imovel imovel) {
		imoveis.add(imovel);
	}

	public void excluiImovel(Imovel imovel) {
		imoveis.remove(imovel);
	}
	
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    
}
