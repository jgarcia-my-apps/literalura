package com.catalogo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del libro

    private String titulo; // Título del libro
    private String idioma; // Idioma del libro
    private Date fechaPublicacion; // Fecha de publicación del libro
    private Long autorId; // ID del autor asociado al libro (puede estar relacionado con una entidad Autor)

    // Constructor vacío
    public Libro() {
    }

    // Constructor con todos los parámetros
    public Libro(String titulo, String idioma, Date fechaPublicacion, Long autorId) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.fechaPublicacion = fechaPublicacion;
        this.autorId = autorId;
    }

    // Getter y Setter para 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y Setter para 'titulo'
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter y Setter para 'idioma'
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    // Getter y Setter para 'fechaPublicacion'
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    // Getter y Setter para 'autorId'
    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    // Métodos adicionales si es necesario

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", autorId=" + autorId +
                '}';
    }
}
