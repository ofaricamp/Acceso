package ficheros;

import java.io.File;

public class ejerc2 {
	public static void ListaComoComando(File archivo) {
		for(int i = 0; i < archivo.listFiles().length; i++ ) {
			System.out.println(archivo.listFiles()[i].getAbsolutePath());
		}
	}
	public static void main (String [] args) {
		File archivo = new File("C:\\DirectorioPadre\\Directorio1");
		ListaComoComando(archivo);
	}
}
