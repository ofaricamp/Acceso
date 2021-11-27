package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ejerc8 {

	public static boolean lectorSinBuffer(File ficheroIn, File ficheroOut) throws FileNotFoundException, IOException {
		try (FileInputStream in = new FileInputStream(ficheroIn);
			 FileOutputStream out = new FileOutputStream(ficheroOut)){
			int c;
			while ((c = in.read())!= -1) {
				out.write(c);
			}
			return true;
		}catch (IOException e) {
			return false;
		} 
	}
	
	public static boolean lectorConBuffer(File ficheroIn,File ficheroOut,int cantidad) throws FileNotFoundException, IOException {

		if (cantidad > 0) {
			try(FileInputStream in = new FileInputStream(ficheroIn);
					FileOutputStream out = new FileOutputStream(ficheroOut)){
				int c;
				byte buffer[]= new byte[cantidad];
				while ((c = in.read(buffer))!= -1) {
					out.write(c);
				}
				return true;
			}catch (IOException e) {
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File ficheroACopiar = new File ("C:\\\\DirectorioPadre\\\\Directorio1\\\\aa.txt");
		File ficheroCopia = new File("C:\\\\DirectorioPadre\\\\Directorio1\\\\cc.txt");
		lectorSinBuffer(ficheroACopiar,ficheroCopia);
		lectorConBuffer(ficheroACopiar,ficheroCopia,3);
	}
}

