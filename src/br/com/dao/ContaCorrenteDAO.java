package br.com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.Cliente;
import br.com.model.ContaCorrente;

public class ContaCorrenteDAO {
	static public void save(ContaCorrente conta) {
		String comando_sql = "INSERT INTO conta_corrente (limite, data_vencimento, id_conta) VALUES (?, ?, ?)";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setBigDecimal(1, BigDecimal.valueOf(conta.getLimite()));
			comando.setDate(2, Date.valueOf(conta.getDataVencimento()));
			comando.setInt(3, ContaDAO.getIdByNumero(conta.getNumero()));
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void update(int id, ContaCorrente conta) {
		String comando_sql = "UPDATE conta_corrente SET limite = ?, data_vencimento = ? WHERE id_conta_corrente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setBigDecimal(1, BigDecimal.valueOf(conta.getLimite()));
			comando.setDate(2, Date.valueOf(conta.getDataVencimento()));
			comando.setInt(3, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public void delete(int id) {
		String comando_sql = "DELETE FROM conta_corrente WHERE id_conta_corrente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
	
	static public ContaCorrente findById(int id) {
		ContaCorrente conta = new ContaCorrente();
		
		String comando_sql = "SELECT * FROM conta JOIN conta_corrente ON conta.id_conta = conta_corrente.id_conta WHERE conta_corrente.id_conta_corrente = ?";
		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement comando = conexao.prepareStatement(comando_sql);
			comando.setInt(1, id);
			ResultSet data = comando.executeQuery();
			
			if (data.next() == false) {
				System.out.println("TABLE VAZIA!!");
				return null;
			}
			
			conta.setNumero(data.getInt("numero_conta"));
			conta.setAgencia(data.getString("agencia"));
			conta.setSaldo(data.getDouble("saldo"));
			
			Cliente cliente = ClienteDao.findById(data.getInt("id_cliente"));
			
			conta.setCliente(cliente);
			conta.setLimite(data.getDouble("limite"));
			conta.setDataVencimento(data.getDate("data_vencimento").toLocalDate());
			
			conexao.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return conta;
	}
}
