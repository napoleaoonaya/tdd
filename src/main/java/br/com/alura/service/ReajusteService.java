package br.com.alura.service;

import java.math.BigDecimal;

import br.com.alura.modelo.Desempenho;
import br.com.alura.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
			BigDecimal percentual = desempenho.percentualReajuste();
			BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
			funcionario.reajustarSario(reajuste);
		
	}
	
}
