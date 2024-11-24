package br.com.view;

import javax.swing.*;

public class ClienteView extends JPanel {
	public ClienteView() {
		placeComponents(this);
	}
	
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JButton saldoButton = new JButton("SALDO");
		saldoButton.setBounds(10, 10, 200, 30);
		panel.add(saldoButton);
		
		JButton depositoButton = new JButton("DEPOSITO");
		depositoButton.setBounds(10, 50, 100, 30);
		panel.add(depositoButton);
		
		JButton saqueButton = new JButton("SAQUE");
		saqueButton.setBounds(110, 50, 100, 30);
		panel.add(saqueButton);
		
		JButton extratoButton = new JButton("EXTRATO");
		extratoButton.setBounds(10, 90, 200, 30);
		panel.add(extratoButton);
		
		JButton limiteButton = new JButton("LIMITE");
		limiteButton.setBounds(10, 130, 200, 30);
		panel.add(limiteButton);
		
		JButton sairButton = new JButton("Sair");
		sairButton.setBounds(10, 170, 60, 20);
		panel.add(sairButton);
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new LoginView());
		});
	}
}
