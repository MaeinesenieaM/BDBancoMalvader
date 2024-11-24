package br.com.view;

import java.time.LocalDate;

import javax.swing.*;

import br.com.util.PanelUtils;

public class ConsultarFuncionarioView extends JPanel {
	public ConsultarFuncionarioView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
		
		String[] tipos = {"Gerente", "Senior", "Junior", "Estagiario"};
		String[] colunas = {"ID", "Nome", "CPF", "Cargo", "Codigo", "Nascimento", "Telefone", "Local", "CEP", "Bairro", "Cidade", "Estado"};
		Object[][] data = { {0, "", "", "", 0, LocalDate.now(), "", "", "", "", "", "" } };
		PanelUtils.create(this, new JLabel("Tipo:"), 10, 40, 60, 20);
		JComboBox tipoBox = (JComboBox) PanelUtils.create(this, new JComboBox(tipos), 50, 40, 80, 20);
		JButton pesquisarTipoButton = (JButton) PanelUtils.create(this, new JButton("GO"), 140, 40, 50, 20);
		
		PanelUtils.create(this, new JLabel("Nome:"), 200, 40, 60, 20);
		JTextField nomeField = (JTextField) PanelUtils.create(this, new JTextField(), 240, 40, 160, 20);
		JButton pesquisarNomeButton = (JButton) PanelUtils.create(this, new JButton("GO"), 410, 40, 50, 20);
		
		PanelUtils.create(this, new JLabel("CPF:"), 10, 70, 60, 20);
		JTextField cpfField = (JTextField) PanelUtils.create(this, new JTextField(), 50, 70, 80, 20);
		JButton pesquisarCPFButton = (JButton) PanelUtils.create(this, new JButton("GO"), 140, 70, 50, 20);
		
		JButton pesquisarTotalButton = (JButton) PanelUtils.create(this, new JButton("Pesquisar"), 250, 65, 140, 30);
		
		
		JTable contaTable = new JTable(data, colunas) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane tablePane = (JScrollPane) PanelUtils.create(this, new JScrollPane(contaTable), 10, 120, 465, 180);
		
		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Voltar"), 10, 10, 60, 20);

		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ConsultarDadosView());
		});
	}
}
