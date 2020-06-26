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
import com.example.demo.models.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Controller
@RequestMapping(path="/categoria", method = RequestMethod.GET ) 
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar(@RequestParam String nome) {
		Categoria categoria = new Categoria(0,  nome);
		categoriaRepository.save(categoria);
		return "Salvo";
	}
	
	@PostMapping(value="/listarTodos") 
	public @ResponseBody  Iterable<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return categoriaRepository.existsById(id);
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<Categoria> buscar(@RequestParam Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria;
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		categoriaRepository.deleteById(id);
	    return "Deletado";
	}
	
	@GetMapping(path="/editar")
	public @ResponseBody String editar (@RequestParam Integer id, Categoria categoria) {
		categoriaRepository.findById(id)
				.map( (Function<? super Categoria, ? extends Categoria>) Record->{
					Record.setNome(categoria.getNome());
					categoriaRepository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
}
