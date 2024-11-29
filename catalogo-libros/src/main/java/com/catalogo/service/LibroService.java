package com.catalogo.service;

import com.catalogo.model.Libro;
import com.catalogo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public String buscarYRegistrarLibro(String titulo) {
        // Aquí, findByTitulo devuelve un Optional<Libro>
        Optional<Libro> libroOpt = libroRepository.findByTitulo(titulo);

        // Si el libro se encuentra, se muestra el título
        if (libroOpt.isPresent()) {
            return "Libro encontrado: " + libroOpt.get().getTitulo();
        } else {
            // Si no se encuentra el libro, podemos registrar un nuevo libro
            // Aquí podrías agregar el proceso de registrar el libro si lo deseas
            return "Libro no encontrado. Puede registrar un nuevo libro.";
        }
    }

    // Método para listar todos los libros registrados
    public void listarLibrosRegistrados() {
        libroRepository.findAll().forEach(libro -> System.out.println(libro.getTitulo()));
    }

    // Método para listar los libros por idioma
    public void listarLibrosPorIdioma(String idioma) {
        libroRepository.findByIdioma(idioma).forEach(libro -> System.out.println(libro.getTitulo()));
    }
}
