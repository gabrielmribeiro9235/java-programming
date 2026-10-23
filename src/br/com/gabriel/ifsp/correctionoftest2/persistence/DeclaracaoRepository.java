package br.com.gabriel.ifsp.correctionoftest2.persistence;

import br.com.gabriel.ifsp.correctionoftest2.model.Declaracao;

import java.util.Optional;

public interface DeclaracaoRepository {
    void salvar(Declaracao declaracao);
    void atualizar(int id, Declaracao declaracao);
    void remover(int id);
    Optional<Declaracao> buscar(int id);
}
