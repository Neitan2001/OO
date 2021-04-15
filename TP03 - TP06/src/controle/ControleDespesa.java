package controle;
import modelo.*;

import java.util.Calendar;
import java.util.Date;

public class ControleDespesa {
	private Despesa[] despesas;
	private int numDespesas;
	private Conta c;
	
	public ControleDespesa(ControleConta controlC) {
		Conta c = controlC.getConta();
		despesas = c.getDespesasCadastradas();
		numDespesas = c.getNumDespesas();
		
	}
	
	// dados[0] = posição
	// dados[1] = Descrição
	// dados[2] = tipo
	// dados[3] = Dinheiro Recebido
	public boolean adicionarEditarDespesa(String[] dadosDespesa, ControleConta controlC) {
		Conta c = controlC.getConta();
		if(!dadosDespesa[3].matches("[0-9]+")) {
			return false;
		} else {
			
			Date d = Calendar.getInstance().getTime();
			Despesa r = new Despesa(d, dadosDespesa[1], dadosDespesa[2],Integer.parseInt(dadosDespesa[3]), c.getNumDespesas() ,c);
			c.inserirEditarDespesa(r, Integer.parseInt(dadosDespesa[0]));
			controlC.calcularSaldo();
			return true;
		}

	}
	
	public boolean removerDespesa(int i, ControleConta controlC) {
		Conta c = controlC.getConta();
		int despesaRemovido = c.getDinheiroGasto(i).getId();
		
		if(i == (c.getNumDespesas()-1)) { //Lógica inspirada no codigo da professora para verificar se o elemento está no final da array
			c.setNumDespesas(c.getNumDespesas()-1);
			c.setDinheiroGasto(null, c.getNumDespesas());
			controlC.calcularSaldo();
			return true;
		} else { //O elemento está no meio da array
			int cont = 0;
			while(c.getDinheiroGasto(cont).getId() != despesaRemovido) {
				cont++;
			}
			
			for(int j = cont; j < c.getNumDespesas() -1; j++) {
				c.setDinheiroGasto(null, j);
				c.setDinheiroGasto(c.getDinheiroGasto(j+1), j);
				despesas[j].setId(despesas[j].getId()-1);
			}
			c.setDinheiroGasto(null, c.getNumDespesas());
			c.setNumDespesas(c.getNumDespesas()-1);
			controlC.calcularSaldo();
			return true;
		}
	}
	
	public String[] getDescricoesValor(ControleConta controlC) {
		Conta c = controlC.getConta();
		despesas = c.getDespesasCadastradas();
		numDespesas = c.getNumDespesas();
		String[] s = new String[numDespesas];
		for(int i = 0; i < numDespesas; i++) {
			s[i] = despesas[i].toString();
		}
		return s;
	}
	
	public int getNum() {
		return numDespesas;
	}
	
	public void setNum(int num) {
		this.numDespesas = num;
	}
	
	public String getDescricao(int i) {
		return despesas[i].getDescricao();
	}
	
	public String getTipo(int i) {
		return despesas[i].getTipo();
	}
	
	public String getValor(int i) {
		String valor = String.valueOf(despesas[i].getDinheiroGasto());
		
		return valor;
	}
	
	public int getId(int i) {
		return despesas[i].getId();
	}
	
	
}
