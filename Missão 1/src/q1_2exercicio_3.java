import java.util.Scanner; 

public class q1_2exercicio_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char operation;
		int num1;
		int num2;
		int result;
		
		System.out.print("Entre com a operação a ser realizada (+, - ou *):\n");
		operation = input.next().charAt(0);
		System.out.print("Entre com o primeiro número:\n");
		num1 = input.nextInt();
		System.out.print("Entre com o segundo número:\n");
		num2 = input.nextInt();
		
		if (operation == '+' || operation == '-' || operation == '*') {
			switch (operation) {
			case '+': 
				result = num1 + num2;
				System.out.print("O resultado da operação é: " + result);
				break;
			case '-':
				result = num1 - num2;
				System.out.print("O resultado da operação é: " + result);
				break;
			case '*':
				result = num1 * num2;
				System.out.print("O resultado da operação é: " + result);
				break;
			}
		} else {
			System.out.print("Operação inválida");
		}
		

	}

}
