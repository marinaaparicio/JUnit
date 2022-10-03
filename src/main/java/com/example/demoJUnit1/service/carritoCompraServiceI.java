package com.example.demoJUnit1.service;

import java.util.List;

import com.example.demoJUnit1.model.Articulo;

public interface carritoCompraServiceI {

	
	public void limpiarCesta();
	
	public void addArticulo (Articulo a);
	
	public Integer getNumArticulo();
	
	public List<Articulo>getArticulos();
	
	public Double totalPrice();
	
	public Double calculadorDescuento(Double precio, Double porcentajeDescuento);
	
	public List<Articulo> getArticuloBBDD();

	
	public Double aplicarDescuento(Integer id, Double descuento);
	
	public void insertar (Integer id, Articulo articulo);
	
	
	
	
	/*
	 * CarritoCompraService:

- Definir un nuevo método insertar que tenga como parámetro de entrada un objeto de tipo artículo. Llamará al método insertar artículo de BaseDatos para ontener el ID del nuevo artículo. A parte, deberá añadir a la cesta el artículo

	 * 
	 * */

}
