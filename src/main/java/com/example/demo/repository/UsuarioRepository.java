package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Usuarios;
public interface UsuarioRepository extends CrudRepository<Usuarios, Integer> {

}
