package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.Funcionario;

public class FuncionarioDAO {
	static public void save(Funcionario funcionario) {
		String comando_sql = "INSERT INTO funcionario (codigo_funcionario, cargo, id_usuario) VALUES (?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, funcionario.getCodigofuncionario());
			comando.setString(2, funcionario.getCargo());
			comando.setInt(3, funcionario.getID());
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Funcionario funcionario) {
		String comando_sql = "UPDATE cliente SET codigo_funcionario = ?, cargo = ?, id_usuario = ? WHERE id_cliente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, funcionario.getCodigofuncionario());
			comando.setString(2, funcionario.getCargo());
			comando.setInt(3, funcionario.getID());
			comando.setInt(4, id);
					
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) {
		String comando_sql = "DELETE FROM funcionario WHERE id_endereco = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	//Retorna NULL se a mesa encontrada estiver vazia.
	static public Funcionario findById(int id) {
		Funcionario funcionario = new Funcionario();
		
		String comando_sql = "SELECT * FROM usuario JOIN funcionario ON usuario.id_usuario = funcionario.id_usuario WHERE funcionario.id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) {
				System.out.println("TABLE VAZIA!!");
				return null;
			}
			
			funcionario.setID(data.getInt("funcionario.id_usuario"));
			funcionario.setNome(data.getString("nome"));
			funcionario.setCPF(data.getString("cpf"));
			funcionario.setDataNascimento(data.getDate("data_nascimento").toLocalDate());
			funcionario.setTelefone(data.getString("telefone"));
			funcionario.setSenha(data.getString("senha"));
			
			funcionario.setCodigofuncionario(data.getString("codigo_funcionario"));
			funcionario.setCargo(data.getString("cargo"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return funcionario;
	}
}
