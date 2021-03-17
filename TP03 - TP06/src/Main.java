import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
	static Usuario u;
	static Conta c;
	
		public static void main(String[] args) {
			Despesa des;
			Recebimento rec;
			
			GregorianCalendar d= new GregorianCalendar();
			Date agora = d.getTime();
			
			u = new Usuario("Natan", 19, 8567856);
			
			c = new Conta("Poupança", u);
			
			des = new Despesa(agora, "Burguer king", "Comida", 20, c);
			des.adicionar();
			des = new Despesa(agora, "Mac Donalds", "Comida", 10, c);
			des.adicionar();
			
			rec = new Recebimento(agora, "Sálario da escola", "Salário", 200, c);
			rec.adicionar();
			rec = new Recebimento(agora, "Dinheiro da aposta", "Jogo do bixo", 1000, c);
			rec.adicionar();
			
			System.out.println(u.toString());
			c.calcularSaldo();
			System.out.println(c.toString());
			System.out.println(c.consultarSaldo());
			
		}
}
