package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import controle.*;

public class TelaDetalheEntrada implements ActionListener {
	
	private JFrame janela;
	private JLabel labelDescricao = new JLabel("Descrição: ");
	private JTextField valorDescricao;
	private JLabel labelDinheiro = new JLabel("Valor (R$):  ");
	private JTextField valorDinheiro;
	private JLabel labelTipo = new JLabel("Tipo: ");
	private JTextField valorTipo;
	private JLabel labelId;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleRecebimento recebimentos;
	private static ControleDespesa despesas;
	private static ControleConta controlC;
	private int posicao;
	private int opcao;
	private String s;
	
	public void inserirEditar(int op, ControleRecebimento r, ControleDespesa d, ControleConta c ,TelaEntrada p, int pos) {
		
		opcao = op;
		posicao = pos;
		recebimentos = r;
		despesas = d;
		controlC = c;
		
		if (op == 1) s = "Cadastro de Recebimento";
		if (op == 2) s = "Cadastro de Despesa";
		if (op == 3) s = "Detalhe de Recebimento";
		if (op == 4) s = "Detalhe de Despesa";
		
		janela = new JFrame(s);
		
		//Preenche dados com dados do recebimento clicado
		if (op == 3) {
			System.out.println(pos);
			valorDescricao = new JTextField(recebimentos.getDescricao(pos), 200);
			valorDinheiro = new JTextField(recebimentos.getValor(pos), 200);
			valorTipo = new JTextField(recebimentos.getTipo(pos), 200);
			labelId = new JLabel("Id: "+ recebimentos.getId(pos));
		} else if (op == 4) { //Preenche com dados da despesa clicada
			valorDescricao = new JTextField(despesas.getDescricao(pos), 200);
			valorDinheiro = new JTextField(despesas.getValor(pos), 200);
			valorTipo = new JTextField(despesas.getTipo(pos), 200);
			labelId = new JLabel("Id: "+ despesas.getId(pos));
		} else { // Nao preenche com dados
			
			valorDescricao = new JTextField(200);
			valorDinheiro = new JTextField(200);
			valorTipo = new JTextField(200);
			
			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		labelDescricao.setBounds(30, 20, 150, 25);
		valorDescricao.setBounds(180, 20, 180, 25);
		labelDinheiro.setBounds(30, 50, 150, 25);
		valorDinheiro.setBounds(180, 50, 180, 25);
		labelTipo.setBounds(30, 80, 180, 25);
		valorTipo.setBounds(180, 80, 180, 25);	
		
		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			labelId.setBounds(30, 110, 180, 25);
			this.janela.add(botaoExcluir);
			this.janela.add(labelId);
		}
		
		this.janela.add(labelDescricao);
		this.janela.add(valorDescricao);
		this.janela.add(labelDinheiro);
		this.janela.add(valorDinheiro);
		this.janela.add(labelTipo);
		this.janela.add(valorTipo);
		this.janela.add(botaoSalvar);
		
		this.janela.setLayout(null);

		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				
				if(opcao == 1) {//cadastro de recebimento
					novoDado[0] = Integer.toString(recebimentos.getNum());
				} else if (opcao == 2) { //cadastro de despesa
					novoDado[0] = Integer.toString(despesas.getNum());
				} else { //edicao de dado existente
					novoDado[0] = Integer.toString(posicao);
				}
				
				novoDado[1] = valorDescricao.getText();
				novoDado[2] = valorTipo.getText();
				novoDado[3] = valorDinheiro.getText();
				
				if(opcao == 1 || opcao == 3) {
					res = recebimentos.adicionarEditarRecebimento(novoDado, controlC);
				} else {
					res = despesas.adicionarEditarDespesa(novoDado, controlC);
				}
				
				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();
				
			} catch(NullPointerException exc1) {
				System.out.println(exc1);
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				System.out.println(exc2);
				mensagemErroCadastro();
			}
		}
		
		if(src == botaoExcluir) {
			boolean res = false;
			
			if(opcao == 3) { //exclui recebimento
				res = recebimentos.removerRecebimento(posicao, controlC);
				if (res) mensagemSucessoExclusao();
				else mensagemErroExclusao();
			}
			
			if (opcao == 4) { //exclui despesa
				res = despesas.removerDespesa(posicao, controlC);
				if (res) mensagemSucessoExclusao();
				else mensagemErroExclusao();
			}
		}
	}
	
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Valor n�o cont�m apenas n�meros", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
}
