package br.com.gabriel.ifsp.correctionoftest2.model;

public final class DespesaEducacao extends Despesa {
    public static final double DEDUCAO_MAX = 2000.0;

    private final String nomeInstituicao;

    public DespesaEducacao(int id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Nome instituição: " + nomeInstituicao;
    }
}
