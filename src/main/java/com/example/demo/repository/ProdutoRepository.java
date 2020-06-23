package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
