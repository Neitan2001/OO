package controle;

import modelo.*;

public class ControleConta {
	private ControleUsuario controlU;
	private Conta c;
	
	public ControleConta() {
		Usuario u = controlU.getUsuario();
		c = new Conta("Nome padrão", u);
	}
	
	public Conta getConta() {
		return c;
	}
}
