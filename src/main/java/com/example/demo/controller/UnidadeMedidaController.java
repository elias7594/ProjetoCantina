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
import com.example.demo.models.UnidadeMedida;
import com.example.demo.repository.UnidadeMedidaRepository;

@Controller
@RequestMapping(path="/unidadeMedida", method = RequestMethod.GET ) 
public class UnidadeMedidaController<U> {
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar (@RequestParam String sigla ) {
		UnidadeMedida unidadeMedida = new UnidadeMedida(0,  sigla);
		unidadeMedidaRepository.save(unidadeMedida);
		return "Cadastrado";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<UnidadeMedida> ListarTodos() {
	    return unidadeMedidaRepository.findAll();
	}
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return unidadeMedidaRepository.existsById(id);
	}
	@GetMapping(path="/busca")
	public @ResponseBody Optional<UnidadeMedida> buscar(@RequestParam Integer id) {
		Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findById(id);
		return unidadeMedida;
	}
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		unidadeMedidaRepository.deleteById(id);
		return "Unidade medida deletado";
	}
	@GetMapping(path="/editar")
	public @ResponseBody String editar (@RequestParam Integer id, UnidadeMedida unidadeMedida) {
		unidadeMedidaRepository.findById(id)
				.map( (Function<? super UnidadeMedida, ? extends UnidadeMedida>) Record->{
					Record.setSigla(unidadeMedida.getSigla());
					unidadeMedidaRepository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
}
