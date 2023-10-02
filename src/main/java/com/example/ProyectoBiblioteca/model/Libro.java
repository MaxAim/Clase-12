package com.example.ProyectoBiblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long id;
    @Column
    private String title;
    @Column
    private Date publishDate;
    @Column
    private String genre;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    @JsonIgnore
    private Set<Autor> autores = new HashSet<>();
}