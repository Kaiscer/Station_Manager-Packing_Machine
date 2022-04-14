package dam.eje2.main;

import java.util.*;

import dam.eje2.pojo.Estacion;
public class GestorEstaciones {
	
	static final int MIN_KM = 20;
	static final int MIN_PORC = 50;
	
	static Estacion [] gestorEstaciones;
	
	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner (System.in);
		
		inicializarArray();
		
		rellenarArray();
		
		sc.close();
		
		mostrarArray();
		
		realizarAnalisis();
		
	}

	private static void realizarAnalisis() {
		/*•	El programa deberá informar de cuántas estaciones abiertas se han introducido, 
		 * cuántas tienen más de 20 km esquiables abiertos y cuántas tienen más del 50% de km esquiables
		 */
		
		int contEabiertas = 0;
		int contMas20km = 0;
		int contMas50porc = 0;
		
		for (int i = 0; i < gestorEstaciones.length; i++) {
			
			if (gestorEstaciones[i].getEstado().equals(Estacion.ESTADO_A)) {
				contEabiertas++;
				
				if (gestorEstaciones[i].getKmEquiablesAbierto() > MIN_KM && gestorEstaciones[i].calcularKmEsquiables() > MIN_PORC) {
					contMas20km++;
					contMas50porc++;
				}
			}
		}
		
		
		
		System.out.println(contEabiertas);
		System.out.println(contMas20km);
		System.out.println(contMas50porc);
		
	}

	private static void mostrarArray() {
		
		System.out.println("\n*** ESTACIONES INTRODUCIDAS ***");
		
		
		for (int i = 0; i < gestorEstaciones.length; i++) {
			System.out.println("\n" + gestorEstaciones[i]);
			
		}
		
	}

	private static void rellenarArray() {
		
		String nombre;
		String provincia;
		String estado;
		String numRemontes;
		String numPistas;
		String numKmEsquiables;
		
		
		for (int i = 0; i < gestorEstaciones.length; i++) {
			System.out.println("Introduce el nombre de la " + (i+1) + "º pista");
			nombre = sc.nextLine();
			
			System.out.println("Introduce la provincia");
			provincia = sc.nextLine();
			
			System.out.println("Estado de la pista Eje: (" + Estacion.ESTADO_A + "/" + Estacion.ESTADO_C + ")");
			estado = sc.nextLine().toUpperCase();
						
				
			System.out.println("Números de Remontes Eje: (31/37)");
			numRemontes = sc.nextLine();
				
			System.out.println("Números de pistas Eje: (73/147)");
			numPistas = sc.nextLine();
				
			System.out.println("Números de Km Esquiables Eje: (57/182)");
			numKmEsquiables = sc.nextLine();
				
			gestorEstaciones[i] = new Estacion(nombre, provincia, estado, numRemontes, numPistas, numKmEsquiables);				
							

		}
		
		
	}

	//�	Se solicite la cantidad de estaciones que se van a introducir.
	private static void inicializarArray() {
		
		System.out.println("¿Cuantas pistas se van a introducir?");
		 int n = Integer.parseInt(sc.nextLine());
		 
		 
		 gestorEstaciones = new Estacion [n];
		
	}

}
