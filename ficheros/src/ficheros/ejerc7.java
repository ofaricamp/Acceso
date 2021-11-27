package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class ejerc7 {
	static ArrayList<String> contenedor = new ArrayList<>();
	static boolean sensibleAlCaso = true;
	public static void contadorDeLineasYPalabras(File fichero) throws IOException {
		contenedor = new ArrayList();
		int contadorDeCadenas = 0;
		int contadorDeLineas = 0;
		String caracter = "";
		String linea = "";
		
		try (Scanner sc= new Scanner(fichero)){
			while (sc.hasNext()) {
				caracter = sc.next();
				if(caracter != "") {
					contenedor.add(caracter);
					contadorDeCadenas++;
				}
			}
			//ordenarCaracteresAscendente();
			try(Scanner sc2 = new Scanner(fichero)){
				while (sc2.hasNextLine()) {
					//if(sc2.next() != null) {
						linea = sc2.nextLine();
						if(linea != "") {
							contenedor.add(linea);
							contadorDeLineas++;
						}
					//}
				}
				ordenarLineasDescendente();
			}
			System.out.println("Lineas " + contadorDeLineas);
			System.out.println("palabras " + contadorDeCadenas);
			for (String palabra : contenedor) {
				//System.out.println(palabra);
			}
			for (String contenidoDeLaLinea : contenedor) {
				//System.out.println(contenedor);
			}
		}
	}
	
	public static void escribirEnElArchivo(String cadenaParaEscribir, File fichero) throws IOException {
		try (PrintWriter pw= new PrintWriter(new FileWriter(fichero, true))){
			pw.write(cadenaParaEscribir);
			}
	}
	
	public static void ordenarCaracteresAscendente() {
			Collections.sort(contenedor,String.CASE_INSENSITIVE_ORDER);
		for (String palabra : contenedor) {
			System.out.println(palabra);
		}
	}
	
	public static void ordenarLineasAscendente() {
			Collections.sort(contenedor,String.CASE_INSENSITIVE_ORDER);
		
		
		for (String palabra : contenedor) {
			System.out.println(palabra);
		}
	}

	
	public static void ordenarLineasDescendente() {
		
			Collections.sort(contenedor,String.CASE_INSENSITIVE_ORDER);
			Collections.reverse(contenedor);
		for (String palabra : contenedor) {
			System.out.println(palabra);
		}
	}
	public static void ordenarCaracteresDescendente(ArrayList<String> contenedor) {
			Collections.sort(contenedor,String.CASE_INSENSITIVE_ORDER);
			Collections.reverse(contenedor);
		for (String palabra : contenedor) {
			System.out.println(palabra);
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		File fichero =  new File("C:\\\\DirectorioPadre\\\\Directorio1\\\\bb.txt");
		contadorDeLineasYPalabras(fichero);
		//ordenarCaracteresDescendente(contenedor);
	}
}

