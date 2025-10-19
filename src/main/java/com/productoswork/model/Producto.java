package com.productoswork.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProductos;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer catidades;

	

	public Producto() {

	}



	public Producto(Integer idProductos, String nombre, String descripcion, Double precio, Integer catidades) {
		super();
		this.idProductos = idProductos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.catidades = catidades;
	}



	public Integer getIdProductos() {
		return idProductos;
	}



	public void setIdProductos(Integer idProductos) {
		this.idProductos = idProductos;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public Integer getCatidades() {
		return catidades;
	}



	public void setCatidades(Integer catidades) {
		this.catidades = catidades;
	}



	@Override
	public String toString() {
		return "Producto [idProductos=" + idProductos + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", catidades=" + catidades + "]";
	}
	
	
}
