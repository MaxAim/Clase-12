package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.dto.LibroDto;
import com.example.ProyectoBiblioteca.service.LibroI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {
    private final LibroI libroService;

    @GetMapping("/findAll")
    public ResponseEntity<List<LibroDto>> findAllLibros(){
        List<LibroDto> lista = libroService.findAllLibros();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveLibros(@RequestBody LibroDto libroDto){
        String mensaje = libroService.saveLibro(libroDto);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
}
