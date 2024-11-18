package br.com.model;

import br.com.model.Usuario;

public class Cliente extends Usuario {
	private String senha;

	public double consultarSaldo() {
		return 0.0;
	}

	public void depositar(double valor) {

	}

	public boolean sacar(double valor) {
		return false;
	}

	public String consultarExtrato() {
		return "WIP";
	}

	public double consultarLimite() {
		return 0.0;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
}