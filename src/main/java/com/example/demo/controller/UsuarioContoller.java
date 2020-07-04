package com.example.demo.controller;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;


@RestController
@RequestMapping(path="/usuarios" ) 
public class UsuarioContoller {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@CrossOrigin
	@PostMapping(value="/") 
	public @ResponseBody String cadastrar (@RequestBody Usuario usuario) {
	    usuarioRepository.save(usuario);
	    return "Cadastrado com sucesso";
	}
	@CrossOrigin
	@GetMapping(path="/")
	public @ResponseBody Iterable<Usuario> ListarTodos() {
	    return usuarioRepository.findAll();
	}
	

	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Usuario> buscar(@RequestParam Integer id) {
	    return usuarioRepository.findById(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public @ResponseBody String deletar(@PathVariable("id") Integer id) {
	    usuarioRepository.deleteById(id);
	    return "Usuario deletado";
	}
	
	@PostMapping(value="/{id}") 
	public @ResponseBody String editar (@RequestParam Integer id, Usuario user) {
		usuarioRepository.findById(id)
				.map( (Function<? super Usuario, ? extends Usuario>) Record->{
					Record.setCpf(user.getCpf());
					Record.setNome(user.getNome());
					Record.setEmail(user.getEmail());
					Record.setSenha(user.getSenha());
					Record.setTelefone(user.getTelefone());
					Record.setTipo(user.getTipo());
					usuarioRepository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
	
}
