package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.dto.LibroDto;
import com.example.ProyectoBiblioteca.service.LibroI;
import jakarta.persistence.PostUpdate;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
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
    public ResponseEntity<String> saveLibro(@RequestBody LibroDto libroDto){
        String mensaje = libroService.saveLibro(libroDto);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLibro(@RequestBody LibroDto libroDto, @PathVariable Long id){
        String mensaje = libroService.updateLibro(id, libroDto);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("find")
    public ResponseEntity<LibroDto> findLibro(@RequestBody String title){
        LibroDto mensaje = libroService.findLibro(title);
        return new ResponseEntity<>(mensaje, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Long id){
        String mensaje = libroService.deleteLibro(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

}
