package br.com.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import br.com.model.Endereco;
import br.com.model.Funcionario;
import br.com.util.PanelUtils;

public class CadastroFuncionarioView extends JPanel {
	public CadastroFuncionarioView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
	
		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Voltar"), 10, 10, 60, 20);
		
		String[] tipos = {"Gerente", "Senior", "Junior", "Estagiario"};
		
		PanelUtils.create(this, new JLabel("Codigo:"), 10, 40, 60, 20);
		JTextField codigoField = (JTextField) PanelUtils.create(this, new JTextField(), 50, 40, 40, 20);
		PanelUtils.create(this, new JLabel("Tipo:"), 240, 40, 60, 20);
		JComboBox tipoBox = (JComboBox) PanelUtils.create(this, new JComboBox(tipos), 330, 40, 80, 20);
		
		PanelUtils.create(this, new JLabel("Nome:"), 10, 70, 60, 20);
		JTextField nomeField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 70, 140, 20);
		PanelUtils.create(this, new JLabel("CPF:"), 240, 70, 100, 20);
		JTextField cpfField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 70, 140, 20);
		
		PanelUtils.create(this, new JLabel("Data Nascença:"), 10, 100, 100, 20);
		JTextField dataNascencaField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 100, 140, 20);
		PanelUtils.create(this, new JLabel("Telefone:"), 240, 100, 100, 20);
		JTextField telefoneField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 100, 140, 20);
		
		PanelUtils.create(this, new JLabel("CEP:"), 10, 130, 100, 20);
		JTextField cepField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 130, 140, 20);
		PanelUtils.create(this, new JLabel("Local:"), 240, 130, 100, 20);
		JTextField localField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 130, 140, 20);
		
		PanelUtils.create(this, new JLabel("Número Casa:"), 10, 160, 100, 20);
		JTextField numeroCasaField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 160, 140, 20);
		PanelUtils.create(this, new JLabel("Bairro:"), 240, 160, 100, 20);
		JTextField bairroField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 160, 140, 20);
		
		PanelUtils.create(this, new JLabel("Cidade:"), 10, 190, 100, 20);
		JTextField cidadeField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 190, 140, 20);
		PanelUtils.create(this, new JLabel("Estado:"), 240, 190, 100, 20);
		JTextField estadoField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 190, 140, 20);
		
		PanelUtils.create(this, new JLabel("Senha:"), 10, 220, 190, 20);
		JTextField senhaField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 220, 140, 20);
		
		JButton cadastrarButton = (JButton) PanelUtils.create(this, new JButton("CADASTRAR"), 10, 240, 120, 60);
		
		cadastrarButton.addActionListener(event -> {
			//MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			//if (window != null) window.switchPanel(new FuncionarioView());
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(nomeField.getText());
			funcionario.setSenha(senhaField.getText());
			funcionario.setCodigofuncionario(codigoField.getText());
			
			try {	funcionario.setCPF(cpfField.getText(0, 11));
			} catch (BadLocationException error) { error.printStackTrace(); }
			
			funcionario.setCargo(tipoBox.getSelectedItem().toString());
			
			funcionario.setDataNascimento(LocalDate.parse(dataNascencaField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			funcionario.setTelefone(telefoneField.getText());
			
			Endereco endereco = new Endereco();
			try { endereco.setCEP(cepField.getText(0, 8));
			} catch (BadLocationException error) { error.printStackTrace(); }
			endereco.setEstado(estadoField.getText());
			endereco.setCidade(cidadeField.getText());
			endereco.setBairro(bairroField.getText());
			endereco.setLocal(localField.getText());
			endereco.setNumeroCasa(Integer.parseInt(numeroCasaField.getText()));
			
			funcionario.setEndereco(endereco);
			
			funcionario.cadastrarFuncionario(funcionario);
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new FuncionarioView());
		});
	}
}
