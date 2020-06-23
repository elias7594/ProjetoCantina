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

import com.example.demo.models.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Controller
@RequestMapping(path="/categorias", method = RequestMethod.GET ) 
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriasRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar(@RequestParam String nome) {
		Categoria categoria = new Categoria(0,  nome);
		categoriasRepository.save(categoria);
		return "Salvo";
	}
	
	@PostMapping(value="/listarTodos") 
	public @ResponseBody  Iterable<Categoria> listarTodos() {
		return categoriasRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return categoriasRepository.existsById(id);
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<Categoria> buscar(@RequestParam Integer id) {
		Optional<Categoria> categoria = categoriasRepository.findById(id);
		return categoria;
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		categoriasRepository.deleteById(id);
	    return "Deletado";
	}
	
	@GetMapping(path="/editar")
	public @ResponseBody boolean editar(@RequestParam Integer id, @RequestParam String nome) {
		Categoria categoria = categoriasRepository.findById(id).get();
		categoria.setNome(nome);
		categoriasRepository.save(categoria);
		return true;
	}
}
