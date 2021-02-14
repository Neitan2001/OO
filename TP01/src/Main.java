import java.util.Scanner; 

public class Main {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Data[] datas = new Data[121]; // Coloquei como limite 121, pois como serão dados da última década, dará no máximo 120 vetores
		
		
		int item, indiceBusca;
		int[] quantVetores = {1}; //variável para controlar a quantidade de vetores já inseridos pelo usuário. Ela será uma array com um único vetor para que eu possa modificá-la dentro de funções sem retorná-la como valor. Como já existirá uma data registrada, essa variável começa sendo 1
		
		for (int i = 0; i < 121; i++) {
		    datas[i] = new Data();
		} // É necessário fazer essa inicialização dos objetos para que não fiquem nulos
		
		// DADOS PARA FACILITAR CORREÇÃO
		datas[0].ano = 2020;
		datas[0].mes = 1;
		datas[0].quantDias = 31;
		for (int i = 0; i < datas[0].quantDias; i++) {
			datas[0].temperaturas[i] = i;
		}
		//FIM DOS DADOS PARA FACILITAR CORREÇÃO
		
		do {
			System.out.print("**Menu**\n 1- Entrada de Temperaturas\n 2- Temperatura Média\n 3- Temperatura Mínima\n 4- Temperatura Máxima\n 5- Relatório Meteorológico\n 6- Sair\n");
			System.out.print("O que você deseja fazer: ");
			item = ler.nextInt();
			
			switch (item) {
			case 1:
				LerAno(datas, quantVetores);
				if (LerMes(datas, quantVetores)) { //Já que essa função valida se a data inserida ja foi adicionada, a tranformei em uma função booleana que só permite a entrada de temperatura se o mes for válido
					ValidarQuantDias(datas, quantVetores);
					InserirTemperaturas(datas, quantVetores);
				}
				
				quantVetores[0] ++;
				break;
			case 2:
				indiceBusca = BuscarData(datas, quantVetores);
				if (indiceBusca >= 0) {
					CalcularMedia(datas, indiceBusca);
				} else {
					System.out.print("Data não encontrada!\n");
				}
				break;
			case 3:
				indiceBusca = BuscarData(datas, quantVetores);
				if (indiceBusca >= 0) {
					CalcularTemperaturaMinima(datas, indiceBusca);
				} else {
					System.out.print("Data não encontrada!\n");
				}
				break;
			case 4:
				indiceBusca = BuscarData(datas, quantVetores);
				if (indiceBusca >= 0) {
					CalcularTemperaturaMaxima(datas, indiceBusca);
				} else {
					System.out.print("Data não encontrada!\n");
				}
				break;
			case 5:
				indiceBusca = BuscarData(datas, quantVetores);
				if (indiceBusca >= 0) {
					System.out.print("**INICIO DO RELATÓRIO**\n");
					
					ListarTemperaturas(datas, indiceBusca);
					CalcularMedia(datas, indiceBusca);
					CalcularTemperaturaMinima(datas, indiceBusca);
					CalcularTemperaturaMaxima(datas, indiceBusca);
					
					System.out.print("**FIM DO RELATÓRIO**\n");
				} else {
					System.out.print("Data não encontrada!\n");
				}
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
	
	public static void ValidarQuantDias(Data [] datas, int [] quantVetores) { //Função que verifica a quantidade de dias do mes digitado
		Scanner ler = new Scanner(System.in);
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
	            datas[quantVetores[0]].quantDias = 31;
	        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
	        	datas[quantVetores[0]].quantDias = 30;
	        } else if (mes == 2) {
	            if (bissexto) {
	            	datas[quantVetores[0]].quantDias = 29;
	            } else {
	            	datas[quantVetores[0]].quantDias = 28;
	            }
	        }
	    }
	}
	
	public static void InserirTemperaturas(Data [] datas, int [] quantVetores) {
		Scanner ler = new Scanner(System.in);
		for (int i = 0; i < datas[quantVetores[0]].quantDias; i++) {
			System.out.print("Digite a média de temperatura do dia " + (i+1) + "º: ");
			datas[quantVetores[0]].temperaturas[i] = ler.nextDouble();
		}
	}
	
