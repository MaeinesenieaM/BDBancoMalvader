package br.com.view;

import java.time.LocalDate;

import javax.swing.*;

import br.com.util.PanelUtils;

public class AberturaContaView extends JPanel {
	public AberturaContaView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
		
		JButton contaCorrenteButton = (JButton) PanelUtils.create(this, new JButton("CONTA CORRENTE"), 10, 10, 150, 35);
		
		JButton contaPoupancaButton = (JButton) PanelUtils.create(this, new JButton("CONTA POUPANÇA"), 10, 55, 150, 35);

		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Voltar"), 10, 100, 60, 20);

		contaCorrenteButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ContaCorrenteView());
		});
		
		contaPoupancaButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ContaPoupancaView());
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new FuncionarioView());
		});
	}
}
