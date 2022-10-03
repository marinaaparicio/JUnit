package com.example.demoJUnit1.service;


import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demoJUnit1.bbdd.BaseDatosI;
import com.example.demoJUnit1.model.Articulo;

@ExtendWith(MockitoExtension.class)
 class carritoCompraServiceImplTest {

	@InjectMocks
	carritoCompraServiceImpl carrito = new carritoCompraServiceImpl();
	
	@Mock
	private BaseDatosI baseDatos;
	
	
	@Test
	 void testLimpiarCesta() {
		
		
		carrito.limpiarCesta();
		
		Articulo articulo = new Articulo("Falda", 10D);
		
		carrito.addArticulo(articulo);
		List<Articulo> list = carrito.getArticulos();
		carrito.limpiarCesta();
		assert(carrito.getArticulos().isEmpty());
	}

	@Test
	 void testAddArticulo() {
		assertTrue(carrito.getArticulos().isEmpty());
		
		carrito.addArticulo(new Articulo("Vestido", 20D));
		
		assertFalse(carrito.getArticulos().isEmpty());
	}

	@Test
	 void testGetNumArticulo() {
		carrito.addArticulo(new Articulo("Vestido", 20D));
		carrito.addArticulo(new Articulo("Vestido", 20D));
		
		Integer resultado = carrito.getNumArticulo();
		
		assertEquals(2, resultado);
	}

	@Test
	 void testGetArticulos() {
		carrito.addArticulo(new Articulo("Vestido", 20D));
		carrito.addArticulo(new Articulo("camisa", 20D));
		List<Articulo> listado = carrito.getArticulos();
		
		assertEquals(2,listado.size());
		
		assertEquals("camisa", listado.get(1).getNombre());
		
		
	}
	
	@Test
	
	 void testGetArticulosBBDD() {
		
		List<Articulo> lista = new ArrayList<>();
		
		lista.add(new Articulo("pantalon", 20D));
		lista.add(new Articulo("camisa", 30D));
		lista.add(new Articulo("jersey", 40D));
		lista.add(new Articulo("vestido", 50D));
		when(baseDatos.getArticulos()).thenReturn(lista);
		List<Articulo> listado = carrito.getArticuloBBDD();
		assertEquals(4, listado.size());
	}

	@Test
	 void testTotalPrice() {
		carrito.addArticulo(new Articulo("Vestido", 30D));
		carrito.addArticulo(new Articulo("Vestido", 20D));
		
		Double resultado = carrito.totalPrice();
		
		assertEquals(50D, resultado);
	}

	@Test
	 void testCalculadorDescuento() {
		assertEquals(27D, carrito.calculadorDescuento(30D, 10D));
		
		
	}
	
	@Test
    void testAplicarDescuento() {
        Articulo articulo = new Articulo("Camiseta", 20.00);
        when(baseDatos.getArticuloId(2)).thenReturn(articulo);
        Double desc = carrito.aplicarDescuento(1, 10D);
        assertEquals(50D, desc);
        verify(baseDatos).getArticuloId(2);
    }
	
	
	@Test
	void insertar () {
		
		 Articulo articulo = new Articulo("Camiseta", 20.00);
		  
	        assertEquals(baseDatos.getArticuloId(3), 3);
	        assertFalse(carrito.getArticulos().isEmpty());  
	        carrito.insertar(3, articulo);
	        assertTrue(carrito.getArticulos().isEmpty());   
	        verify(baseDatos).insertarArticulo(articulo, 3);
		
	}
	
	/*CarritoCompraServiceTest:

		- Hacer un test del método insertar de CarritoCompraService en el que se deberá comprobar:
		    . El ID del nuevo artículo coincide con un valor en concreto
		    . Comprobar que la cesta tiene el objeto nuevo insertado
		    . Comprobar que se ha llamado al método insertar artículo de BaseDatos al menos una vez*/	

}
