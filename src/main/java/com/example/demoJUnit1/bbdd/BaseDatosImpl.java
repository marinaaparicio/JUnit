package com.example.demoJUnit1.bbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demoJUnit1.model.Articulo;

public class BaseDatosImpl implements BaseDatosI{

	
	private Map<Integer, Articulo> baseDatos = new HashMap<>();
	@Override
	public void iniciarBBDD() {
		
		
		
		baseDatos.put(1, new Articulo("pantalon", 20D));
		baseDatos.put(2, new Articulo("camisa", 30D));
		baseDatos.put(3, new Articulo("jersey", 40D));
		baseDatos.put(4, new Articulo("vestido", 50D));
		
		
	}
	@Override
	public List<Articulo> getArticulos() {
		List<Articulo> listaArticulos = new ArrayList<>();
		for(Map.Entry<Integer,  Articulo> entry: baseDatos.entrySet()) {
			listaArticulos.add(entry.getValue());
			
		}
		return listaArticulos;
	}
	@Override
	public Articulo getArticuloId(Integer id) {
		
		return baseDatos.get(id);
	}
	
	@Override
	public Articulo insertarArticulo(Articulo articulo, Integer id) {
		
		List<Articulo> listaArticulos = new ArrayList<>();
		listaArticulos.add(articulo);
		return baseDatos.get(id);
	}
	
	

}
