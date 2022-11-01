

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HorarioComercio3 {

	public static void main(String[] args) {
		final int horaApertura = 8;
		final int minApertura = 30;
		final int horaCierre = 19;
		final int minCierre = 0;

		boolean estaAbierto = false;
		int hora = 0; //DECLARACION DE CONSTANTES Y VARIABLES
		int min = 0;
		try { //CARGA DE DATOS DE ENTRADA
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));  
			System.out.println ("Ingrese hora: ");
			hora = Integer.valueOf(entrada.readLine());
			System.out.println ("Ingrese min: ");
			min = Integer.valueOf(entrada.readLine());

			// Chequeo si es una hora valida
			if (hora >= 0 && hora < 24 && min >= 0 && min <= 59) {
				// Chequeo si el horario esta dentro del limite
				if (hora >= horaApertura && hora <= horaCierre) {
					switch (hora) {
					case horaApertura:
						if (min >= minApertura)
							estaAbierto = true;
						break;
					case horaCierre:
						if (min <= minCierre)
							estaAbierto = true;
						break;
					default:
						estaAbierto = true;
					}
				}

				if (estaAbierto) 
					System.out.println("Esta Abierto");
				else
					System.out.println("Esta Cerrado");
			}
			else
				System.out.println("HORA INCORRECTA");
		}
		catch (Exception exc ) {
			System.out.println("Error");
		}




	}

}
