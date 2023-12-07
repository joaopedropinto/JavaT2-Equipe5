package coelho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorFalhas {
    private List<Falha> listaFalhas;

    public GerenciadorFalhas() {
        this.listaFalhas = new ArrayList<>();
    }

    public void registrarFalha(String tipo, String descricao, String previsao) {
        Falha novaFalha = new Falha(tipo, descricao, previsao);
        novaFalha.setDataInicio(new Date()); // Defina a data de início como a data atual
        listaFalhas.add(novaFalha);
    }

    public List<Falha> listarFalhasEmAberto() {
        List<Falha> falhasEmAberto = new ArrayList<>();
        for (Falha falha : listaFalhas) {
            if (!falha.isResolvida()) {
                falhasEmAberto.add(falha);
            }
        }
        return falhasEmAberto;
    }
}
