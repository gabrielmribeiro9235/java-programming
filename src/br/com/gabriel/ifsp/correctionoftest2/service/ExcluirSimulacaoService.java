package br.com.gabriel.ifsp.correctionoftest2.service;

import br.com.gabriel.ifsp.correctionoftest2.persistence.DeclaracaoRepository;

import java.util.NoSuchElementException;

public class ExcluirSimulacaoService {
    private final DeclaracaoRepository repositorio;

    public ExcluirSimulacaoService(DeclaracaoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void excluir() {
        if (repositorio.buscar(1).isEmpty() || repositorio.buscar(2).isEmpty()) {
            throw new NoSuchElementException("Não há simulação vigente.");
        }

        repositorio.remover(1);
        repositorio.remover(2);
    }
}
