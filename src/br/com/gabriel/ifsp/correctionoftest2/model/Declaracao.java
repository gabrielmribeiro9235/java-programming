package br.com.gabriel.ifsp.correctionoftest2.model;

import java.util.Objects;

public abstract sealed class Declaracao permits DeclaracaoSimplificada, DeclaracaoCompleta {
    private final int id;
    private final double ganhoTributavel;
    private final double valorJaPago;

    public Declaracao(int id, double ganhoTributavel, double valorJaPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorJaPago = valorJaPago;
    }

    public int getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorJaPago() {
        return valorJaPago;
    }

    public final double valorAPagar() {
        return valorImposto() - valorJaPago;
    }

    protected abstract double valorImposto();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("""
                ID              : %d
                Ganho tributável: R$ %.2f
                Imposto total   : R$ %.2f
                Valor já pago   : R$ %.2f
                Imposto a pagar : R$ %.2f
                """, id, ganhoTributavel, valorImposto(), valorJaPago, valorAPagar());
    }
}
