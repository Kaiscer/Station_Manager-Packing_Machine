package dam.eje1;
/*
 * EmpaquetadoraManzanas, para el control del empaquetado de 200 manzanas. 
 * 
 * Las manzanas se empaquetan en bandejas de 5 manzanas. 
 * 
 * El programa deber� solicitar el peso de cada manzana e irlo sumando de manera que cuando llegue 
 * 
 * a 5 indique el precio del paquete teniendo en cuenta que el kg est� a 1,85 � 
 */
import java.util.*;
public class EmpaquetadoraManzanas {
	
	static final int CONTROL = 200;
	static final int MAX_BANDEJA = 5;
	static final double PRECIO_X_KG = 1.85;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int contManzanas = 0;
		double precioXkg = 0;
		double sumaPeso = 0;
		
		
		for (int i = 1; i < CONTROL; i++) {
			System.out.println("Intreduce el peso de la " +  (i) + "º primera manzana");
			sumaPeso += Double.parseDouble(sc.nextLine());

			contManzanas ++;
			
			
			if (contManzanas == MAX_BANDEJA) {
				precioXkg = sumaPeso * PRECIO_X_KG;
				System.out.println("El peso del paquete " + sumaPeso + "Kg - Precio" + precioXkg + " eur " );
				contManzanas = 0;
				sumaPeso = 0;
				
			}else {
				System.out.println("Ingresa otra manzana");
			}
		
				
		}
		sc.close();	
	}

}
