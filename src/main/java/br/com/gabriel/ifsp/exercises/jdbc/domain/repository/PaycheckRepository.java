package br.com.gabriel.ifsp.exercises.jdbc.domain.repository;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Paycheck;

import java.util.Iterator;
import java.util.stream.Stream;

public interface PaycheckRepository {
    void add(Paycheck paycheck, String employeeId);
    void remove(Paycheck paycheck, String employeeId);
    Iterator<Paycheck> iterator(String employeeId);
    Stream<Paycheck> stream(String employeeId);
}
