package br.com.model;

import java.sql.Date;
import java.time.LocalDate;

import br.com.dao.UsuarioDAO;

public class Usuario {
	private int id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	private Endereco endereco;

	public enum tipoUsuario {
		FUNCIONARIO,
		CLIENTE
	}

	public boolean login(String senha) {
		String senhaDAO = UsuarioDAO.findPassword(this.id);
		return senhaDAO == senha;
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
		if (telefone != null) this.telefone = telefone;
	}
	
	public void setEndereco(Endereco endereco) {
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
	
	public Date getDataNascimento() {
		return Date.valueOf(this.dataNascimento);
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
}