package br.com.model;


public class ContaPoupanca extends Conta {
	private double taxaRendimento = 0.1;

	public double calcularRendimento() {
		return 0.0;
	}
	
	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
	public double getTaxaRendimento() {
		return taxaRendimento;
	}
}