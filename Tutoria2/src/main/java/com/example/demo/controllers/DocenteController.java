package com.example.demo.controllers;


import com.example.demo.models.Docente;
import com.example.demo.services.DocenteServices;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteServices docenteService;

    @GetMapping
    public ResponseEntity<ArrayList<Docente>> getAll() {
        ArrayList<Docente> docentes = docenteService.getAll();
        if (docentes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(docentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> getById(@PathVariable int id) {
        Optional<Docente> docente = docenteService.findById(id); 
        if (docente.isPresent()) {
            return ResponseEntity.ok(docente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Docente> create(@Valid @RequestBody Docente docente) {
        Docente newDocente = docenteService.save(docente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDocente);
    }

    @PutMapping
    public ResponseEntity<Docente> update(@RequestBody Docente docente) {
        Docente updatedDocente = docenteService.update(docente);
        return ResponseEntity.ok(updatedDocente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        docenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
