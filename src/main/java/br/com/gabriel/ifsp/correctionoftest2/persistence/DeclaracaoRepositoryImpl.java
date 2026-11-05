package br.com.gabriel.ifsp.correctionoftest2.persistence;

import br.com.gabriel.ifsp.correctionoftest2.exception.EntityAlreadyExists;
import br.com.gabriel.ifsp.correctionoftest2.model.Declaracao;

import java.util.*;

public class DeclaracaoRepositoryImpl implements DeclaracaoRepository {
    private static final Map<Integer, Declaracao> DECLARACOES = new HashMap<>();

    @Override
    public void salvar(Declaracao declaracao) {
        Objects.requireNonNull(declaracao, "Declaração não pode ser nula.");

        if (DECLARACOES.containsKey(declaracao.getId())) {
            throw new EntityAlreadyExists("Declaração já existe.");
        }

        DECLARACOES.put(declaracao.getId(), declaracao);
    }

    @Override
    public void atualizar(int id, Declaracao declaracao) {
        if (!DECLARACOES.containsKey(id)) {
            throw new NoSuchElementException("Declaração " + id + " nunca foi cadastrada.");
        }

        DECLARACOES.replace(id, declaracao);
    }

    @Override
    public void remover(int id) {
        if (DECLARACOES.remove(id) == null) {
            throw new NoSuchElementException("Declaração " + id + " nunca foi cadastrada.");
        }
    }

    @Override
    public Optional<Declaracao> buscar(int id) {
        return Optional.ofNullable(DECLARACOES.get(id));
    }
}
