
package com.rodriguez;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static final char DELIMITADOR = '-';
	public static final int SIZE_LINEA = 45;

	public static void readInputFromCommandLine(){
		System.out.println("Como te llamas ?");

		Scanner scanner = new Scanner(System.in);

		String linea = scanner.nextLine().toUpperCase();

		System.out.println( "Hola " + linea );
	}


	public String invertirString(String mensaje){

		char[] mensajeChar = mensaje.toCharArray();

		int max = mensajeChar.length - 1;

		StringBuilder resultado0 = new StringBuilder();

		for(int i = max; i > -1; i-- ){
			resultado0.append( mensajeChar[i] );
		}

		// StringBuilder resultado1 = new StringBuilder(mensaje).reverse();

		return resultado0.toString();
	}



	public static void showLine( int max, char delimitador ){
		if(max > 0 && max < 256 ){
			int maxLinea = 0;
			for( maxLinea = 0; maxLinea < max; maxLinea++ ){
				System.out.print( delimitador );
			}
			System.out.print("\n");
		}
	}

	public static void showLine( int max ){
		showLine(max, DELIMITADOR);
	}


	public static void showLine(){
		showLine( SIZE_LINEA, DELIMITADOR);
	}



	public static void charCodeTable(int sizeMaxLinea){
		charCodeTable(sizeMaxLinea, DELIMITADOR);
	}


	public static void charCodeTable(){
		charCodeTable(SIZE_LINEA, DELIMITADOR);
	}




	public static void charCodeTable(int sizeMaxLinea, char delimitador){

		showLine(sizeMaxLinea, delimitador);

		int contadorMaxLinea = 0;  // overflowNone

		for(int i = 32; i < 126; i++ ){

			// overflowNone
			contadorMaxLinea++;
			if(contadorMaxLinea == (sizeMaxLinea - 1) ){
				System.out.print("\n");
				contadorMaxLinea = 1;
			}
			if( contadorMaxLinea == 1){
				System.out.print(" ");
			}

			// overflowNone



			System.out.print( (char) i );
		}

		System.out.print("\n");
		showLine(sizeMaxLinea);


	}


	public static void verArray(int[] array){
		int max = array.length;
		for (int j : array) {
			System.out.print(" " + j);
		}
		System.out.print("\n");
	}


	public static void numeroMasRepetido() {
		System.out.println();
		System.out.println("""
		Dado un array de numeros,
		se debe buscar el numero que más se repite y
		mostrar cuantas veces se repite.
		""");

		final int[] NUMEROS = {1,2,2,3,5,5,6,7,7,8,8,8,9};

		final int max = NUMEROS.length;

		verArray(NUMEROS);

		int numeroActual = 0;
		int maxNumDiff = 0;
		int[] detalle;
		int vecesRepetido = 0;
		int IndiceMaxRepetido = 0;
		int maxTemp = 0;


		List<Integer> numerosDiferentes = new ArrayList<>();

		numerosDiferentes.add( NUMEROS[0] );

		for( int posActual = 0; posActual < (max - 1); posActual++ ){
			if( NUMEROS[posActual] != NUMEROS[posActual + 1] ){
				numerosDiferentes.add( NUMEROS[posActual + 1] );
			}
		}

		System.out.println("\nNúmeros sin repetir:");
		numerosDiferentes.forEach( numN -> System.out.print(" " + numN) );
		System.out.print("\n");

		maxNumDiff = numerosDiferentes.size();
		detalle = new int[maxNumDiff];

		for( int i = 0; i < maxNumDiff; i++ ){
			vecesRepetido = 0;
			for(int j = 0; j < max; j++ ){
				if( numerosDiferentes.get(i) == NUMEROS[j] ){
					vecesRepetido++;
					detalle[i] = vecesRepetido;
				}
			} // for2
		} // for1


		System.out.println("\nDetalle:");
		verArray(detalle);

		maxTemp = detalle[0];
		for (int i = 0; i < maxNumDiff; i++) {
			if( detalle[i] > maxTemp  ){
				IndiceMaxRepetido = i;
			}
		}

		System.out.println("\nIndice del número más repetido");
		System.out.println(IndiceMaxRepetido);

		System.out.println("\n=========");
		System.out.println("Resultado esperado:\n");
		System.out.println("El número: " + numerosDiferentes.get(IndiceMaxRepetido) );

		if( detalle[IndiceMaxRepetido] == 1 ){
			System.out.println("Se repite: " + detalle[IndiceMaxRepetido] + " vez");
		}
		else if ( detalle[IndiceMaxRepetido] > 1 ){
			System.out.println("Se repite: " + detalle[IndiceMaxRepetido] + " veces");
		}

		System.out.println("=========");
		System.out.println("\nDetalle:\n");
		for (int i = 0; i < maxNumDiff; i++){
			System.out.println("El número: " + numerosDiferentes.get(i) );
			if( detalle[i] == 1 ){
				System.out.println("Se repite: " + detalle[i] + " vez");
			}
			else if ( detalle[i] > 1 ){
				System.out.println("Se repite: " + detalle[i] + " veces");
			}
			System.out.print("\n");
		}

	} // ejercicio0


} // class
