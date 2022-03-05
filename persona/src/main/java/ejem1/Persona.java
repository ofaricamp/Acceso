package ejem1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
	
	private int id;
	private String nombre;
	private boolean casado;
	private String sexo;
	
	public Persona() {
		
	}
	
	public Persona(int id, String nombre, boolean casado, String sexo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.casado = casado;
		this.sexo = sexo;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isCasado() {
		return casado;
	}
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
