package com.catalogo.repository;

import com.catalogo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Método para buscar autores vivos en un año determinado
    @Query("SELECT a FROM Autor a WHERE YEAR(a.fechaNacimiento) <= :year AND (a.fechaDefuncion IS NULL OR YEAR(a.fechaDefuncion) >= :year)")
    List<Autor> findAutoresVivosEnAno(int year);

    // Método para buscar autores por nombre
    List<Autor> findByNombreContaining(String nombre);

    // Método para buscar un autor por nombre exacto
    Optional<Autor> findByNombre(String nombre);
}
