package br.com.model;

import java.time.LocalDate;

import br.com.model.Conta;

public class ContaCorrente extends Conta {
	private double limite;
	private LocalDate dataVencimento;

	public double consultarLimite() {
		return 0.0;
	}
}