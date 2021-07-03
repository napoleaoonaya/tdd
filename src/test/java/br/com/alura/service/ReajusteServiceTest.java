package br.com.alura.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.modelo.Desempenho;
import br.com.alura.modelo.Funcionario;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach//Chamado primeiro antes de executar
	public void inicializar() {
		System.out.println("Iniciou");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach//Chamado depois de executar
	public void finalizar() {
		System.out.println("Finalizou");
	}
	
	@BeforeAll//Antes de todos 
	public static void antesDeTodos() {
		System.out.println("Antes de todos");
	}
	
	@AfterAll//Após todos 
	public static void aposTodos() {
		System.out.println("Após todos");
	}

	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}


}
