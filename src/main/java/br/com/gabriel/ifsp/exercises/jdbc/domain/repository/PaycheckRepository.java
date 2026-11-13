package br.com.gabriel.ifsp.exercises.jdbc.domain.repository;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Paycheck;

import java.util.Iterator;
import java.util.stream.Stream;

public interface PaycheckRepository {
    void add(Paycheck paycheck);
    void remove(Paycheck paycheck);
    // TODO não é usual os métodos abaixo. O repositório representa operações de persistência, não uma collection. Você poderia ter algo com findAll retornando List<Paycheck>
    Iterator<Paycheck> iterator();
    Stream<Paycheck> stream();
}
