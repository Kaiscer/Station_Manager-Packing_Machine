package dam.eje2.pojo;

import java.util.StringTokenizer;

/*
 * �	Que permita almacenar el nombre, la provincia, el estado (ABIERTA/CERRADA), el n�mero de remontes, 
 * el n�mero de pistas y el n�mero de km esquiables de una estaci�n de esqu�.
�	Que tenga un constructor que inicialice los seis atributos.

 */
public class Estacion {
	
	public static final String ESTADO_A = "ABIERTA";
	public static final String ESTADO_C = "CERRADA";
	
	private String nombre;
	private String provincia;
	private String estado;
	private String numRemontes;
	private String numPistas;
	private String kmEsquiables;
	
	public Estacion(String nombre, String provincia, String estado, String numRemontes, String numPistas,
			String kmEsquiables) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.estado = estado;
		this.numRemontes = numRemontes;
		this.numPistas = numPistas;
		this.kmEsquiables = kmEsquiables;
	}

	/*Formigal (Huesca)
	Estado: ABIERTA				
	Remontes: 31/37, Pistas: 73/147, Km esquiables: 57/182*/


	// Este método no es necesario invocarlo en el main porque al poner un syso y poner el arrays lo imprime 
	@Override
	public String toString() {
		String resultado = ""; 
			
				if (estado.toUpperCase().equals(ESTADO_A)) {
					resultado = nombre + "(" + provincia + ")\nEstado: " + estado +
							"\nRemontes: " + numRemontes + ", Números de Pistas: " + numPistas + ", Km esquiables: " + kmEsquiables + "\n";
					
				}else {
					resultado = nombre + "("+ provincia + ")\nEstado: "  + estado;
								
				}
				
		return resultado;
	}
	
	/*•	Que tenga un método que calcule el porcentaje de km esquiables con respecto al total.
Ejemplo: para 57/182 debería devolver un 31,32
•	Que tenga un método que retorne el número de km esquiables abiertos.
Ejemplo: para 57/182 debería devolver un 57*/

	
	public double  calcularKmEsquiables() {
		
		StringTokenizer st = new StringTokenizer(kmEsquiables,"/");
		
		double kmE = Double.parseDouble(st.nextToken());
		double kmT = Double.parseDouble(st.nextToken());
		
		/* kmT --- 100
		 * kmE ----- X 
		 * 
		 * x = kmE * 100 / kmT
		 */
		
		
		// Este método nos ayuda a redondear 
		
		double porc = Math.round((kmE * 100 / kmT) * 100) / 100.0;
		
		return porc;
		
		
	
		
	}
	
	public int getKmEquiablesAbierto() {
		
		int pos = kmEsquiables.indexOf("/");
		int kmE = Integer.parseInt(kmEsquiables.substring(pos,0));
		
		
		
		return kmE;
	}

	public String getEstado() {
		return estado;
	}
	
	
	
	
}
