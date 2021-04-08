package controle;
import modelo.*;
import java.util.Date;

public class ControleRecebimento {
	private Recebimento[] recebimentos;
	private int numRecebimentos;
	private ControleConta controlC;
	
	public ControleRecebimento() {
		Conta c = controlC.getConta();
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
			
			Conta c = controlC.getConta();
			Date d = new Date();
			Recebimento r = new Recebimento(d, dadosRecebimento[1], dadosRecebimento[2],Integer.parseInt(dadosRecebimento[3]), c);
			c.inserirEditarRecebimento(r, Integer.parseInt(dadosRecebimento[0]));
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
