package ficheros;

import java.io.File;

public class ejerc1 {
	public static void divideFicherosDirectorios(File file) {
		 for(int i = 0; i < file.listFiles().length; i++) {			 			 		 
			 if (file.listFiles()[i].isDirectory()) {
				 System.out.println("directorio: " + file.listFiles()[i]);
			 }		
		 }
		 for(int j = 0; j < file.listFiles().length; j++) {
			 if(file.listFiles()[j].isFile()) {
				 System.out.println("fichero: " + file.listFiles()[j]);
			 }
		 }
	}
	 public static void main(String [] arg) {
		 File fichero = new File("C:\\DirectorioPadre\\Directorio1");
		 divideFicherosDirectorios(fichero);
	 }
	   

}