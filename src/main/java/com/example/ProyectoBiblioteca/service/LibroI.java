package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.dto.LibroDto;
import com.example.ProyectoBiblioteca.model.Libro;

import java.util.List;

public interface LibroI {

    List<LibroDto> findAllLibros();
    String saveLibro(LibroDto libroDto);
    LibroDto findLibro(String title);
    String updateLibro(Long id, LibroDto libroDto);
    String deleteLibro(Long id);

}
