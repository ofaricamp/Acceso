package ficheros;

public class Juego {
	public Juego(int valoracion, double d, String nombre) {
		super();
		this.valoracion = valoracion;
		this.precio = d;
		this.nombre = nombre;
	}

	private int valoracion;

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	private double precio;

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.valoracion+"\t"+this.precio+"\t"+this.nombre;
	}
}
