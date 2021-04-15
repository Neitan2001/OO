package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*; 
import modelo.*;

public class TelaUsuarioConta implements ActionListener {
	private static JFrame janela = new JFrame("Informações");
	private static JLabel titulo = new JLabel("Usuário e Conta");
	private static JLabel labelNomeUser = new JLabel("Usuário");
	private static JTextField valorNomeUser; 
	private static JLabel labelIdade = new JLabel("Idade");
	private static JTextField valorIdade;
	private static JLabel labelCpf = new JLabel("CPF");
	private static JTextField valorCpf;
	private static JLabel labelNomeConta = new JLabel("Nome da Conta");
	private static JTextField valorNomeConta;
	private static ControleConta conta;
	private String[] novoDado = new String[9];
	private static JButton salvar = new JButton("Salvar");
	 
	
	
	public  TelaUsuarioConta(ControleConta c) {
		conta = c;
		janela.setLayout(null);
		janela.setSize(450, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 16));
		titulo.setBounds(150, 7, 200, 20);
		janela.add(titulo);
		
		labelNomeUser.setFont(new Font("Arial", Font.PLAIN, 16));
		labelNomeUser.setBounds(20, 40, 80, 20);
		janela.add(labelNomeUser);
		////////////////////////////////////////////////////////////////////
		valorNomeUser = new JTextField(conta.getUsuario().getNome(), 200); 
		valorNomeUser.setBounds(140, 40, 250, 20);
		janela.add(valorNomeUser);
		
		labelIdade.setFont(new Font("Arial", Font.PLAIN, 16));
		labelIdade.setBounds(20, 70, 80, 20);
		janela.add(labelIdade);
		valorIdade = new JTextField(String.valueOf(conta.getUsuario().getIdade()), 200); 
		valorIdade.setBounds(140, 70, 30, 20);
		janela.add(valorIdade);
		
		labelCpf.setFont(new Font("Arial", Font.PLAIN, 16));
		labelCpf.setBounds(20, 100, 80, 20);
		janela.add(labelCpf);
		valorCpf = new JTextField(String.valueOf(conta.getUsuario().getCpf()), 200);
		valorCpf.setBounds(140, 100, 120, 20);
		janela.add(valorCpf);
		
		labelNomeConta.setFont(new Font("Arial", Font.PLAIN, 16));
		labelNomeConta.setBounds(20, 130, 120, 20);
		janela.add(labelNomeConta);
		valorNomeConta = new JTextField(conta.getConta().getNome());
		valorNomeConta.setBounds(140, 130, 250, 20);
		janela.add(valorNomeConta);
		
		salvar.setBounds(180, 185, 100, 25);
		janela.add(salvar);
		
		janela.setVisible(true);
		
		salvar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		try {
			if(src == salvar) {
				boolean res;
				//JOptionPane.showMessageDialog(null, "Salvo com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
				novoDado[0] = valorNomeUser.getText();
				novoDado[1] = valorIdade.getText();
				novoDado[2] = valorCpf.getText();
				novoDado[3] = valorNomeConta.getText();
				
				conta.getConta().setNome(novoDado[3]);
				
				res = conta.getControlU().EditarUsuario(novoDado, conta);
				
				if(res) {
					mensagemSucessoEdicao();
				}
				else mensagemErroEdicao();
				
			}
		} catch(NullPointerException exc1) {
			System.out.println(exc1);
			mensagemErroEdicao();
		} catch (NumberFormatException exc2) {
			System.out.println(exc2);
			mensagemErroEdicao();
		}
			//JOptionPane.showMessageDialog(null, "Erro! Acao nao confere!", null, JOptionPane.INFORMATION_MESSAGE);
	
	}
	
	public void mensagemSucessoEdicao() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroEdicao() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Valor n�o cont�m apenas n�meros", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
