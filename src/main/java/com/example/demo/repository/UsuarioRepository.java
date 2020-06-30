package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	boolean existsByEmail(String email);
	
}
