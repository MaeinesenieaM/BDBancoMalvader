package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			conexao.close();
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
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Cliente cliente) {
		String comando_sql = "UPDATE usuario SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, tipo_usuario = ?, senha = ? WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getCPF());
			comando.setDate(3, cliente.getDataNascimento());
			comando.setString(4, cliente.getTelefone());
			comando.setString(5, cliente.getTipoUsuario());
			comando.setString(6, cliente.getSenha());
			comando.setInt(7, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Funcionario funcionario) {
		String comando_sql = "UPDATE usuario SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, tipo_usuario = ?, senha = ? WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, funcionario.getNome());
			comando.setString(2, funcionario.getCPF());
			comando.setDate(3, funcionario.getDataNascimento());
			comando.setString(4, funcionario.getTelefone());
			comando.setString(5, funcionario.getTipoUsuario());
			comando.setString(6, funcionario.getSenha());
			comando.setInt(7, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) {
		String comando_sql = "DELETE FROM usuario WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public String findPassword(int id) {
		String password = null;
		String comando_sql = "SELECT senha FROM usuario WHERE cliente.id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			password = data.getString("senha");
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return password;
	}
	
	//Encontra um Usuario no Banco de Dados e retorna a table.
	//ATENÇÃO!!!EVITA DE USAR ESTA FUNÇÃO JA QUE ELA E UM USUARIO INCOMPLETO BASEADO
	//NO BANCO DE DADOS!!!
	static public Usuario findById(int id) {
		Usuario usuario = new Usuario();
		String comando_sql = "SELECT * FROM usuario WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
					
			if (data.next() == false) {
				System.out.println("TABLE VAZIA!!");
				return null;
			}
			
			usuario.setID(data.getInt("id_usuario"));
			usuario.setNome(data.getString("nome"));
			usuario.setCPF(data.getString("cpf"));
			usuario.setDataNascimento(data.getDate("data_nascimento").toLocalDate());
			usuario.setTelefone(data.getString("telefone"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return usuario;
	}
	
	static public Usuario findByCPF(String cpf) {
		Usuario usuario = new Usuario();
		String comando_sql = "SELECT * FROM usuario WHERE cpf = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, cpf);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR USUARIO OU USUARIO NÃO EXISTE");
			
			usuario.setID(data.getInt("id_usuario"));
			usuario.setNome(data.getString("nome"));
			usuario.setCPF(data.getString("cpf"));
			usuario.setDataNascimento(data.getDate("data_nascimento").toLocalDate());
			usuario.setTelefone(data.getString("telefone"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return usuario;
	}
	
	static public int getIdByCPF(String cpf) {
		int id = 0;
		
		String comando_sql = "SELECT * FROM usuario WHERE cpf = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, cpf);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR USUARIO OU USUARIO NÃO EXISTE");
			
			id = data.getInt("id_usuario");
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return id;
	}
}
