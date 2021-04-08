package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaMenu implements ActionListener {
	private static JFrame janela = new JFrame("Controle Financeiro");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton recebimentos = new JButton("Recebimentos");
	private static JButton despesas = new JButton("Despesas");
	private static JButton usuario = new JButton("Usuario");
	private static JLabel saldo = new JLabel("O seu saldo é: R$200,00");
	
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(145, 10, 150, 30);
		
		usuario.setBounds(140, 50, 150, 30);
		recebimentos.setBounds(140, 100, 150, 30);
		despesas.setBounds(140, 150, 150, 30);
		
		saldo.setFont(new Font("Arial", Font.PLAIN, 16));
		saldo.setBounds(120, 180, 200, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(usuario);
		janela.add(recebimentos);
		janela.add(despesas);
		janela.add(saldo);
		
		janela.setSize(400, 250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	

	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		usuario.addActionListener(menu);
		recebimentos.addActionListener(menu);
		despesas.addActionListener(menu);

	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Botão clicado");
	}

}