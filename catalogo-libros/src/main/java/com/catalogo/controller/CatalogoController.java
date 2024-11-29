package com.catalogo.controller;

import com.catalogo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class CatalogoController {

    @Autowired
    private LibroService libroService;

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String menu = """
                ** Catálogo de Libros **
                **************************************
                Elija la opción a través de su número:
                1- Buscar libro por título
                2- Listar libros registrados
                3- Listar libros por idioma
                9- Salir
                Opción: 
                """;

        while (opcion != 9) {
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    String resultadoBusqueda = libroService.buscarYRegistrarLibro(titulo);
                    System.out.println(resultadoBusqueda);
                    break;
                case 2:
                    libroService.listarLibrosRegistrados();
                    break;
                case 3:
                    System.out.print("Ingrese el idioma: ");
                    String idioma = scanner.nextLine();
                    libroService.listarLibrosPorIdioma(idioma);
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
