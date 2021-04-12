package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaEntrada {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroRecebimento;
	private JButton refreshRecebimento;
	private JButton cadastroDespesa;
	private JButton refreshDespesa;
	private static ControleRecebimento recebimentos;
	private static ControleDespesa despesas;
	private JList<String> listaRecebimentosCadastrados;
	private JList<String> listaDespesasCadastradas;
	private String[] listaNomes = new String[50];
	
	public void mostrarDados(ControleRecebimento r, ControleDespesa d, int op) {
		recebimentos = r;
		despesas = d;
		
		switch(op) {
		case 1: //Mostrar dados de Recebimentos cadastrados
			listaNomes = recebimentos.getDescricoesValor();
			listaRecebimentosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Recebimentos");
			titulo = new JLabel ("Recebimentos Cadastrados");
			cadastroRecebimento = new JButton("Cadastrar");
			refreshRecebimento = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaRecebimentosCadastrados.setBounds(20, 50, 350, 120);
			listaRecebimentosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaRecebimentosCadastrados.setVisibleRowCount(10);
			
			cadastroRecebimento.setBounds(70, 177, 100, 30);
			refreshRecebimento.setBounds(200, 177, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaRecebimentosCadastrados);
			janela.add(cadastroRecebimento);
			janela.add(refreshRecebimento);
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			break;
			
		default:
			JOptionPane.showMessageDialog(null,"Op��o n�o encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
			
		}
	}
	
