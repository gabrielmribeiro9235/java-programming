package br.com.gabriel.ifsp.exercises.jdbc.domain.repository;

import java.time.LocalDate;

public interface AverageSalaryCalculator {
    //TODO isso aqui só faz sentido se forem SQLs com cálculo feito direto no banco. Se forem regras de negócio, isso deve vir no service e não com um repository.
    //TODO além disso, ou jogaria esses métodos para EmployeeRepository. Isso é assunto mais para frente, mas no DDD, geralmente, a regra é um repo para cada agregado (no caso, Employee é um agregado - todo conceitual)
    double averageSalary();
    double averageSalary(String jobTitle);
    double averageSalary(LocalDate start, LocalDate end);
}
