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
    public ResponseEntity<String> saveAutor(@RequestBody AutorDto autorDto){
        String mensaje = autorService.saveAutor(autorDto);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAutor(@RequestBody AutorDto autorDto, @PathVariable Long id){
        String mensaje = autorService.updateAutor(id, autorDto);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("find")
    public ResponseEntity<AutorDto> findAutor(@RequestBody String name){
        AutorDto mensaje = autorService.findAutor(name);
        return new ResponseEntity<>(mensaje, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAutor(@PathVariable Long id){
        String mensaje = autorService.deleteAutor(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}