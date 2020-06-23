package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.FormaPagPagamento;

@Repository
public interface FormaPagPagamentoRepository extends CrudRepository<FormaPagPagamento, Integer>{

}
