package br.com.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FuncionarioView extends JPanel {
	public FuncionarioView() {
		placeComponents(this);
	}
	
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JButton contaAbreButton = new JButton("ABERTURA DE CONTA");
		contaAbreButton.setBounds(10, 10, 150, 30);
		panel.add(contaAbreButton);
		
		JButton contaEncerraButton = new JButton("ENCERRAMENTO DE CONTA");
		contaEncerraButton.setBounds(160, 10, 170, 30);
		panel.add(contaEncerraButton);
		
		JButton consultarDadosButton = new JButton("CONSULTAR DADOS");
		consultarDadosButton.setBounds(10, 50, 150, 30);
		panel.add(consultarDadosButton);
		
		JButton alterarDadosButton = new JButton("ALTERAR DADOS");
		alterarDadosButton.setBounds(160, 50, 170, 30);
		panel.add(alterarDadosButton);
		
		JButton cadastroButton = new JButton("CADASTRO DE FUNCIONÁRIOS");
		cadastroButton.setBounds(10, 90, 320, 30);
		panel.add(cadastroButton);
		
		JButton relatorioButton = new JButton("GERAR RELATÓRIOS");
		relatorioButton.setBounds(10, 130, 320, 30);
		panel.add(relatorioButton);
		
		JButton sairButton = new JButton("Sair");
		sairButton.setBounds(10, 170, 60, 20);
		panel.add(sairButton);
		
		contaAbreButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new AberturaContaView());
		});
		
		consultarDadosButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new ConsultarDadosView());
		});
		
		alterarDadosButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new AlterarDadosView());
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new LoginView());
		});
	}
}
