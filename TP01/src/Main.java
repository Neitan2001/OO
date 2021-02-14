import java.util.Scanner; 

public class Main {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Data[] datas = new Data[121]; // Coloquei como limite 121, pois como serão dados da última década, dará no máximo 120 vetores
		
		
		int item, quantDias;
		int[] quantVetores = {0}; //variável para controlar a quantidade de vetores já inseridos pelo usuário. Ela será uma array com um único vetor para que eu possa modificá-la dentro de funções sem retorná-la como valor
		
		for (int i = 0; i < 121; i++) {
		    datas[i] = new Data();
		} // É necessário fazer essa inicialização dos objetos para que não fiquem nulos
		
		do {
			System.out.print("**Menu**\n 1- Entrada de Temperaturas\n 2- Temperatura Média\n 3- Temperatura Mínima\n 4- Temperatura Máxima\n 5- Relatório Meteorológico\n 6- Sair\n");
			System.out.print("O que você deseja fazer: ");
			item = ler.nextInt();
			
			switch (item) {
			case 1:
				LerAno(datas, quantVetores);
				if (LerMes(datas, quantVetores)) { //Já que essa função valida se a data inserida ja foi adicionada, a tranformei em uma função booleana que só permite a entrada de temperatura se o mes for válido
					quantDias = ValidarQuantDias(datas, quantVetores);
					InserirTemperaturas(datas, quantVetores, quantDias);
				}
				
				quantVetores[0] ++;
				break;
			case 2:
				System.out.print("Opção 2\n");
				break;
			case 3:
				System.out.print("Opção 3\n");
				break;
			case 4:
				System.out.print("Opção 4\n");
				break;
			case 5:
				System.out.print("Opção 5\n");
				break;
			case 6:
				System.out.print("Tchau, volte sempre!\n");
				break;
			default:
				System.out.print("Opção inválida, tente novamente\n");
				break;
			}
		}while (item != 6);
	}
	
	public static void LerAno(Data [] datas, int [] quantVetores) { //Função para ler e validar o ano digitado pelo usuário
		Scanner ler = new Scanner(System.in);

		System.out.print("Digite o ano (entre 2011 e 2020): ");
		datas[quantVetores[0]].ano = ler.nextInt();
		
		while (datas[quantVetores[0]].ano < 2011 || datas[quantVetores[0]].ano > 2020) { // Verificar se o ano digitado está dentro da década pedida
			System.out.print("Ano inválido, tente novamente\n");
			System.out.print("Digite o ano (entre 2011 e 2020): ");
			datas[quantVetores[0]].ano = ler.nextInt();
		}
	}
	
	public static boolean LerMes(Data [] datas, int [] quantVetores) { //Função para ler e validar o mes digitado pelo usuário
		Scanner ler = new Scanner(System.in);
		int anoInserido = datas[quantVetores[0]].ano; //o ano inserido será o que se encontra no indice de quantidade de vetores
		
		System.out.print("Digite o mês: ");
		datas[quantVetores[0]].mes = ler.nextInt();
		
		while (datas[quantVetores[0]].mes < 1 || datas[quantVetores[0]].mes > 12) {
			System.out.print("Mês inválido, tente novamente\n");
			System.out.print("Digite o mês: ");
			datas[quantVetores[0]].mes = ler.nextInt();
		}
		for (int i = 0; i < quantVetores[0]; i++) {
			if (anoInserido == datas[i].ano) {
				if (datas[quantVetores[0]].mes == datas[i].mes) {
					System.out.print("Essa data já foi inserida! Voltando ao menu...\n");
					quantVetores[0] --; //Já que a data já existe, a quantidade de vetores precisa diminuir para invalidar o que foi inserido
					return false;
				} else {
					return true;
				}
			}
		}
		return true;
	}
	
	public static int ValidarQuantDias(Data [] datas, int [] quantVetores) { //Função que verifica a quantidade de dias do mes digitado
		Scanner ler = new Scanner(System.in);
		int quantDias = 0;
		boolean bissexto;
		int ano = datas[quantVetores[0]].ano;
		int mes = datas[quantVetores[0]].mes;
		
		if ((ano % 4 == 0) && (ano % 100 !=0) || (ano % 400 == 0)) {
        	bissexto = true;
        } else {
        	bissexto = false;
        }
        
        if(mes >= 1 && mes <= 12) {
            // Data Válida
	        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) {
	            quantDias = 31;
	        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
	            quantDias = 30;
	        } else if (mes == 2) {
	            if (bissexto) {
		            quantDias = 29;
	            } else {
		            quantDias = 28;
	            }
	        }
	    }

		return quantDias;
	}
	
	public static void InserirTemperaturas(Data [] datas, int [] quantVetores, int quantDias) {
		Scanner ler = new Scanner(System.in);
		for (int i = 0; i < quantDias; i++) {
			System.out.print("Digite a média de temperatura do dia " + (i+1) + "º: \n");
			datas[quantVetores[0]].temperaturas[i] = ler.nextDouble();
		}
	}
}