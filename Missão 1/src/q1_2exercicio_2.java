import java.util.Scanner; 

public class q1_2exercicio_2 {
    public static void main(String[] args) {
        int dia;
        int mes;
        int ano;
        boolean bissexto; 
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o dia:\n");    
        dia = ler.nextInt();
        System.out.print("Digite o mes:\n");
        mes = ler.nextInt();
        System.out.print("Digite o ano:\n");
        ano = ler.nextInt();
        if ((ano % 4 == 0) && (ano % 100 !=0) || (ano % 400 == 0)) {
        	bissexto = true;
        } else {
        	bissexto = false;
        }
        
        if(mes >= 1 && mes <= 12) {
            // Data Válida
	        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) {
	            if(dia >= 1 && dia <= 31) {
	                System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
	            } else {
	                // Dia inválido
	                System.out.println("Data Inválida");
	            }
	        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
	            if(dia >= 1 && dia <= 30) {
	            	System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
	            } else {
	                // Dia inválido
	                System.out.println("Data Inválida");
	            }
	        } else if (mes == 2) {
	            if (bissexto) {
		            if(dia >= 1 && dia <= 29) {
		                System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
		            } else {
		                // Dia inválido
		                System.out.println("Data Inválida");
		            }
	            } else {
		            if(dia >= 1 && dia <= 28) {
		                System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
		            } else {
		                // Dia inválido
		                System.out.println("Data Inválida");
		            }
	            }
	        }
	    } else {
	        // Mes invalido
	        System.out.println("Data Inválida\n");
	    }
	}
        
}
