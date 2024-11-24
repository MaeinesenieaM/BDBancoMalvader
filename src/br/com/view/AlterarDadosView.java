package br.com.view;

import javax.swing.*;

import br.com.util.PanelUtils;

public class AlterarDadosView extends JPanel {
	public AlterarDadosView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
		
		JButton alterarContaButton = (JButton) PanelUtils.create(this, new JButton("AlTERAR CONTA"), 10, 10, 200, 30);

		JButton alterarFuncionarioButton = (JButton) PanelUtils.create(this, new JButton("ALTERAR FUNCIONÁRIO"), 10, 50, 200, 30);

		JButton alterarClienteButton = (JButton) PanelUtils.create(this, new JButton("ALTERAR CLIENTE"), 10, 90, 200, 30);

		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Voltar"), 10, 130, 60, 20);
		
		alterarContaButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new AlterarContaView());
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new FuncionarioView());
		});
	}

}
