package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class practica_examen {
	
	public static Juego readTab(File fichero, int posicion) throws FileNotFoundException {
        int cont = 1;

        if (fichero.exists() && fichero.isFile()) {
            try (Scanner sc = new Scanner(fichero)) {
                // sc.useLocale(Locale.US); // Se usa idioma inglés si los doubles se separan
                // por puntos en vez de comas
                if (sc.hasNext()) {
                    sc.nextLine();
                }

                while (sc.hasNext()) {
                    if (cont == posicion) {
                        return new Juego(sc.nextInt(), sc.nextDouble(), sc.nextLine());
                    } else {
                        sc.nextLine();
                    }

                    cont++;
                }
            }
        }

        return null;
    }
	
	public static boolean añadeJuego(File file, Juego juego) {
		
		if (juego != null) {
			try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file,true))){
				
				out.writeInt(juego.getValoracion());
				out.writeUTF("\t");
				out.writeDouble(juego.getPrecio());
				out.writeUTF("\t");
				out.writeUTF(juego.getNombre());	
				
				return true;
				
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
	public static void showAll(File file) throws FileNotFoundException, IOException {
		
		try (DataInputStream in = new DataInputStream(new FileInputStream(file))){
			while (in.available() > 0) {
				System.out.printf("%d\t%f\t%s\n",in.readInt(),in.readDouble(),in.readUTF());
			}
			
		} catch (EOFException e) {
			System.out.println("fin del fichero");
		}
	}
	
	public static void addAll(File file,File binary) throws FileNotFoundException  {
		int cont = 1;
		try {
			Juego juego;
			while (true) {
				juego = readTab(file, cont);
				añadeJuego(binary, juego);
				cont++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) throws IOException {
		File txt = new File("C:\\Nueva carpeta\\Juegos.txt");
		File binary = new File("C:\\Nueva carpeta\\Juegos.dat");
		
		Juego juego = readTab(txt, 8);
		
		if (añadeJuego(binary, juego)) {
			System.out.println("OScar funciono");
		} else {
			System.out.println("Vas a suspender subnormal");
		}
		
		showAll(binary);
		addAll(txt, binary);
		
	}
}
