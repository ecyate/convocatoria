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
        ArrayList<Docente> docente = docenteService.getAll();
        if (docente.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(docente);
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
@PutMapping 

public ResponseEntity<Docente> update(@RequestBody Docente docente) {
    Docente updateddocente = docenteService.update(docente);
    return ResponseEntity.ok(updateddocente);
}
@DeleteMapping("/{Id}")
public ResponseEntity<Void>delete(@PathVariable int Id){
	docenteService.deleteById(Id);
	return ResponseEntity.noContent().build();
}



@PostMapping
    public ResponseEntity<?> createDocente(@Valid @RequestBody Docente docente) {
        try {
            Docente savedDocente = docenteService.save(docente);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDocente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    public ResponseEntity<Docente> save(@RequestBody Docente docente) {
        if (docente.getNombres() == null || docente.getApellidos() == null) {
            return ResponseEntity.badRequest().build(); 
        }
        Docente newDocente = docenteService.save(docente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDocente);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error: " + e.getMessage());
    }
}