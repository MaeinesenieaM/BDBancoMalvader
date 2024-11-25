package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.Cliente;

public class ClienteDao {
	static public void save(Cliente cliente) {
		String comando_sql = "INSERT INTO cliente (id_usuario) VALUE (?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(cliente.getID()));
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Cliente cliente) {
		String comando_sql = "UPDATE cliente SET id_usuario = ? where id_cliente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(cliente.getID()));
			comando.setString(2, String.valueOf(id));
					
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) {
		String comando_sql = "DELETE FROM cliente WHERE id_cliente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public Cliente findById(int id) {
		Cliente cliente = new Cliente();
		String comando_sql = "SELECT * FROM usuario JOIN cliente ON usuario.id_usuario = cliente.id_usuario WHERE cliente.id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
						
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR CLIENTE OU CLIENTE NÃO EXISTE");
			
			cliente.setID(data.getInt("cliente.id_usuario"));
			cliente.setNome(data.getString("nome"));
			cliente.setCPF(data.getString("cpf"));
			cliente.setDataNascimento(data.getDate("data_nascimento").toLocalDate());
			cliente.setTelefone(data.getString("telefone"));
			cliente.setSenha(data.getString("senha"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return cliente;
	}
	
	//Procura um Usuario com o CPF inserido e cria um Cliente baseado nele já que a tabela Cliente não
	//possuí valores importantes.
	static public Cliente findByCPF(String cpf) {
		Cliente cliente = new Cliente();
		String comando_sql = "SELECT * FROM usuario WHERE cpf = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, cpf);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR CLIENTE OU CLIENTE NÃO EXISTE");
			
			cliente.setID(data.getInt("id_usuario"));
			cliente.setNome(data.getString("nome"));
			cliente.setCPF(data.getString("cpf"));
			cliente.setDataNascimento(data.getDate("data_nascimento").toLocalDate());
			cliente.setTelefone(data.getString("telefone"));
			cliente.setSenha(data.getString("senha"));
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return cliente;
	}
	
	//Retorna somente o ID ao invés da tabela inteira. 
	static public int getIdByForeignId(int usuario_id) {
		int id = 0;
		String comando_sql = "SELECT * FROM cliente WHERE id_usuario = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, usuario_id);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR CLIENTE OU CLIENTE NÃO EXISTE");
			
			id = data.getInt("id_cliente");
		
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		System.out.println(id);
		return id;
	}
}
