package com.example.ProyectoBiblioteca.mapper;

import com.example.ProyectoBiblioteca.dto.AutorDto;
import com.example.ProyectoBiblioteca.model.Autor;

public class MapperAutor {
    public static AutorDto toDto(Autor autor){
        AutorDto autorDto = new AutorDto();

        autorDto.setName(autor.getName());
        autorDto.setSurname(autor.getSurname());
        autorDto.setLibros(autor.getLibros());

        return autorDto;
    }
    public static Autor toEntity(AutorDto autorDto){
        Autor autor = new Autor();

        autor.setName(autor.getName());
        autor.setSurname(autor.getSurname());
        autor.setLibros(autorDto.getLibros());

        return autor;
    }
}