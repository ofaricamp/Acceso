package ejem1;

public class Deportista {

	private int id;
	private String deporte;
	private String genero;
	private String nombre;
	private int activo;
	
	public Deportista() {}
	
	public Deportista(int id, String nombre, int activo, String genero, String deporte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.genero = genero;
		this.deporte = deporte;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int isActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
}
