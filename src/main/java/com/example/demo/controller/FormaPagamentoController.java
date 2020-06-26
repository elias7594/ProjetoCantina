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
import com.example.demo.models.FormaPagamento;

import com.example.demo.repository.FormaPagamentoRepository;

@Controller 
@RequestMapping(path="/formaPagamento", method = RequestMethod.GET ) 

public class FormaPagamentoController {
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar (@RequestParam String nome) {
		FormaPagamento forma = new FormaPagamento(0,nome);
		formaPagamentoRepository.save(forma);
		return "Cadastrado com sucesso";
	}
	
	@PostMapping(value="/listarTodos") 
	public @ResponseBody Iterable<FormaPagamento> listarTodos() {
		return formaPagamentoRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return formaPagamentoRepository.existsById(id);
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<FormaPagamento> buscar(@RequestParam Integer id) {
	    return formaPagamentoRepository.findById(id);
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		formaPagamentoRepository.deleteById(id);
	    return "Deletado";
	}
	
	@GetMapping(path="/editar")
	public @ResponseBody String editar (@RequestParam Integer id, FormaPagamento formaPagamento) {
		formaPagamentoRepository.findById(id)
				.map( (Function<? super FormaPagamento, ? extends FormaPagamento>) Record->{
					Record.setNome(formaPagamento.getNome());
					formaPagamentoRepository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
	
}
