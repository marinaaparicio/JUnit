package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demoJUnit1.model.Articulo;
import com.example.demoJUnit1.service.carritoCompraServiceI;

@SpringBootApplication
public class JUnitApplication implements CommandLineRunner{

	
	@Autowired
	
	private carritoCompraServiceI carrito;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JUnitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Articulo> lista = carrito.getArticuloBBDD();
		
		for (Articulo articulo : lista) {
			System.out.println(articulo.getNombre());
		}
	
		
	}

}
