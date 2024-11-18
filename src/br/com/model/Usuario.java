package br.com.model;

import java.time.LocalDate;

public class Usuario {
	private int id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	private String endereco;

	public boolean login(String senha) {
		return false;
	}

	public void logout() {

	}

	public String consultarDados() {
		return "WIP";
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(LocalDate data) {
		this.dataNascimento = data;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
}