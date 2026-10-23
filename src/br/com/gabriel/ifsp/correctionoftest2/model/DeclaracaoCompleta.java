package br.com.gabriel.ifsp.correctionoftest2.model;

import br.com.gabriel.ifsp.correctionoftest2.exception.EntityAlreadyExists;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public final class DeclaracaoCompleta extends Declaracao {
    private static final double LIMITE_ISENCAO = 22_847.88;
    private static final double[][] FAIXAS = {
            {LIMITE_ISENCAO, 33_919.92},
            {33_919.93, 45_012.72},
            {45_012.73, 55_976.16},
            {55_976.17, Double.POSITIVE_INFINITY}
    };
    private static final double[] ALIQUOTAS = {
            0.075,
            0.15,
            0.225,
            0.275
    };
    private static final double[] ACUMULADO = {
            0,
            ALIQUOTAS[0] * (FAIXAS[0][1] - FAIXAS[0][0]),
            ALIQUOTAS[0] * (FAIXAS[0][1] - FAIXAS[0][0]) + ALIQUOTAS[1] * (FAIXAS[1][1] - FAIXAS[1][0]),
            ALIQUOTAS[0] * (FAIXAS[0][1] - FAIXAS[0][0]) + ALIQUOTAS[1] * (FAIXAS[1][1] - FAIXAS[1][0]) + ALIQUOTAS[2] * (FAIXAS[2][1] - FAIXAS[2][0])
    };

    private final List<Despesa> gastos;

    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
        gastos = new ArrayList<>();
    }

    @Override
    protected double valorImposto() {
        double tributavel = getGanhoTributavel() - totalDespesasDedutiveis();

        if (tributavel < FAIXAS[0][0]) return 0;

        for (int i = 0; i < 3; i++) {
            if (tributavel < FAIXAS[i+1][0]) return (tributavel - FAIXAS[i][0]) * ALIQUOTAS[i] + ACUMULADO[i];
        }

        return (tributavel - FAIXAS[3][0]) * ALIQUOTAS[3] + ACUMULADO[3];
    }

    public void adicionarDespesa(Despesa d) {
        if (gastos.contains(d)) {
            throw new EntityAlreadyExists("Despesa já cadastrada.");
        }

        gastos.add(d);
    }

    public void removerDespesa(Despesa d) {
        if (!gastos.contains(d)) {
            throw new IllegalArgumentException("Despesa não cadastrada.");
        }

        gastos.remove(d);
    }

    private double totalGastoEducacao() {
        return gastos.stream()
                .filter(g -> g instanceof DespesaEducacao)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    private double totalGastoSaude() {
        return gastos.stream()
                .filter(g -> g instanceof DespesaSaude)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    private double totalDespesasDedutiveis() {
        return Math.min(totalGastoSaude(), DespesaSaude.DEDUCAO_MAX) + Math.min(totalGastoEducacao(), DespesaEducacao.DEDUCAO_MAX);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");

        joiner.add("Despesas dedutíveis:\n");

        List<DespesaEducacao> educacao = gastos.stream()
                .filter(d -> d instanceof DespesaEducacao)
                .map(d -> (DespesaEducacao) d)
                .toList();


        List<DespesaSaude> saude = gastos.stream()
                .filter(d -> d instanceof DespesaSaude)
                .map(d -> (DespesaSaude) d)
                .toList();

        joiner.add("Despesas com educação:");
        if (educacao.isEmpty()) {
            joiner.add("Não há despesas dedutíveis com educação\n");
        } else {
            educacao.forEach(d -> joiner.add("\t" + d));
            joiner.add(String.format("Total gasto com educação    : R$ %.2f", totalGastoEducacao()));
            joiner.add(String.format("Total dedutível com educação: R$ %.2f\n", Math.min(totalGastoEducacao(), DespesaEducacao.DEDUCAO_MAX)));
        }

        joiner.add("Despesas com saúde:");
        if (saude.isEmpty()) {
            joiner.add("Não há despesas dedutíveis com saúde\n");
        } else {
            saude.forEach(d -> joiner.add("\t" + d));
            joiner.add(String.format("Total gasto com saúde    : R$ %.2f", totalGastoSaude()));
            joiner.add(String.format("Total dedutível com saúde: R$ %.2f\n", Math.min(totalGastoSaude(), DespesaSaude.DEDUCAO_MAX)));
        }

        joiner.add(String.format("Total deduzido: R$ %.2f", totalDespesasDedutiveis()));


        return "Declaração Completa\n\n" + super.toString() + "\n" + joiner;
    }
}
