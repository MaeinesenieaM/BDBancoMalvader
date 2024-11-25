package br.com.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import br.com.dao.ClienteDao;
import br.com.dao.ContaDAO;
import br.com.dao.ContaCorrenteDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Cliente;
import br.com.model.ContaCorrente;
import br.com.model.Endereco;
import br.com.util.PanelUtils;

public class ContaCorrenteView extends JPanel {
	public ContaCorrenteView() {
		placeComponents();
	}
	
	private void placeComponents() {
		this.setLayout(null);
	
		JButton sairButton = (JButton) PanelUtils.create(this, new JButton("Voltar"), 10, 10, 60, 20);
		
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
		
		PanelUtils.create(this, new JLabel("Saldo:"), 10, 130, 100, 20);
		JTextField saldoField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 130, 140, 20);
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
		
		PanelUtils.create(this, new JLabel("Limite:"), 10, 250, 100, 20);
		JTextField limiteField = (JTextField) PanelUtils.create(this, new JTextField(), 90, 250, 140, 20);
		PanelUtils.create(this, new JLabel("Data Vencimento:"), 240, 250, 100, 20);
		JTextField dataVencimentoField = (JTextField) PanelUtils.create(this, new JTextField(), 330, 250, 140, 20);
		
		JButton criarButton = (JButton) PanelUtils.create(this, new JButton("Abrir Conta"), 95, 5, 130, 30);
		
criarButton.addActionListener(event -> {
			
			Cliente cliente;	
			try { cliente = ClienteDao.findByCPF(cpfClienteField.getText()); 
			} catch (NullPointerException error) {
				cliente = new Cliente();
				
				cliente.setNome(nomeClienteField.getText());
				cliente.setCPF(cpfClienteField.getText());
				cliente.setDataNascimento(LocalDate.parse(dataNascimentoField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				cliente.setTelefone(telefoneField.getText());
				cliente.setSenha(senhaClienteField.getText());
				
				Endereco endereco = new Endereco();
				try { endereco.setCEP(cepField.getText(0, 8));
				} catch (BadLocationException superError) { error.printStackTrace(); }
				endereco.setEstado(estadoField.getText());
				endereco.setCidade(cidadeField.getText());
				endereco.setBairro(bairroField.getText());
				endereco.setLocal(localField.getText());
				endereco.setNumeroCasa(Integer.parseInt(numeroCasaField.getText()));
				
				cliente.setEndereco(endereco);
				
				UsuarioDAO.save(cliente);
				cliente.setID(UsuarioDAO.getIdByCPF(cliente.getCPF()));
				ClienteDao.save(cliente);
			}
			
			ContaCorrente conta = new ContaCorrente();
			
			conta.setCliente(cliente);
			conta.setAgencia(agenciaField.getText());
			conta.setSaldo(Double.valueOf(saldoField.getText()));
			conta.setNumero(Integer.parseInt(numeroContaField.getText()));
			
			conta.setLimite(Double.valueOf(limiteField.getText()));
			conta.setDataVencimento(LocalDate.parse(dataVencimentoField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			
			ContaDAO.save(conta);
			ContaCorrenteDAO.save(conta);
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new AberturaContaView());
		});
		
		sairButton.addActionListener(event -> {
			MainView window = (MainView) SwingUtilities.getWindowAncestor(this);
			if (window != null) window.switchPanel(new AberturaContaView());
		});
	}
}
