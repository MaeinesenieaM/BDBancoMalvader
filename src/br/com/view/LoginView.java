package br.com.view;

import javax.swing.*;

import br.com.util.PanelUtils;

public class LoginView extends JPanel {

	public LoginView() {
		placeComponents(this);
	}
	
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JButton funcionarioButton = (JButton) PanelUtils.create(this, new JButton ("Funcionário"), 10, 10, 100, 35);
		
		JButton clienteButton = (JButton) PanelUtils.create(this, new JButton ("Cliente"), 10, 55, 100, 35);

		JButton sairButton = (JButton) PanelUtils.create(this, new JButton ("Sair"), 10, 100, 60, 20);
		
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
