package controle;
import modelo.*;

import java.util.Calendar;
import java.util.Date;

public class ControleRecebimento {
	private Recebimento[] recebimentos;
	private int numRecebimentos;
	private Conta c;
	
	public ControleRecebimento(ControleConta controlC) {
		Conta c = controlC.getConta();
		recebimentos = c.getRecebimentosCadastrados();
		numRecebimentos = c.getNumRecebimentos();
		
	}
	
	// dados[0] = posição
	// dados[1] = Descrição
	// dados[2] = tipo
	// dados[3] = Dinheiro Recebido
	public boolean adicionarEditarRecebimento(String[] dadosRecebimento, ControleConta controlC, int op) {
		Conta c = controlC.getConta();
		
		try {
			if(op == 1) { //Adicionar novo elemento
				Date d = Calendar.getInstance().getTime();
				Recebimento r = new Recebimento(d, dadosRecebimento[1], dadosRecebimento[2],Double.valueOf(dadosRecebimento[3]),c.getNumRecebimentos(),c);
				c.inserirEditarRecebimento(r, Integer.parseInt(dadosRecebimento[0]));
				controlC.calcularSaldo();
				return true;
			}else { //Edição de um elemento existente
				Date d = Calendar.getInstance().getTime();
				Recebimento r = new Recebimento(d, dadosRecebimento[1], dadosRecebimento[2],Double.valueOf(dadosRecebimento[3]),Integer.parseInt(dadosRecebimento[0]),c);
				c.inserirEditarRecebimento(r, Integer.parseInt(dadosRecebimento[0]));
				controlC.calcularSaldo();
				return true;
			
		}
		} catch (NumberFormatException exc2) {
			return false;
		}
			

	}
	
	public boolean removerRecebimento(int i, ControleConta controlC) {
		Conta c = controlC.getConta();
		
		if(i == (c.getNumRecebimentos()-1)) { //Lógica inspirada no codigo da professora para verificar se o elemento está no final da array
			int recebimentoRemovido = c.getDinheiroRecebido(i).getId();
			c.setNumRecebimentos(c.getNumRecebimentos()-1);
			c.setDinheiroRecebido(null, c.getNumRecebimentos());
			controlC.calcularSaldo();
			return true;
		} else if(i > c.getNumRecebimentos()) { //Posição dada não possui elementos
			return false;
		} else { //O elemento está no meio da array
			int recebimentoRemovido = c.getDinheiroRecebido(i).getId();
			int cont = 0;
			while(c.getDinheiroRecebido(cont).getId() != recebimentoRemovido) {
				cont++;
			}
			
			for(int j = cont; j < c.getNumRecebimentos() -1; j++) {
				c.setDinheiroRecebido(null, j);
				c.setDinheiroRecebido(c.getDinheiroRecebido(j+1), j);
				recebimentos[j].setId(recebimentos[j].getId()-1);
			}
			c.setDinheiroRecebido(null, c.getNumRecebimentos());
			c.setNumRecebimentos(c.getNumRecebimentos()-1);
			controlC.calcularSaldo();
			return true;
		}
	}
	
	public String[] getDescricoesValor(ControleConta controlC) {
		Conta c = controlC.getConta();
		recebimentos = c.getRecebimentosCadastrados(); //Sempre que for pegar as descrições, é necessário atualizar a lista de elementos
		numRecebimentos = c.getNumRecebimentos();
		String[] s = new String[numRecebimentos];
		for(int i = 0; i < numRecebimentos; i++) {
			s[i] = recebimentos[i].toString();
		}
		return s;
	}
	
	public int getNum() {
		return numRecebimentos;
	}
	
	public void setNum(int num) {
		this.numRecebimentos = num;
	}
	
	public String getDescricao(int i) {
		return recebimentos[i].getDescricao();
	}
	
	public String getTipo(int i) {
		return recebimentos[i].getTipo();
	}
	
	public String getValor(int i) {
		String valor = String.valueOf(recebimentos[i].getDinheiroRecebido());
		
		return valor;
	}
	
	public int getId(int i) {
		return recebimentos[i].getId();
	}
	
}
