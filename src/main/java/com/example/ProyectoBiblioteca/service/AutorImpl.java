package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.dto.AutorDto;
import com.example.ProyectoBiblioteca.mapper.MapperAutor;
import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorImpl implements AutorI {
    private final AutorRepository autorRepository;

    @Override
    public List<AutorDto> findAllAutors() {
        return autorRepository.findAll().stream()
                .map(MapperAutor::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String saveAutor(AutorDto autorDto) {
        Autor autorEntity = MapperAutor.toEntity(autorDto);
        autorRepository.save(autorEntity);
        return "Autor guardado exitosamente";
    }

    @Override
    public AutorDto findAutor(String name) {
        Autor autorEntity = autorRepository.findByName(name);
        return MapperAutor.toDto(autorEntity);
    }

    @Override
    public String updateAutor(Long id, AutorDto autorDto) {
        Autor autor = autorRepository.findById(id).orElseThrow();
        autor.setName(autorDto.getName());
        autor.setSurname(autorDto.getSurname());
        autor.setLibros(autorDto.getLibros());
        autorRepository.save(autor);

        return "Autor: " + autor.getName() + " actualizado exitosamente";
    }

    @Override
    public String deleteAutor(Long id) {
        autorRepository.deleteById(id);

        return "El autor fue eliminado exitosamente";
    }
}