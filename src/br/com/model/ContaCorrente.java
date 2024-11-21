package br.com.model;

import java.time.LocalDate;

public class ContaCorrente extends Conta {
	private double limite;
	private LocalDate dataVencimento;

	public double consultarLimite() {
		return 0.0;
	}
}