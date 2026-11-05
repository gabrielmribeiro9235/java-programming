package br.com.gabriel.ifsp.correctionoftest2.service;

import br.com.gabriel.ifsp.correctionoftest2.exception.EntityAlreadyExists;
import br.com.gabriel.ifsp.correctionoftest2.model.Declaracao;
import br.com.gabriel.ifsp.correctionoftest2.model.DeclaracaoCompleta;
import br.com.gabriel.ifsp.correctionoftest2.model.DeclaracaoSimplificada;
import br.com.gabriel.ifsp.correctionoftest2.persistence.DeclaracaoRepository;

public class NovaSimulacaoService {
    private final DeclaracaoRepository repositorio;

    public NovaSimulacaoService(DeclaracaoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void iniciar(double ganhoTributavel, double valorJaPago) {
        if (repositorio.buscar(1).isPresent() || repositorio.buscar(2).isPresent()) {
            throw new EntityAlreadyExists("Já há uma simulação em andamento.");
        }

        Declaracao declaracaoSimplificada = new DeclaracaoSimplificada(1, ganhoTributavel, valorJaPago);
        Declaracao declaracaoCompleta = new DeclaracaoCompleta(2, ganhoTributavel, valorJaPago);

        repositorio.salvar(declaracaoSimplificada);
        repositorio.salvar(declaracaoCompleta);
    }
}
