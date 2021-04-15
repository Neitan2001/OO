package controle;

import java.util.Calendar;
import java.util.Date;

import modelo.*;

public class ControleUsuario {
    private Usuario u = new Usuario("Nome", 20, 39283471);

    public Usuario getUsuario() {
        return u;
    }
    
    public boolean EditarUsuario(String[] dadosUsuario, ControleConta controlC) {
		ControleConta c = controlC;
		if(!dadosUsuario[1].matches("[0-9]+") || !dadosUsuario[2].matches("[0-9]+") ) {
			return false;
		} else {
			
			c.getUsuario().setNome(dadosUsuario[0]);
			c.getUsuario().setIdade(Integer.parseInt(dadosUsuario[1]));
			c.getUsuario().setCpf(Integer.parseInt(dadosUsuario[2]));
			
			return true;
		}

	}
}