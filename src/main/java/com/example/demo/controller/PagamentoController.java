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


import com.example.demo.models.Pagamento;
import com.example.demo.repository.PagamentoRepository;

@Controller
@RequestMapping(path="/pagamento", method = RequestMethod.GET ) 
public class PagamentoController {
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar(Pagamento pagamento) {
		pagamentoRepository.save(pagamento);
		return "Cadastrado com sucesso";
	}
	
	@PostMapping(value="/listarTodos") 
	public @ResponseBody  Iterable<Pagamento> listarTodos() {
		return pagamentoRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return pagamentoRepository.existsById(id);
	}
	@GetMapping(path="/busca")
	public @ResponseBody Optional<Pagamento> buscar(@RequestParam Integer id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		return pagamento;
	}
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		pagamentoRepository.deleteById(id);
	    return "Deletado com sucesso";
	}
	@GetMapping(path="/editar")
	public @ResponseBody String editar (@RequestParam Integer id, Pagamento pagamento) {
		pagamentoRepository.findById(id)
				.map( (Function<? super Pagamento, ? extends Pagamento>) Record->{
					Record.setValor(pagamento.getValor());
					pagamentoRepository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
}
