package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Docente;
import com.example.demo.repositories.DocenteRepository;

@Service
public class DocenteServices {

    @Autowired
    private DocenteRepository docenteRepository;

    
    public ArrayList<Docente> getAll() {
        return (ArrayList<Docente>) docenteRepository.findAll();
    }
    public Docente update(Docente model) {
    	return existeDocente(model.getId())?docenteRepository.save(model):null;
    
    }
    
    public boolean deleteById(int id) {
        try {
            Optional<Docente> docente = docenteRepository.findById(id);
            if (docente.isPresent()) {
                docenteRepository.deleteById(id);
                return true;
            } else {
                return false; 
            }
        } catch (Exception ex) {
            return false;
        }
    }

private boolean existeDocente(int Id) {
	return docenteRepository.existsById(Id);
	
}
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    
    public Optional<Docente> findById(int id) {
        return docenteRepository.findById(id);
    }
}