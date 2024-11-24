package br.com.view;

import javax.swing.*;

import br.com.util.PanelUtils;

public class ContaPoupancaView extends JPanel {
	public ContaPoupancaView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
	
		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Sair"), 10, 10, 60, 20);
		
		PanelUtils.create(this, new JLabel("Agência:"), 10, 40, 60, 20);
		JTextField agenciaField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 40, 140, 20);
		PanelUtils.create(this, new JLabel("Número Conta:"), 240, 40, 100, 20);
		JTextField numeroContaField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 40, 140, 20);
		
		PanelUtils.create(this, new JLabel("Nome Cliente:"), 10, 70, 100, 20);
		JTextField nomeClienteField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 70, 140, 20);
		PanelUtils.create(this, new JLabel("CPF:"), 240, 70, 100, 20);
		JTextField cpfClienteField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 70, 140, 20);
		
		PanelUtils.create(this, new JLabel("Data Nascença:"), 10, 100, 100, 20);
		JTextField dataNascimentoField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 100, 140, 20);
		PanelUtils.create(this, new JLabel("Telefone:"), 240, 100, 100, 20);
		JTextField telefoneField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 100, 140, 20);
		
		PanelUtils.create(this, new JLabel("Endereo Cliente:"), 10, 130, 100, 20);
		JTextField enderecoField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 130, 140, 20);
		PanelUtils.create(this, new JLabel("CEP:"), 240, 130, 100, 20);
		JTextField cepField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 130, 140, 20);
		
		PanelUtils.create(this, new JLabel("Local:"), 10, 160, 100, 20);
		JTextField localField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 160, 140, 20);
		PanelUtils.create(this, new JLabel("Número Casa:"), 240, 160, 100, 20);
		JTextField numeroCasaField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 160, 140, 20);
		
		PanelUtils.create(this, new JLabel("Bairro:"), 10, 190, 190, 20);
		JTextField bairroField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 190, 140, 20);
		PanelUtils.create(this, new JLabel("Cidade:"), 240, 190, 190, 20);
		JTextField cidadeField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 190, 140, 20);
		
		PanelUtils.create(this, new JLabel("Estado:"), 10, 220, 100, 20);
		JTextField estadoField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 220, 140, 20);
		PanelUtils.create(this, new JLabel("Senha:"), 240, 220, 100, 20);
		JTextField senhaClienteField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 220, 140, 20);
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new AberturaContaView());
		});
	}
}
