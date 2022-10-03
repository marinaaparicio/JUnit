package com.example.demoJUnit1.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demoJUnit1.bbdd.BaseDatosI;
import com.example.demoJUnit1.model.Articulo;

public class carritoCompraServiceImpl implements carritoCompraServiceI{

	
	private List<Articulo> cesta = new ArrayList<>();
	
	private BaseDatosI baseDatos;
	
	@Override
	public void limpiarCesta() {
		cesta.clear();
		
	}


	@Override
	public void addArticulo(Articulo a) {
		
		cesta.add(a);
		
	}


	@Override
	public Integer getNumArticulo() {

		
		return cesta.size();
	}


	@Override
	public List<Articulo> getArticulos() {

		return cesta;
	}


	@Override
	public Double totalPrice() {

		
		Double total = 0D;
		
		for (Articulo articulo : cesta) {
			
			Double precio = articulo.getPrecio();
			
			total = total + precio;
		}
		
		return total;
	}


	@Override
	public Double calculadorDescuento(Double precio, Double porcentajeDescuento) {

		Double descuento = precio * porcentajeDescuento / 100;
		
		Double total = precio - descuento;
					
		return total;
	}


	@Override
	public List<Articulo> getArticuloBBDD() {
		baseDatos.iniciarBBDD();
		return baseDatos.getArticulos();
	}


	@Override
	public Double aplicarDescuento(Integer id, Double descuento) {
		Articulo articulo = baseDatos.getArticuloId(id);
		
		if(articulo !=null) {
			
			Double precioDesc = articulo.getPrecio() - (articulo.getPrecio() * (descuento / 100));
			
			return precioDesc;
		}else {
			
			System.out.println("El articulo no existe.");
		}
		return null;
	}


	@Override
	public void insertar(Integer id, Articulo articulo) {

		
		Articulo art= null;
		
		art = baseDatos.insertarArticulo(articulo, id);
		
		cesta.add(art);
		
		
		
		
	}



}
