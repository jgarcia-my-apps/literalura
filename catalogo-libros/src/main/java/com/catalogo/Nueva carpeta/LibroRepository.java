package com.catalogo.repository;

import com.catalogo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Método para buscar libros por idioma
    List<Libro> findByIdioma(String idioma);

    // Método para buscar un libro por título, devolviendo un Optional<Libro> para manejar el caso de no encontrarlo
    Optional<Libro> findByTitulo(String titulo);
}
