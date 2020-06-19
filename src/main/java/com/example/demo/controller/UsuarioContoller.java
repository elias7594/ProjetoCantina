package com.example.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.models.Usuarios;
import com.example.demo.repository.UsuarioRepository;

@Controller 
@RequestMapping(path="/usuarios", method = RequestMethod.GET ) 
public class UsuarioContoller {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar (@RequestParam String nome, @RequestParam String email, @RequestParam String telefone, @RequestParam String cpf, @RequestParam Byte tipo, @RequestParam String senha) {
	    Usuarios n = new Usuarios( 0, telefone,  email,  nome,  tipo,  cpf,  senha,(double) 0);
	    usuarioRepository.save(n);
	    return "Saved";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<Usuarios> ListarTodos() {
	    // This returns a JSON or XML with the users
	    return usuarioRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return usuarioRepository.existsById(id);
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<Usuarios> buscar(@RequestParam Integer id) {
	    return usuarioRepository.findById(id);
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
	    usuarioRepository.deleteById(id);
	    return "Usuario deletado";
	}
	
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam Integer id,@RequestParam String nome, @RequestParam String email, @RequestParam String telephone, @RequestParam String cpf, @RequestParam Byte tipo, @RequestParam String senha) {
		Usuarios usuario =  usuarioRepository.findById(id).get();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setTelefone(telephone);
		usuario.setCpf(cpf);
		usuario.setTipo(tipo);
		usuario.setSenha(senha);
	    usuarioRepository.save(usuario);
	    return "Salvo";
	}
}
