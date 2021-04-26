package controle;

import java.util.Calendar;
import java.util.Date;

import modelo.*;

/**
 * Classe controladora do usuário
 * @author Natan Tavares Santana
 * @author Isaac Menezes Pereira
 * @version 1.0 (march 2021)
 */

public class ControleUsuario {
    private Usuario u = new Usuario("Nome", 20, 39283471);

    public Usuario getUsuario() {
        return u;
    }
    
    /**
     * Método para editar informações do usuário. Atualmente há um bug que ainda não conseguimos consertar que depois de editar uma vez, o programa aceita informações do tipo errado
     * @param dadosUsuario
     * parâmetro dados do usuário
     * @param controlC
     * parâmetro controle conta
     * @return retorna um booleano, falso se tiver algum erro ou verdadeiro se tiver dado certo.
     */
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