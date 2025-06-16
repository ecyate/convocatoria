package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Docente;
import com.example.demo.repositories.DocenteRepository;
import com.example.demo.exceptions.RecursoNoEncontradoException;

@Service
public class DocenteServices {

    @Autowired
    private DocenteRepository docenteRepository;

    // Obtener todos los docentes
    public ArrayList<Docente> getAll() {
        return (ArrayList<Docente>) docenteRepository.findAll();
    }

    // Guardar un docente con validación de tipoDoc + númeroIdentificación
    public Docente save(Docente docente) {
        boolean existe = docenteRepository.existsByTipoDocAndNumeroIdentificacion(
                docente.getTipoDoc(), docente.getNumeroIdentificacion());

        if (existe) {
            throw new IllegalArgumentException("Ya existe un docente con el mismo tipo y número de documento.");
        }

        return docenteRepository.save(docente);
    }

    // Actualizar docente con verificación previa
    public Docente update(Docente model) {
        if (!docenteRepository.existsById(model.getId())) {
            throw new RecursoNoEncontradoException("No se encontró el docente con ID: " + model.getId());
        }
        return docenteRepository.save(model);
    }

    // Eliminar docente con verificación previa
    public boolean deleteById(int id) {
        if (!docenteRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se puede eliminar. No existe docente con ID: " + id);
        }
        docenteRepository.deleteById(id);
        return true;
    }

    // Buscar por ID
    public Optional<Docente> findById(int id) {
        return docenteRepository.findById(id);
    }
}
