import java.util.Scanner; 

public class q1_exercicio_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int soma = 0;
		int num;
		
		do {
			System.out.print("Digite um numero positivo para ser somado ou negativo para sair:\n");
			num = input.nextInt();
			if (num >= 0) {
				soma +=num;
			}
		} while (num >= 0);
		System.out.print("A soma é: " + soma);

	}

}
