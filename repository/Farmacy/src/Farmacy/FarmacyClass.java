package Farmacy;

import java.util.Scanner;

public class FarmacyClass {

	public static void main(String[] args) {
		
		int document = 0;
		
		do {
			
			Scanner doc = new Scanner(System.in);
			
			System.out.println("Bienvenido a nuestro sistema de consulta de medicamentos, Para continuar por favor digita tu numero de documento");
			
			document = doc.nextInt();
		
		} while (document <= 0); {

			String [] medicine = {"Risperidona","Omeprazol","Migradorixina","Losartan"};
			
			System.out.println("Los medicamentos que tienes disponibles en tu farmacia son: " + medicine[0] + ", " + medicine[1] + ", " + medicine[2] + ", " + medicine[3] + ", Gracias por usar nuestro sistema de consulta. Que tenga buen dia");
		};
		
	}

}
