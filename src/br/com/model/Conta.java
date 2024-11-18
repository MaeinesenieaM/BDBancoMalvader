package br.com.model;

import br.com.model.Cliente;

public class Conta {
	private int numero;
	private String agencia;
	private double saldo;
	private Cliente cliente;

	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
	}

	public boolean sacar(double valor) {
		if (valor > this.saldo) return false;
		this.saldo = this.saldo - valor;
		return true;
	}

	public double consultarSaldo() {
		return this.saldo;
	}
}