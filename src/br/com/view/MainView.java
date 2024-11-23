package br.com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame {
	
	public MainView() {
		setTitle("Teste - Login");
		setSize(500, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void switchPanel (JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		revalidate();
		repaint();
	}
}
