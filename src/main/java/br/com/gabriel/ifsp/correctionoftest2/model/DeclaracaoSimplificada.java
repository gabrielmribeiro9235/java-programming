package br.com.gabriel.ifsp.correctionoftest2.model;

public final class DeclaracaoSimplificada extends Declaracao {
    private static final double LIMITE_ISENCAO = 22_847.88;

    public DeclaracaoSimplificada(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    protected double valorImposto() {
        return Math.max(0.2 * (getGanhoTributavel() - LIMITE_ISENCAO), 0);
    }

    @Override
    public String toString() {
        return "Declaração simplificada\n\n" + super.toString();
    }
}
