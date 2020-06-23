package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UnidadeMedida;
@Repository
public interface UnidadeMedidaRepository extends  CrudRepository<UnidadeMedida, Integer> {

}
