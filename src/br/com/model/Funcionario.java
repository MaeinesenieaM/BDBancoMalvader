package br.com.model;

import br.com.dao.FuncionarioDAO;
import br.com.dao.UsuarioDAO;

public class Funcionario extends Usuario {
	private String codigoFuncionario;
	private String cargo;
	private String senha;

	public void abrirConta(Conta conta) {

	}

	public void encerrarConta(Conta conta) {

	}

	public Conta consultarDadosConta(int numeroConta) {
		return new Conta();
	}

	public Cliente consultarDadosCliente(int idCliente) {
		return new Cliente();
	}

	public void alterarDadosConta(Conta conta) {

	}

	public void alterarDadosCliente(Cliente cliente) {

	}

	public void cadastrarFuncionario(Funcionario funcionario) {
		UsuarioDAO.save(funcionario);
		Usuario usuario = UsuarioDAO.findByCPF(funcionario.getCPF());
		funcionario.setID(usuario.getID());
		System.out.println(usuario.getID());
		FuncionarioDAO.save(funcionario);
	}

	public void gerarRelatorioMovimentacao() {

	}
	
	public void setCodigofuncionario(String codigo) {
		this.codigoFuncionario = codigo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCodigofuncionario() {
		return codigoFuncionario;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario.FUNCIONARIO.toString();
	}
}