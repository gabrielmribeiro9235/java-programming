package br.com.gabriel.ifsp.correctionoftest2.service;

import br.com.gabriel.ifsp.correctionoftest2.model.DeclaracaoCompleta;
import br.com.gabriel.ifsp.correctionoftest2.model.DeclaracaoSimplificada;
import br.com.gabriel.ifsp.correctionoftest2.persistence.DeclaracaoRepository;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class RelatorioSimulacaoService {
    private final DeclaracaoRepository repositorio;

    public RelatorioSimulacaoService(DeclaracaoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public String criarRelatorio() {
        if (repositorio.buscar(1).isEmpty() || repositorio.buscar(2).isEmpty()) {
            throw new NoSuchElementException("Não há simulação vigente.");
        }

        StringJoiner joiner = new StringJoiner("\n");

        DeclaracaoSimplificada declaracaoSimplificada = (DeclaracaoSimplificada) repositorio.buscar(1).get();
        DeclaracaoCompleta declaracaoCompleta = (DeclaracaoCompleta) repositorio.buscar(2).get();

        joiner.add("-".repeat(100))
                .add(declaracaoSimplificada.toString())
                .add("-".repeat(100))
                .add(declaracaoCompleta.toString())
                .add("-".repeat(100))
                .add(comparar(declaracaoSimplificada, declaracaoCompleta))
                .add("-".repeat(100));

        return joiner.toString();
    }

    private String comparar(DeclaracaoSimplificada declaracaoSimplificada, DeclaracaoCompleta declaracaoCompleta) {
        double simplificada = declaracaoSimplificada.valorAPagar();
        double completa = declaracaoCompleta.valorAPagar();

        if (simplificada == completa) {
            return simplificada == 0.0 ? "Isento em ambas as declarações." : "A valor a pagar será o mesmo em qualquer modelo.";
        }

        return String.format("É mais vantajoso fazer a declaração %s.\nEconomia: R$ %.2f",
                (simplificada < completa ? "simplificada" : "completa"),
                Math.abs(simplificada - completa)
        );
    }
}
