package br.com.view;

import javax.swing.*;

import br.com.util.PanelUtils;
public class ConsultarDadosView extends JPanel {
	public ConsultarDadosView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
		
		JButton consultarContaButton = (JButton) PanelUtils.create(this, new JButton("CONSULTAR CONTA"), 10, 10, 200, 30);

		JButton consultarFuncionarioButton = (JButton) PanelUtils.create(this, new JButton("CONSULTAR FUNCIONÁRIO"), 10, 50, 200, 30);
		
		JButton consultarClienteButton = (JButton) PanelUtils.create(this, new JButton("CONSULTAR CLIENTE"), 10, 90, 200, 30);
		
		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Voltar"), 10, 130, 60, 20);

		consultarContaButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ConsultarContaView());
		});
		
		consultarFuncionarioButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ConsultarFuncionarioView());
		});
		
		consultarClienteButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ConsultarClienteView());
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new FuncionarioView());
		});
	}
}
