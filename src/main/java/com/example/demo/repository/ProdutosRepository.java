package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Produtos;

public interface ProdutosRepository extends CrudRepository<Produtos, Integer>{

}
