package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/malvaderdb";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.toString());
			throw new RuntimeException("Erro ao conectar com o banco de dados!");
		}
	}
}