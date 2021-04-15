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
	private static JButton salvar = new JButton("Salvar");
	 
	
	
	public  TelaUsuarioConta(ControleConta c) {
		ControleConta conta = c;
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
		valorCpf = new JTextField(dados.getUsuario.getCpf, 14);
		valorCpf.setBounds(140, 100, 120, 20);
		janela.add(valorCpf);
		
		labelNomeConta.setFont(new Font("Arial", Font.PLAIN, 16));
		labelNomeConta.setBounds(20, 130, 120, 20);
		janela.add(labelNomeConta);
		//valorNomeConta = new JTextField(dados.getUsuario.get		não teria isso
		valorNomeConta.setBounds(140, 130, 250, 20);
		janela.add(valorNomeConta);
		
		salvar.setBounds(180, 185, 100, 25);
		janela.add(salvar);
		
		janela.setVisible(true);
	}

	public static void main(String[] args) {
		TelaUsuarioConta menu = new TelaUsuarioConta(); //?
		
		salvar.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == salvar) {
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Erro! Acao nao confere!", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
