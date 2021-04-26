package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

/**
 * Classe da interface gráfica da tela de Entradas.
 * @author Natan Tavares Santana
 * @author Isaac Menezes Pereira
 * @version 1.0 (april 2021)
 */

public class TelaEntrada implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroRecebimento;
	private JButton refreshRecebimento;
	private JButton cadastroDespesa;
	private JButton refreshDespesa;
	private static JLabel saldo;
	private static ControleRecebimento recebimentos;
	private static ControleDespesa despesas;
	private static ControleConta controlC;
	private JList<String> listaRecebimentosCadastrados;
	private JList<String> listaDespesasCadastradas;
	private String[] listaNomes = new String[50];
	
	/**
	 * Contrutor da interface gráfica da tela de Entradas, recebe o controle recebimento, controle despesa e controla conta para fazer a comunicação entre os dados e recebe a opção de mostrar as despesas ou recebimentos.
	 * @param r
	 * parâmetro controle recebimento
	 * @param d
	 * parâmetro controle despesa
	 * @param c
	 * parâmetro controle conta
	 * @param op
	 * parâmetro opção
	 */
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
			saldo = new JLabel("O seu saldo é R$ " + controlC.getConta().getSaldo());
			cadastroRecebimento = new JButton("Cadastrar");
			refreshRecebimento = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 350, 30);
			saldo.setFont(new Font("Arial", Font.PLAIN, 16));
			saldo.setBounds(120, 180, 200, 30);
			listaRecebimentosCadastrados.setBounds(20, 50, 450, 120);
			listaRecebimentosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaRecebimentosCadastrados.setVisibleRowCount(10);
			
			cadastroRecebimento.setBounds(120, 230, 120, 30);
			refreshRecebimento.setBounds(250, 230, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaRecebimentosCadastrados);
			janela.add(cadastroRecebimento);
			janela.add(refreshRecebimento);
			janela.add(saldo);
			
			janela.setSize(500, 300);
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
			saldo = new JLabel("O seu saldo é R$ " + controlC.getConta().getSaldo());
			cadastroDespesa = new JButton("Cadastrar");
			refreshDespesa = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 350, 30);
			saldo.setFont(new Font("Arial", Font.PLAIN, 16));
			saldo.setBounds(120, 180, 200, 30);
			listaDespesasCadastradas.setBounds(20, 50, 450, 120);
			listaDespesasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaDespesasCadastradas.setVisibleRowCount(10);
			
			cadastroDespesa.setBounds(120, 230, 120, 30);
			refreshDespesa.setBounds(250, 230, 100, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaDespesasCadastradas);
			janela.add(cadastroDespesa);
			janela.add(refreshDespesa);
			janela.add(saldo);
			
			janela.setSize(500, 300);
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
	
	/**
	 * Método para capturar os eventos relacionados aos botões da interface.
	 * Botão Cadastro Recebimento: chama o método para fazer o cadastro de recebimento.
	 * Botão Cadastro Despesa: chama o método para fazer o cadastro de despesa.
	 * Botão Refresh Recebimento: atualiza a lista de recebimentos cadastrados.
	 * Botão Refresh Despesa: atualiza a lista de despesas cadastradas.
	 */
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
		 
		// Atualiza a lista de recebimentos mostrada no JList e o saldo do usuário
			if(src == refreshRecebimento) {
				listaRecebimentosCadastrados.setListData(recebimentos.getDescricoesValor(controlC));			
				listaRecebimentosCadastrados.updateUI();
				saldo.setText("O seu saldo é R$ " + controlC.getConta().getSaldo());
			}
			
		// Atualiza a lista de despesas mostrada no JList e o saldo do usuário
			if(src == refreshDespesa) {
				listaDespesasCadastradas.setListData(despesas.getDescricoesValor(controlC));			
				listaDespesasCadastradas.updateUI();
				saldo.setText("O seu saldo é R$ " + controlC.getConta().getSaldo());
			}
	 }
	 
	 /**
	  * Método para capturar os eventos relacionados ao JList. Ao clicar em um recebimento ou despesa, é aberto a tela de detalhe.
	  */
			public void valueChanged(ListSelectionEvent e) {
				Object src = e.getSource();
		
				if(e.getValueIsAdjusting() && src == listaRecebimentosCadastrados) {
					new TelaDetalheEntrada().inserirEditar(3, recebimentos, despesas, controlC , this, 
							recebimentos.getId(listaRecebimentosCadastrados.getSelectedIndex()));
				}
		
				if(e.getValueIsAdjusting() && src == listaDespesasCadastradas) {
					new TelaDetalheEntrada().inserirEditar(4, recebimentos, despesas, controlC , this, 
							despesas.getId(listaDespesasCadastradas.getSelectedIndex()));
				}
			}
	 
	}
	
