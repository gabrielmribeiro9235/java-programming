package br.com.gabriel.ifsp.correctionoftest2;

import br.com.gabriel.ifsp.correctionoftest2.exception.EntityAlreadyExists;
import br.com.gabriel.ifsp.correctionoftest2.persistence.DeclaracaoRepository;
import br.com.gabriel.ifsp.correctionoftest2.persistence.DeclaracaoRepositoryImpl;
import br.com.gabriel.ifsp.correctionoftest2.service.*;

import java.util.NoSuchElementException;

public class Principal {
    public static void main(String[] args) {
        DeclaracaoRepository repositorio = new DeclaracaoRepositoryImpl();

        NovaSimulacaoService novaSimulacaoService = new NovaSimulacaoService(repositorio);
        AdicionarDespesaService adicionarDespesaService = new AdicionarDespesaService(repositorio);
        ExcluirSimulacaoService excluirSimulacaoService = new ExcluirSimulacaoService(repositorio);
        RelatorioSimulacaoService relatorioSimulacaoService = new RelatorioSimulacaoService(repositorio);

        try {
            System.out.println("Tentando adicionar despesa sem simulação vigente");
            adicionarDespesaService.adicionar(TipoDespesa.EDUCACAO, 1, "teste", 1000, "0000", "teste");
        } catch (IllegalStateException e) {
            System.out.println("Erro > " + e.getMessage());
        }

        try {
            System.out.println("\nTentando excluir uma simulação sem uma simulação vigente");
            excluirSimulacaoService.excluir();
        } catch (NoSuchElementException e) {
            System.out.println("Erro > " + e.getMessage());
        }

        try {
            System.out.println("\nTentando gerar um relatório sem uma simulação vigente");
            System.out.println(relatorioSimulacaoService.criarRelatorio());
        } catch (NoSuchElementException e) {
            System.out.println("Erro > " + e.getMessage());
        }

        System.out.println("-".repeat(100));
        System.out.println("Ganho tributável = R$ 22.847,88 e valor já pago = R$ 0,00 (pessoa isenta)");
        System.out.println("-".repeat(100));

        try {
            novaSimulacaoService.iniciar(22_847.88, 0.0);
            System.out.println("> Simulação iniciada");

            System.out.println("\nTentando criar outra simulação antes de encerrar a atual");
            novaSimulacaoService.iniciar(0, 0);
        } catch (EntityAlreadyExists e) {
            System.out.println("Erro > " + e.getMessage());
        }

        try {
            System.out.println(relatorioSimulacaoService.criarRelatorio());
            excluirSimulacaoService.excluir();
            System.out.println("> Simulação encerrada");
        } catch (NoSuchElementException e) {
            System.out.println("Erro > " + e.getMessage());
        }

        System.out.println("-".repeat(100));
        System.out.println("Ganho tributável = R$ 22.947,88 e valor já pago = R$ 0,00 (paga sobre R$ 100,00)");
        System.out.println("-".repeat(100));

        try {
            novaSimulacaoService.iniciar(22_947.88, 0.0);
            System.out.println("> Simulação iniciada");

            System.out.println(relatorioSimulacaoService.criarRelatorio());
            excluirSimulacaoService.excluir();
            System.out.println("> Simulação encerrada");
        } catch (EntityAlreadyExists | NoSuchElementException e) {
            System.out.println("Erro > " + e.getMessage());
        }

        System.out.println("-".repeat(100));
        System.out.println("Ganho tributável = R$ 35.000,00 e valor já pago = R$ 500,00 (cálculo por faixas: 7,5% + 15%)");
        System.out.println("-".repeat(100));

        try {
            novaSimulacaoService.iniciar(35_000.00, 500.00);
            System.out.println("> Simulação iniciada");

            System.out.println(relatorioSimulacaoService.criarRelatorio());
            excluirSimulacaoService.excluir();
            System.out.println("> Simulação encerrada");
        } catch (EntityAlreadyExists | NoSuchElementException e) {
            System.out.println("Erro > " + e.getMessage());
        }

        System.out.println("-".repeat(100));
        System.out.println("Ganho tributável = R$ 25.000,00 e valor já pago = R$ 500,00, com R$ 1.500,00 de despesa");
        System.out.println("com educação e R$ 2.000,00 com saúde (esta limitada a R$ 1.500,00). Deve restituir nos dois modelos.");

        try {
            novaSimulacaoService.iniciar(25_000.00, 500.00);
            System.out.println("> Simulação iniciada");

            adicionarDespesaService.adicionar(TipoDespesa.EDUCACAO, 1, "Mensalidade escolar", 1_500.00, "12.345.678/0001-88", "Colégio Escola");
            adicionarDespesaService.adicionar(TipoDespesa.SAUDE, 2, "Consulta médica", 2_000.00, "48.501.350/0001-67", "CRM 100001");
            System.out.println(relatorioSimulacaoService.criarRelatorio());
            excluirSimulacaoService.excluir();
            System.out.println("> Simulação encerrada");
        } catch (EntityAlreadyExists | NoSuchElementException e) {
            System.out.println("Erro > " + e.getMessage());
        }

        System.out.println("-".repeat(100));
        System.out.println("Ganho tributável = R$ 1.000.000,00 e valor já pago = R$ 100.000,00, com R$ 15.000,00 de despesa");
        System.out.println("com educação e R$ 100.000,00 com saúde (em 10 despesas separadas, ambas limitadas ao teto)");
        System.out.println("Essa pessoa paga imposto nos dois modelos (entra na última faixa da declaração completa).");

        try {
            novaSimulacaoService.iniciar(1_000_000.00, 100_000.00);
            System.out.println("> Simulação iniciada");

            adicionarDespesaService.adicionar(TipoDespesa.EDUCACAO, 1, "Escola dos filhos", 15_000.00, "00.579.870/0001-24", "Colégio Escola");

            for (int i = 2; i < 12; i++) {
                adicionarDespesaService.adicionar(TipoDespesa.SAUDE, i, "Despesa com saúde " + i, 10_000.00, "99.219.540/0001-25", "CRM 200002");
            }

            System.out.println(relatorioSimulacaoService.criarRelatorio());
            excluirSimulacaoService.excluir();
            System.out.println("> Simulação encerrada");
        } catch (EntityAlreadyExists | NoSuchElementException e) {
            System.out.println("Erro > " + e.getMessage());
        }
    }
}
