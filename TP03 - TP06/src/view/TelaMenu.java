package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

/**
 * Classe da interface gráfica da tela de menu do programa.
 * @author Natan Tavares Santana
 * @author Isaac Menezes Pereira
 * @version 1.0 (april 2021)
 */

public class TelaMenu implements ActionListener {
	private static JFrame janela = new JFrame("Controle Financeiro");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton recebimentos = new JButton("Recebimentos");
	private static JButton despesas = new JButton("Despesas");
	private static JButton usuario = new JButton("Usuario e Conta");
	private static JButton saldoMes = new JButton("Saldo por Mês");
	public static ControleConta controlC = new ControleConta();
	public static ControleRecebimento Dadosrecebimento = new ControleRecebimento(controlC);
	public static ControleDespesa Dadosdespesa = new ControleDespesa(controlC);
	
	/**
	 * Construtor da interface gráfica da tela de menu.
	 */
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(145, 10, 150, 30);
		
		usuario.setBounds(140, 50, 150, 30);
		recebimentos.setBounds(140, 100, 150, 30);
		despesas.setBounds(140, 150, 150, 30);
		saldoMes.setBounds(140, 200, 150, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(usuario);
		janela.add(recebimentos);
		janela.add(despesas);
		janela.add(saldoMes);

		janela.setSize(400, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		usuario.addActionListener(menu);
		recebimentos.addActionListener(menu);
		despesas.addActionListener(menu);
		saldoMes.addActionListener(menu);

	}
	
	/**
	 * Método para verificar qual butão foi apertado e direcionar para telas diferentes.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == recebimentos)
			new TelaEntrada().mostrarDados(Dadosrecebimento, Dadosdespesa, controlC ,1);
		
		if(src == despesas)
			new TelaEntrada().mostrarDados(Dadosrecebimento, Dadosdespesa, controlC ,2);
		
		if(src == usuario)
			new TelaUsuarioConta(controlC);
		if(src == saldoMes) { //Mostra o saldo por mes
			JOptionPane.showMessageDialog(null,"Saldo por Mês\n "
					+ "Janeiro: R$ " + controlC.calcularSaldoMes(0) + "\n"
					+ "Fevereiro: R$ " + controlC.calcularSaldoMes(1) + "\n"
					+ "Março: R$ " + controlC.calcularSaldoMes(2) + "\n"
					+ "Abril: R$ " + controlC.calcularSaldoMes(3) + "\n"
					+ "Maio: R$ " + controlC.calcularSaldoMes(4) + "\n"
					+ "Junho: R$ " + controlC.calcularSaldoMes(5) + "\n"
					+ "Julho: R$ " + controlC.calcularSaldoMes(6) + "\n"
					+ "Agosto: R$ " + controlC.calcularSaldoMes(7) + "\n"
					+ "Setembro: R$ " + controlC.calcularSaldoMes(8) + "\n"
					+ "Outubro: R$ " + controlC.calcularSaldoMes(9) + "\n"
					+ "Novembro: R$ " + controlC.calcularSaldoMes(10) + "\n"
					+ "Dezembro: R$ " + controlC.calcularSaldoMes(11), null, 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
