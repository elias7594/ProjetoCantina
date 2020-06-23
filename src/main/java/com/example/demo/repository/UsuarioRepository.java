package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Usuario;
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
