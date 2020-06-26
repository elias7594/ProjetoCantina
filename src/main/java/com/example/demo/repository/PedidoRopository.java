package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.Pedido;

public interface PedidoRopository extends CrudRepository<Pedido, Integer>{

}
