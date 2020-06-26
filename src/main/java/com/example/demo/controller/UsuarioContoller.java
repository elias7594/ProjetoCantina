package com.example.demo.controller;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Controller 
@RequestMapping(path="/usuarios", method = RequestMethod.GET ) 
public class UsuarioContoller {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar (@RequestParam String nome, @RequestParam String email, @RequestParam String telefone, @RequestParam String cpf, @RequestParam Byte tipo, @RequestParam String senha) {
	    Usuario usuario = new Usuario( 0, telefone,  email,  nome,  tipo,  cpf,  senha,(double) 0);
	    usuarioRepository.save(usuario);
	    return "Cadastrado com sucesso";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<Usuario> ListarTodos() {
	    // This returns a JSON or XML with the users
	    return usuarioRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return usuarioRepository.existsById(id);
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<Usuario> buscar(@RequestParam Integer id) {
	    return usuarioRepository.findById(id);
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
	    usuarioRepository.deleteById(id);
	    return "Usuario deletado";
	}
	
	@PostMapping(value="/editar") 
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
