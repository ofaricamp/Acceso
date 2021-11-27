package ficheros;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class ejerc4 {
	public static void leeFichero(File fichero) throws IOException{
		HashMap<Character, Integer> hash =new HashMap<>();
		try(FileReader lector = new FileReader(fichero)){
			int i;
			int comparador = 0;
			char letra = ' ';
			
			while((i = lector.read()) != -1) {
				if(hash.containsKey((char)i)) {
					hash.put((char)i, hash.get((char)i)+1);
					}
				else {
					hash.put((char) (i), 1); 
				}
				if (comparador < hash.get((char) i)) {
					comparador = hash.get((char) i);
					letra = (char) i;
				}				
			}			
			//System.out.println(hash.size());
			//System.out.println(hash.get('a'));
			//System.out.println(hash.get('b'));
			//System.out.println(hash.get('c'));
			//System.out.println(hash.get('d'));
			//System.out.println(hash.entrySet());
			System.out.println("El caracter mas usado es: " + letra);
		}
	}
		
	
 public static void main (String[]args) throws IOException {
	 File fichero = new File ("C:\\DirectorioPadre\\Directorio1\\Txt1.txt");	 
	 leeFichero(fichero);
	
	
	 
 }
}

