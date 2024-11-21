package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.model.Funcionario;

public class FuncionarioDAO {
	public void save(Funcionario funcionario) {
		String comando_sql = "INSERT INTO funcionario (codigo_funcionario, cargo, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, funcionario.getCodigofuncionario());
			comando.setString(2, funcionario.getCargo());
			comando.setString(3, String.valueOf(funcionario.getID()));
			
			comando.executeUpdate();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	public void update(int id, Funcionario funcionario) {
		
	}
	
	public void delete(int id) {
		
	}
	
	public Funcionario findById(int id) {
		return new Funcionario();
	}
}
