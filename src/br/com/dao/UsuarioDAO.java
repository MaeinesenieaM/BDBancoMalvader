package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.model.Cliente;
import br.com.model.Funcionario;
import br.com.model.Usuario;

public class UsuarioDAO {
	static public void save(Funcionario funcionario) {
		String comando_sql = "INSERT INTO usuario (nome, cpf, data_nascimento, telefone, tipo_usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, funcionario.getNome());
			comando.setString(2, funcionario.getCPF());
			comando.setDate(3, funcionario.getDataNascimento());
			comando.setString(4, funcionario.getTelefone());
			comando.setString(5, funcionario.getTipoUsuario());
			comando.setString(6, funcionario.getSenha());
			
			comando.executeUpdate();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void save(Cliente cliente) {
		String comando_sql = "INSERT INTO usuario (nome, cpf, data_nascimento, telefone, tipo_usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getCPF());
			comando.setDate(3, cliente.getDataNascimento());
			comando.setString(4, cliente.getTelefone());
			comando.setString(5, cliente.getTipoUsuario());
			comando.setString(6, cliente.getSenha());
			
			comando.executeUpdate();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		
	}
	
	static public void update(int id, Usuario usuario) {
		
	}
	
	static public void delete(int id) {
		
	}
	
	static public Usuario findById(int id) {
		return new Usuario();
	}
}
