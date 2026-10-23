package br.com.gabriel.ifsp.correctionoftest2.model;

public final class DespesaSaude extends Despesa {
    public static final double DEDUCAO_MAX = 1500.0;

    private final String registroConselho;

    public DespesaSaude(int id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    @Override
    public String toString() {
        return super.toString() + " | Registro conselho: " + registroConselho;
    }
}
