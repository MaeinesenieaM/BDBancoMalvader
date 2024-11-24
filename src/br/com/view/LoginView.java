package br.com.view;

import javax.swing.*;

public class LoginView extends JPanel {

	public LoginView() {
		placeComponents(this);
	}
	
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JButton funcionarioButton = new JButton("Funcionário");
		funcionarioButton.setBounds(10, 10, 100, 35);
		panel.add(funcionarioButton);
		
		JButton clienteButton = new JButton("Cliente");
		clienteButton.setBounds(10, 55, 100, 35);
		panel.add(clienteButton);
		
		JButton sairButton = new JButton("Sair");
		sairButton.setBounds(10, 100, 60, 20);
		panel.add(sairButton);
		
		funcionarioButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new FuncionarioView());
		});
		
		clienteButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ClienteView());
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.dispose();
		});
	}
	
}