	public static int BuscarData(Data [] datas, int [] quantVetores) {
		Scanner ler = new Scanner(System.in);
		int anoDigitado, mesDigitado;
		int indiceBusca = -1; //Usarei esse valor para controlar se o ano e o mês digitado foi encontrado ou não
		
		System.out.print("Digite o ano (entre 2011 e 2020): ");
		anoDigitado = ler.nextInt();
		
		while (anoDigitado < 2011 || anoDigitado > 2020) { // Verificar se o ano digitado está dentro da década pedida
			System.out.print("Ano inválido, tente novamente\n");
			System.out.print("Digite o ano (entre 2011 e 2020): ");
			anoDigitado = ler.nextInt();
		}
		System.out.print("Digite o mês: ");
		mesDigitado = ler.nextInt();
		
		while (mesDigitado < 1 || mesDigitado > 12) {
			System.out.print("Mês inválido, tente novamente\n");
			System.out.print("Digite o mês: ");
			mesDigitado = ler.nextInt();
		}
		for (int i=0; i < quantVetores[0]; i++) {
			if (anoDigitado == datas[i].ano && mesDigitado == datas[i].mes) {
				indiceBusca = i;
			}
		}
		return indiceBusca;
	}
	
	public static void CalcularMedia(Data [] datas, int indiceBusca) {
		double soma = 0, media;
		
		for (int i=0; i < datas[indiceBusca].quantDias; i++) {
			soma += datas[indiceBusca].temperaturas[i];
		}
		media = soma / datas[indiceBusca].quantDias;
		System.out.println("A média de temperatura do mes " + datas[indiceBusca].mes + " do ano " + datas[indiceBusca].ano + " é: " + media);
	}
	
	public static void CalcularTemperaturaMinima(Data [] datas, int indiceBusca) {
		double tempMinima = 1000;
		
		for (int i=0; i < datas[indiceBusca].quantDias; i++) { //Esse for loop verifica qual é o valor da temperatura mínima
			if (datas[indiceBusca].temperaturas[i] < tempMinima) {
				tempMinima = datas[indiceBusca].temperaturas[i];
			}
		}
		System.out.print("A temperatura mínima ocorreu no(s) dia(s): \n");
		for (int i=0; i < datas[indiceBusca].quantDias; i++) { //Esse for loop verifica quais dias possuem o valor da temperatura mínima
			if (datas[indiceBusca].temperaturas[i] == tempMinima) {
				System.out.println((i + 1) + "/" + datas[indiceBusca].mes + "/" + datas[indiceBusca].ano);
			}
		}
	}
	
	public static void CalcularTemperaturaMaxima(Data [] datas, int indiceBusca) {
		double tempMaxima = 0;
		
		for (int i=0; i < datas[indiceBusca].quantDias; i++) { //Esse for loop verifica qual é o valor da temperatura máxima
			if (datas[indiceBusca].temperaturas[i] > tempMaxima) {
				tempMaxima = datas[indiceBusca].temperaturas[i];
			}
		}
		System.out.print("A temperatura máxima ocorreu no(s) dia(s): \n"); 
		for (int i=0; i < datas[indiceBusca].quantDias; i++) { //Esse for loop verifica quais dias possuem o valor da temperatura máximo
			if (datas[indiceBusca].temperaturas[i] == tempMaxima) {
				System.out.println((i + 1) + "/" + datas[indiceBusca].mes + "/" + datas[indiceBusca].ano);
			}
		}
	}
	
	public static void ListarTemperaturas(Data [] datas, int indiceBusca) {
		System.out.print("-Inicio listagem de média de cada dia-\n");
		for (int i = 0; i < datas[indiceBusca].quantDias; i++) {
			System.out.println((i+1) + "/" + datas[indiceBusca].mes + "/" + datas[indiceBusca].ano + " - Média: " + datas[indiceBusca].temperaturas[i]);
		}
		System.out.print("-Fim listagem de média de cada dia-\n");
	}
}