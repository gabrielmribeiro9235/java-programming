package br.com.gabriel.ifsp.exercises.jdbc.domain.repository;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Paycheck;

import java.util.Iterator;
import java.util.stream.Stream;

public interface PaycheckRepository {
    void add(Paycheck paycheck);
    void remove(Paycheck paycheck);
    Iterator<Paycheck> iterator();
    Stream<Paycheck> stream();
}
