package com.catalogo.service;

import com.catalogo.model.Autor;
import com.catalogo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // 1. Obtener todos los autores
    public List<Autor> obtenerTodosLosAutores() {
        return autorRepository.findAll();
    }

    // 2. Obtener un autor por su ID
    public Optional<Autor> obtenerAutorPorId(Long id) {
        return autorRepository.findById(id);
    }

    // 3. Agregar un nuevo autor
    public Autor agregarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    // 4. Actualizar un autor existente
    public Autor actualizarAutor(Long id, Autor autorActualizado) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isPresent()) {
            autorActualizado.setId(id);  // Asegurarse de que el autor tiene el ID correcto
            return autorRepository.save(autorActualizado);
        }
        return null;  // Si no se encuentra el autor, se retorna null o se puede lanzar una excepción
    }

    // 5. Eliminar un autor por su ID
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    // 6. Buscar autores vivos en un determinado año
    public List<Autor> listarAutoresVivosEnAno(int year) {
        return autorRepository.findAutoresVivosEnAno(year);
    }

    // 7. Buscar autores por nombre
    public List<Autor> buscarAutoresPorNombre(String nombre) {
        return autorRepository.findByNombreContaining(nombre);
    }

    // 8. Verificar si un autor existe
    public boolean autorExiste(Long id) {
        return autorRepository.existsById(id);
    }

    // 9. Obtener un autor por su nombre (opcional)
    public Optional<Autor> obtenerAutorPorNombre(String nombre) {
        return autorRepository.findByNombre(nombre);
    }
}
