package br.com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.ContaCorrente;
import br.com.model.ContaPoupanca;

public class ContaDAO {
	static public void save(ContaCorrente conta) {
		String comando_sql = "INSERT INTO conta (numero_conta, agencia, saldo, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(conta.getNumero()));	//NOTA: Garanta que o número seja unico antes de atualizar.
			comando.setString(2, conta.getAgencia());
			comando.setBigDecimal(3, BigDecimal.valueOf(conta.getSaldo()));
			comando.setString(4, "CORRENTE");
			comando.setInt(5, ClienteDao.getIdByForeignId(conta.getCliente().getID()));
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void save(ContaPoupanca conta) {
		String comando_sql = "INSERT INTO conta (numero_conta, agencia, saldo, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, String.valueOf(conta.getNumero()));
			comando.setString(2, conta.getAgencia());
			comando.setBigDecimal(3, BigDecimal.valueOf(conta.getSaldo()));
			comando.setString(4, "POUPANCA");
			comando.setInt(5, ClienteDao.getIdByForeignId(conta.getCliente().getID()));
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, Conta conta) {
		String comando_sql = "UPDATE conta SET numero_conta = ?, agencia = ?, saldo = ? WHERE id_conta = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, conta.getNumero());
			comando.setString(2, conta.getAgencia());
			comando.setBigDecimal(3, BigDecimal.valueOf(conta.getSaldo()));
			comando.setInt(4, id);
					
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) {
		String comando_sql = "DELETE FROM funcionario WHERE id_conta = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public Conta findById(int id) {
		Conta conta = new Conta();
		
		String comando_sql = "SELECT * FROM conta WHERE id_conta = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR CONTA OU CONTA NÃO EXISTE");
			
			conta.setNumero(data.getInt("numero_conta"));
			conta.setAgencia(data.getString("agencia"));
			conta.setSaldo(data.getDouble("saldo"));
			
			Cliente cliente = ClienteDao.findById(data.getInt("id_cliente"));
			
			conta.setCliente(cliente);
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return conta;
	}
	
	static public Conta findByNumero(String numero) {
		Conta conta = new Conta();
		
		String comando_sql = "SELECT * FROM conta WHERE numero_conta = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setString(1, numero);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR CONTA OU CONTA NÃO EXISTE");
			
			conta.setNumero(data.getInt("numero_conta"));
			conta.setAgencia(data.getString("agencia"));
			conta.setSaldo(data.getDouble("saldo"));
			
			Cliente cliente = ClienteDao.findById(data.getInt("id_cliente"));
			
			conta.setCliente(cliente);
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return conta;
	}
	
	//Diferente das outras funçoes, esta procura a conta no banco e retorna somente o ID.
	static public int getIdByNumero(int numero) {
		int id = 0;
		
		String comando_sql = "SELECT * FROM conta WHERE numero_conta = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, numero);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) throw new NullPointerException("NÃO FOI POSSIVEl ENCONTRAR CONTA OU CONTA NÃO EXISTE");
			
			id = data.getInt("id_conta");
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return id;
	}
}
