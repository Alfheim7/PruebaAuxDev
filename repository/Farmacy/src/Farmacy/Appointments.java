package Farmacy;

import java.util.Scanner;

public class Appointments {

	public static void main(String[] args) {
		
		String paciente1 = "Maria Murcia";
		String paciente2 = "Ana Botero";

		int Date;
		Scanner fec = new Scanner(System.in);
		System.out.println("Hola doctor Diego, Por favor ingresa la fecha de la agenda que deseas consultar sin guiones o barras inclinadas");
		Date = fec.nextInt();
		
		int Hour;
		Scanner hor = new Scanner(System.in);
		System.out.println("Genial, para darte datos mas acertados, Indicanos el rango de hora que deseas consultar");
		Hour = hor.nextInt();
		
		int HourSa;
		Scanner horSa = new Scanner(System.in);
		System.out.println("Indicanos la hora de salida del paciente sin caracteres especiales");
		HourSa = horSa.nextInt();
		
		if (Date == 20231228 && Hour == 14 && HourSa == 1430) {
			System.out.println("Hola doctor Diego, Sus citas de hoy son: \n" + paciente1);
			
		} else if (Date == 20231229 && Hour == 15 && HourSa == 1530){
			System.out.println("Hola doctor Diego, Sus citas de hoy son: \n" + paciente2);

		} else {
			System.out.println("Hola doctor Diego, No tiene citas agendadas para esa fecha y hora");
		}
	}

}
