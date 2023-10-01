package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.dto.AutorDto;
import com.example.ProyectoBiblioteca.service.AutorI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autores")
public class AutorController {
    private final AutorI autorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<AutorDto>> findAllAutores(){
        List<AutorDto> lista = autorService.findAllAutors();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveAutors(@RequestBody AutorDto autorDto){
        String mensaje = autorService.saveAutor(autorDto);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
}