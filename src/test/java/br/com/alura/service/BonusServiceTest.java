package br.com.alura.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class,() -> service.calcularBonus(new Funcionario("Miguel", LocalDate.now(), new BigDecimal(10000))));
		
//      Segunda abordagem		
//		try {
//			service.calcularBonus(new Funcionario("Miguel", LocalDate.now(), new BigDecimal(10000)));
//			fail("Não deu a exception!");
//		} catch (Exception e) {
//			assertEquals("Funcionário com salário maior que R$10000 não pode receber bônus", e.getMessage());
//		}
	}
	
	@Test
	void bonusDeveriaSerDezPorcentoParaFuncionarioComSalarioBaixo() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal(2500)));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorcentoParaSalarioDeMilReais() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal(1000)));
		
		assertEquals(new BigDecimal("100.00"), bonus);
	}

}
