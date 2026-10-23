package br.com.gabriel.ifsp.correctionoftest2.service;

import br.com.gabriel.ifsp.correctionoftest2.model.*;
import br.com.gabriel.ifsp.correctionoftest2.persistence.DeclaracaoRepository;

import java.util.Objects;

public class AdicionarDespesaService {
    private final DeclaracaoRepository repositorio;

    public AdicionarDespesaService(DeclaracaoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(TipoDespesa tipo, int id, String descricao, double valor, String cnpj, String especifico) {
        Objects.requireNonNull(tipo, "Tipo não pode ser nulo.");
        Objects.requireNonNull(descricao, "Descrição não pode ser nula.");
        Objects.requireNonNull(cnpj, "CNPJ não pode ser nulo.");
        Objects.requireNonNull(especifico, "Específico não pode ser nulo.");

        if (repositorio.buscar(1).isEmpty() || repositorio.buscar(2).isEmpty()) {
            throw new IllegalStateException("Nenhuma simulação foi iniciada.");
        }

        Despesa d = switch (tipo) {
            case SAUDE -> new DespesaSaude(id, descricao, valor, cnpj, especifico);
            case EDUCACAO -> new DespesaEducacao(id, descricao, valor, cnpj, especifico);
        };

        DeclaracaoCompleta declaracaoCompleta = (DeclaracaoCompleta) repositorio.buscar(2).get();

        declaracaoCompleta.adicionarDespesa(d);

        repositorio.atualizar(2, declaracaoCompleta);
    }
}
