package br.com.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.dao.ConnectionFactory;

import br.com.view.*;

public class BancoMalvader {
	private String nome;


	public static void main (String[] args) {
		/*try {
            // Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		} */
		
		SwingUtilities.invokeLater(() -> {
			MainView window = new MainView();
			
			window.add(new LoginView());
			window.setVisible(true);
		});
	}

	public void iniciarSistema () {
		
	}
}