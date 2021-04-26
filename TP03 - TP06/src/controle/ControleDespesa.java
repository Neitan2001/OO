package controle;
import modelo.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe controladora da despesa do usuário
 * @author Natan Tavares Santana
 * @author Isaac Menezes Pereira
 * @version 1.0 (march 2021)
 */

public class ControleDespesa {
	private Despesa[] despesas;
	private int numDespesas;
	private Conta c;
	
	/**
	 * Construtor da classe controladora de despesa. Recebe a conta do usuário e pega as despesas e a quantidade de despesas dela.
	 * @param controlC
	 * parâmetro conta
	 */
	public ControleDespesa(ControleConta controlC) {
		Conta c = controlC.getConta();
		despesas = c.getDespesasCadastradas();
		numDespesas = c.getNumDespesas();
		
	}
	
	/**
	 * Método para adicionar ou editar despesa, recebe uma string de dados, a conta e a opção do método (Adicionar ou Editar). A orden dos dados na string é:
	 * dados[0] = posição
	 * dados[1] = Descrição
	 * dados[2] = tipo
	 * dados[3] = Dinheiro Gasto
	 * @param dadosDespesa
	 * parâmetro dados da despesa
	 * @param controlC
	 * parâmetro controle conta
	 * @param op
	 * parâmetro opção
	 * @return retorna um booleano, falso se tiver algum erro ou verdadeiro se tiver dado certo.
	 */
	public boolean adicionarEditarDespesa(String[] dadosDespesa, ControleConta controlC, int op) {
		Conta c = controlC.getConta();
		
			try {
				if(op == 1) { //Adicionar novo elemento
					Date d = Calendar.getInstance().getTime();
					Despesa r = new Despesa(d, dadosDespesa[1], dadosDespesa[2],Double.valueOf(dadosDespesa[3]), c.getNumDespesas(),c);
					c.inserirEditarDespesa(r, Integer.parseInt(dadosDespesa[0]));
					controlC.calcularSaldo();
					return true;
				} else {
					Date d = Calendar.getInstance().getTime();
					Despesa r = new Despesa(d, dadosDespesa[1], dadosDespesa[2],Double.valueOf(dadosDespesa[3]), Integer.parseInt(dadosDespesa[0]) ,c);
					c.inserirEditarDespesa(r, Integer.parseInt(dadosDespesa[0]));
					controlC.calcularSaldo();
					return true;
				}
			} catch (NumberFormatException exc2) {
				return false;
			}
			

	}
	
	/**
	 * Método para remover a despesa da conta do usuário. Recebe a posição da despesa na array de despesas e a conta do usuário.
	 * @param i
	 * parâmetro posição
	 * @param controlC
	 * parâmetro controle conta
	 * @return retorna um booleano, falso se tiver algum erro ou verdadeiro se tiver dado certo. 
	 */
	public boolean removerDespesa(int i, ControleConta controlC) {
		Conta c = controlC.getConta();
		
		if(i == (c.getNumDespesas()-1)) { //Lógica inspirada no codigo da professora para verificar se o elemento está no final da array
			int despesaRemovido = c.getDinheiroGasto(i).getId();
			c.setNumDespesas(c.getNumDespesas()-1);
			c.setDinheiroGasto(null, c.getNumDespesas());
			controlC.calcularSaldo();
			return true;
		} else if(i > c.getNumDespesas()) { //Posição dada não possui elementos
			return false;
		} else { //O elemento está no meio da array
			int despesaRemovido = c.getDinheiroGasto(i).getId();
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
	
	/**
	 * Método para pegar as descrições das despesas cadastradas. Recebe a conta do usuário.
	 * @param controlC
	 * parâmetro controle conta
	 * @return retorna uma string de descrições para ser exibida na lista de despesas cadastradas.
	 */
	public String[] getDescricoesValor(ControleConta controlC) {
		Conta c = controlC.getConta(); //Sempre que for pegar as descrições, é necessário atualizar a lista de elementos
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
