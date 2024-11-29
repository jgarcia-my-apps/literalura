package com.catalogo;

import com.catalogo.controller.CatalogoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoLibrosApplication implements CommandLineRunner {

	@Autowired
	private CatalogoController catalogoController;

	public static void main(String[] args) {
		SpringApplication.run(CatalogoLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Lógica que se ejecutará al iniciar la aplicación
		System.out.println("Aplicación CatalogoLibros ha arrancado correctamente.");

		// Puedes llamar a algún método de CatalogoController si es necesario.
		// Ejemplo:
		// catalogoController.iniciarAplicacion();
	}
}
