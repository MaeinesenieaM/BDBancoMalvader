package br.com.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.dao.ConnectionFactory;

public class BancoMalvader {
	private String nome;


	public static void main (String[] args) {
		Connection conexao = ConnectionFactory.getConnection();
		System.out.println("FUNCIONOU!");
		try {
			if (conexao.isClosed()) System.out.println("TA FECHADO!");
			else System.out.println("TA ABERTO!");
			conexao.close();
			if (conexao.isClosed()) System.out.println("TA FECHADO!");
			else System.out.println("TA ABERTO!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciarSistema () {
		
	}
}