package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Caixa;
@Repository
public interface CaixaRepository extends CrudRepository<Caixa, Integer> {

	

}
