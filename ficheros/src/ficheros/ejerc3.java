package ficheros;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ejerc3 {
	public static void leeFichero(File fichero, char caracter) throws IOException{
		try(FileReader lector = new FileReader(fichero)){
			int i;
			int contador = 0;
			while((i = lector.read()) != -1) {
				// System.out.println((char) i);
				if((char) i == caracter) {
					contador ++;
				}
				
			}
			System.out.printf("\n La letra '%c' aparece %d veces",caracter,contador);
		}
	}
	public static void main(String[] args) throws IOException {
		File fichero = new File ("C:\\DirectorioPadre\\Directorio1\\Txt1.txt");
		
		leeFichero(fichero,'f');
		leeFichero(fichero,'d');
		leeFichero(fichero,'a');
	}
	

}
