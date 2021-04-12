package controle;
import modelo.*;

import java.util.Calendar;
import java.util.Date;

public class ControleRecebimento {
	private Recebimento[] recebimentos;
	private int numRecebimentos;
	private ControleConta controlC = new ControleConta();
	private Conta c = controlC.getConta();
	
	public ControleRecebimento() {
		recebimentos = c.getRecebimentosCadastrados();
		numRecebimentos = c.getNumRecebimentos();
		
	}
	
	// dados[0] = posição
	// dados[1] = Descrição
	// dados[2] = tipo
	// dados[3] = Dinheiro Recebido
	public boolean adicionarEditarRecebimento(String[] dadosRecebimento,int i) {
		
		if(!dadosRecebimento[3].matches("[0-9]+")) {
			return false;
		} else {
			
			Date d = Calendar.getInstance().getTime();
			Recebimento r = new Recebimento(d, dadosRecebimento[1], dadosRecebimento[2],Integer.parseInt(dadosRecebimento[3]), c);
			c.inserirEditarRecebimento(r, Integer.parseInt(dadosRecebimento[0]));
			return true;
		}

	}
	
	public boolean removerRecebimento(int i) {
		String recebimentoRemovido = c.getDinheiroRecebido(i).getDescricao();
		
		if(i == (c.getNumRecebimentos()-1)) { //Lógica inspirada no codigo da professora para verificar se o elemento está no final da array
			c.setNumRecebimentos(c.getNumRecebimentos()-1);
			c.setDinheiroRecebido(null, c.getNumRecebimentos());
			return true;
		} else { //O elemento está no meio da array
			int cont = 0;
			while(c.getDinheiroRecebido(cont).getDescricao().compareTo(recebimentoRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < c.getNumRecebimentos() -1; j++) {
				c.setDinheiroRecebido(null, j);
				c.setDinheiroRecebido(c.getDinheiroRecebido(j+1), j);
			}
			c.setDinheiroRecebido(null, c.getNumRecebimentos());
			c.setNumRecebimentos(c.getNumRecebimentos()-1);
			return true;
		}
	}
	
	public String[] getDescricoesValor() {
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
	
	
}
