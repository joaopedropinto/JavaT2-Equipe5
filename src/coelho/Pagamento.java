package coelho;
import java.util.*;

public class Pagamento {
    private String matriculaFatura;
    private double valor;
    private Date data;
    private boolean reembolso;

    public Pagamento(String matriculaFatura, double valor) {
        this.matriculaFatura = matriculaFatura;
        this.valor = valor;
        this.data = new Date();
        this.reembolso = false;
    }

    public String getMatriculaFatura() {
        return matriculaFatura;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public boolean isReembolso() {
        return reembolso;
    }
}
