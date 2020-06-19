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
import com.example.demo.models.FormasPagamento;
import com.example.demo.repository.FormasPagamentoRepository;

@Controller 
@RequestMapping(path="/formasPagamento", method = RequestMethod.GET ) 

public class FormasPagamentController {
	@Autowired
	private FormasPagamentoRepository formaPagamentoRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String addNewUser (@RequestParam String nome) {
		FormasPagamento forma = new FormasPagamento(0,nome);

		formaPagamentoRepository.save(forma);
		return "Salvo";
	}
	
	@PostMapping(value="/listarTodos") 
	public @ResponseBody  Iterable<FormasPagamento> listarTodos() {
		return formaPagamentoRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return formaPagamentoRepository.existsById(id);
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<FormasPagamento> buscar(@RequestParam Integer id) {
	    return formaPagamentoRepository.findById(id);
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		formaPagamentoRepository.deleteById(id);
	    return "Deletado";
	}
	
	@GetMapping(path="/editar")
	public @ResponseBody boolean editar(@RequestParam Integer id,@RequestParam String nome) {
		FormasPagamento forma = formaPagamentoRepository.findById(id).get();
		forma.setNome(nome);
		formaPagamentoRepository.save(forma);
		return true;
	}
	
}
