package br.com.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.util.PanelUtils;

public class FuncionarioView extends JPanel {
	public FuncionarioView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
		
		JButton contaAbreButton = (JButton) PanelUtils.create(this, new JButton ("ABERTURA DE CONTA"), 10, 10, 150, 30);
		
		JButton contaEncerraButton = (JButton) PanelUtils.create(this, new JButton ("ENCERRAMENTO DE CONTA"), 160, 10, 170, 30);
		
		JButton consultarDadosButton = (JButton) PanelUtils.create(this, new JButton ("CONSULTAR DADOS"), 10, 50, 150, 30);
		
		JButton alterarDadosButton = (JButton) PanelUtils.create(this, new JButton ("ALTERAR DADOS"), 160, 50, 170, 30);
		
		JButton cadastroButton = (JButton) PanelUtils.create(this, new JButton ("CADASTRO DE FUNCIONÁRIOS"), 10, 90, 320, 30);
		
		JButton relatorioButton = (JButton) PanelUtils.create(this, new JButton ("GERAR RELATÓRIOS"), 10, 130, 320, 30);
		
		JButton sairButton = (JButton) PanelUtils.create(this, new JButton ("Sair"), 10, 170, 60, 20);
		
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
		
		cadastroButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new CadastroFuncionarioView());
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new LoginView());
		});
	}
}
