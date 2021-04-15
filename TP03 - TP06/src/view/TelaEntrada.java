package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaEntrada implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroRecebimento;
	private JButton refreshRecebimento;
	private JButton cadastroDespesa;
	private JButton refreshDespesa;
	private static ControleRecebimento recebimentos;
	private static ControleDespesa despesas;
	private static ControleConta controlC;
	private JList<String> listaRecebimentosCadastrados;
	private JList<String> listaDespesasCadastradas;
	private String[] listaNomes = new String[50];
	
	public void mostrarDados(ControleRecebimento r, ControleDespesa d, ControleConta c ,int op) {
		recebimentos = r;
		despesas = d;
		controlC = c;
		
		switch(op) {
		case 1: //Mostrar dados de Recebimentos cadastrados
			listaNomes = recebimentos.getDescricoesValor(controlC);
			listaRecebimentosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Recebimentos");
			titulo = new JLabel ("Recebimentos Cadastrados");
			cadastroRecebimento = new JButton("Cadastrar");
			refreshRecebimento = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 350, 30);
			listaRecebimentosCadastrados.setBounds(20, 50, 250, 120);
			listaRecebimentosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaRecebimentosCadastrados.setVisibleRowCount(10);
			
			cadastroRecebimento.setBounds(120, 185, 100, 30);
			refreshRecebimento.setBounds(250, 185, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaRecebimentosCadastrados);
			janela.add(cadastroRecebimento);
			janela.add(refreshRecebimento);
			
			janela.setSize(500, 250);
			janela.setVisible(true);
			
			cadastroRecebimento.addActionListener(this);
			refreshRecebimento.addActionListener(this);
			listaRecebimentosCadastrados.addListSelectionListener(this);
			
			break;
			
		case 2: //Mostrar dados de Despesas cadastrados
			listaNomes = despesas.getDescricoesValor(controlC);
			listaDespesasCadastradas = new JList<String>(listaNomes);
			janela = new JFrame("Despesas");
			titulo = new JLabel ("Despesas Cadastradas");
			cadastroDespesa = new JButton("Cadastrar");
			refreshDespesa = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 350, 30);
			listaDespesasCadastradas.setBounds(20, 50, 250, 120);
			listaDespesasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaDespesasCadastradas.setVisibleRowCount(10);
			
			cadastroDespesa.setBounds(120, 185, 100, 30);
			refreshDespesa.setBounds(250, 185, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaDespesasCadastradas);
			janela.add(cadastroDespesa);
			janela.add(refreshDespesa);
			
			janela.setSize(500, 250);
			janela.setVisible(true);
			
			cadastroDespesa.addActionListener(this);
			refreshDespesa.addActionListener(this);
			listaDespesasCadastradas.addListSelectionListener(this);
			
			break;
			
		default:
			JOptionPane.showMessageDialog(null,"Op��o n�o encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
			
		}
	
	 public void actionPerformed(ActionEvent e) { //Captura eventos relacionados aos botoes da interface
		 Object src = e.getSource();
		 
		 //Cadastro de novo recebimento
		 if(src == cadastroRecebimento) {
			 new TelaDetalheEntrada().inserirEditar(1, recebimentos, despesas, controlC ,this, 0);
		 }
		 
		 //Cadastro de nova despesa
		 if(src == cadastroDespesa) {
			 new TelaDetalheEntrada().inserirEditar(2, recebimentos, despesas, controlC ,this, 0);
		 }
		 
		// Atualiza a lista de recebimentos mostrada no JList
			if(src == refreshRecebimento) {
				listaRecebimentosCadastrados.setListData(recebimentos.getDescricoesValor(controlC));			
				listaRecebimentosCadastrados.updateUI();
			}
			
		// Atualiza a lista de despesas mostrada no JList
			if(src == refreshDespesa) {
				listaDespesasCadastradas.setListData(despesas.getDescricoesValor(controlC));			
				listaDespesasCadastradas.updateUI();
			}
	 }
		//Captura eventos relacionados ao JList
			public void valueChanged(ListSelectionEvent e) {
				Object src = e.getSource();
		
				if(e.getValueIsAdjusting() && src == listaRecebimentosCadastrados) {
					new TelaDetalheEntrada().inserirEditar(3, recebimentos, despesas, controlC , this, 
							listaRecebimentosCadastrados.getSelectedIndex());
				}
		
				if(e.getValueIsAdjusting() && src == listaDespesasCadastradas) {
					new TelaDetalheEntrada().inserirEditar(4, recebimentos, despesas, controlC , this, 
							listaDespesasCadastradas.getSelectedIndex());
				}
			}
	 
	}
	
