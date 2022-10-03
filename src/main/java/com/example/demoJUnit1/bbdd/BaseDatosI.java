package com.example.demoJUnit1.bbdd;

import java.util.List;

import com.example.demoJUnit1.model.Articulo;

public interface BaseDatosI {
	
	public void iniciarBBDD();
	
	public List<Articulo> getArticulos();
	
	public Articulo getArticuloId(Integer id);
	
	public Articulo insertarArticulo(Articulo articulo, Integer id);

	
	/*BaseDatos:

- Definir un nuevo método que inserte un articulo en la BBDD. EL parámetro de entrada será un objeto de tipo Artículo y devolverá el ID del artículo que se ha insertado


*/
	
}
