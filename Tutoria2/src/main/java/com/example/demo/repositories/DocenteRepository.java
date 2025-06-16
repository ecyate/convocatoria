package com.example.demo.repositories;

import com.example.demo.models.Docente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Integer> {
	boolean existsByTipoDocAndNumeroIdentificacion(String tipoDoc, String numeroIdentificacion);

}
