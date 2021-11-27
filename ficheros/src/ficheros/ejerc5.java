package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ejerc5 {
	public static void leeFichero(File fichero, String cadena) throws FileNotFoundException {
		Scanner sc = new Scanner(fichero);
		int contadorDeLineas = 1;
		String linea = "";
		boolean encontrado = false;
		try {
			sc = new Scanner(fichero);
			while (sc.hasNext()) {
				linea = sc.nextLine();
				if (linea.contains(cadena)) {
					encontrado = true;
					System.out.println("tu cadena sale en la linea: " + contadorDeLineas);
				}
				contadorDeLineas++;
			}
			if (encontrado == false) {
				System.out.println("No se escontro la cadena");
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\DirectorioPadre\\Directorio1\\Txt2.txt");
		String cadena = "alvaro";
		leeFichero(fichero, cadena);
		leeFichero(fichero, "casa");
	}

}
