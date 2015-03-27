package co.com.udem.alquilerMaquinas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class maquina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMaquina;
	private String nombre;
	private float precio;
	private int descuento;
	private String descripcion;
	private boolean disponible;
	private String imagen;
	private float preciodescuento;
		
	/**
	 * @return the preciodescuento
	 */
	public float getPreciodescuento() {
		return preciodescuento;
	}
	/**
	 * @param preciodescuento the preciodescuento to set
	 */
	public void setPreciodescuento(float preciodescuento) {
		this.preciodescuento = preciodescuento;
	}
	public maquina() {
		super();
	}
	public maquina(String nombre, float precio, int descuento,
			String descripcion, boolean disponible, String imagen) {
		super();		
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.disponible = disponible;
		this.imagen = imagen;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the dispinible
	 */
	public boolean isDisponible() {
		return disponible;
	}
	/**
	 * @param dispinible the disponible to set
	 */
	public void setDisponible(boolean dispinible) {
		this.disponible = dispinible;
	}
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
