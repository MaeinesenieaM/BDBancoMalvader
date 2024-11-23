package br.com.view;

import javax.swing.*;

public class ClienteView extends JPanel {
	public ClienteView() {
		placeComponents(this);
	}
	
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel teste = new JLabel("EITA!");
		teste.setBounds(10, 10, 100, 35);
		panel.add(teste);
		
	}
}
