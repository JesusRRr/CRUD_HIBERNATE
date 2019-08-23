package com.hibernatepractica1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto {
	
	@Id
	private int idProducto;
	
	@Column
	private String nombreProducto;
	
	@Column
	private double precioProducto;
	
	@Column
	private int existenciaProducto;
	
	public Producto() {
		
	}
	
	public Producto(String nombreProducto, double precioProducto, int existenciaProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.existenciaProducto = existenciaProducto;
	}

	public Producto(int idProducto, String nombreProducto, double precioProducto, int existenciaProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.existenciaProducto = existenciaProducto;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public int getExistenciaProducto() {
		return existenciaProducto;
	}
	public void setExistenciaProducto(int existenciaProducto) {
		this.existenciaProducto = existenciaProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto="
				+ precioProducto + ", existenciaProducto=" + existenciaProducto + "]";
	}
	
	
}
