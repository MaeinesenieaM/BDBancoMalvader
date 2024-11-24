package br.com.view;

import java.time.LocalDate;

import javax.swing.*;

import br.com.util.PanelUtils;

public class AlterarContaView extends JPanel {
	public AlterarContaView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
		
		String[] tipos = {"Poupança", "Corrente"};
		
		PanelUtils.create(this, new JLabel("Codigo:"), 10, 40, 60, 20);
		JTextField codigoField = (JTextField) PanelUtils.create(this, new JTextField(), 50, 40, 40, 20);
		JButton pesquisarContaButton = (JButton) PanelUtils.create(this, new JButton("GO"), 100, 40, 50, 20);
		
		PanelUtils.create(this, new JLabel("Tipo:"), 260, 90, 60, 20);
		JComboBox tipoBox = (JComboBox) PanelUtils.create(this, new JComboBox(tipos), 300, 90, 80, 20);
		
		PanelUtils.create(this, new JLabel("Limite Disponível:"), 10, 90, 100, 20);
		JTextField limiteField = (JTextField) PanelUtils.create(this, new JTextField(), 120, 90, 120, 20);
		
		PanelUtils.create(this, new JLabel("Data de Vencimento:"), 10, 130, 100, 20);
		JTextField cpfField = (JTextField) PanelUtils.create(this, new JTextField(), 120, 130, 120, 20);
		
		JButton pesquisarTotalButton = (JButton) PanelUtils.create(this, new JButton("Alterar"), 10, 270, 140, 30);

		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Voltar"), 10, 10, 60, 20);

		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new AlterarDadosView());
		});
	}
}
