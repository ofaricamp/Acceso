package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ejerc6 {
	static ArrayList<String> contenedor = new ArrayList<>();
	static File file = new File("C:\\DirectorioPadre\\Directorio1\\union.txt");
	
	public static void leeConjuntoDeCaracteres(File fichero, int cantidad, String rutaParaEscribir)
	throws IOException {
		try(FileReader lector = new FileReader(fichero)){
			contenedor.clear();
			char buffer[]= new char[cantidad];
			int i;
			int numeroDelArchivo = 1;
			if (cantidad > 0) {
				while((i = lector.read(buffer)) != -1) {
					System.out.println(new String(buffer,0,i));
					File file = new File(rutaParaEscribir + numeroDelArchivo +".txt");
					escribeFichero(file,new String(buffer,0,i));
					contenedor.add(new String(buffer,0,i));
					numeroDelArchivo++;
					unirFicheros(contenedor, file);
				}
			}
		}
	}
	
	public static void escribeFichero(File fichero,String cad) throws IOException{
		File ficheroParaUnir = fichero;
		try (FileWriter fichOut = new FileWriter(fichero)){
			for (int i=0;i<cad.length();i++){
			fichOut.write(cad.charAt(i));
			}
		}
	}
	
	public static void leerLineasDelFichero(File fichero,int cantidad, String rutaParaEscribir) 
	throws IOException {
		contenedor.clear();
		int numeroDelArchivo = 15;
		int contador = 1;
		String lineaActual = "";
		String lineas= "";
		if (cantidad > 0) {
			try (Scanner sc = new Scanner(fichero)){
				while(sc.hasNextLine()){
					File fileL = new File(rutaParaEscribir + numeroDelArchivo +".txt");
					lineaActual = sc.nextLine();
					lineas += lineaActual;
					if(contador == cantidad) {
						escribeFichero(fileL,lineas);
						contenedor.add(lineas);
						numeroDelArchivo++;
						contador = 0;
						lineas = "";
					}
					contador++;
					if(!(sc.hasNextLine())) {
						contenedor.add(lineas);
						escribeFichero(fileL,lineas);	
					}
				}
			}
		}
	}
	// No se como hacerlo
	public static void unirFicheros( ArrayList<String> array,File ficheroParaUnir) throws IOException {
		try (FileWriter fichOut = new FileWriter(file,true)){
			for (int i = 0; i < array.size(); i++) {
				fichOut.write(array.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	} 
	
	public static void main (String [] args) throws IOException {
		File fichero = new File ("C:\\DirectorioPadre\\Directorio1\\aa.txt");
		String rutaParaEscribir = "C:\\DirectorioPAdre\\Directorio1\\archivo";
		
		leeConjuntoDeCaracteres(fichero,5,rutaParaEscribir);
		//leerLineasDelFichero(fichero,3,rutaParaEscribir);
	}
}


