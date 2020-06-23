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


import com.example.demo.models.FormaPagPagamento;
import com.example.demo.models.FormaPagamento;
import com.example.demo.models.Pagamento;
import com.example.demo.repository.FormaPagPagamentoRepository;

@Controller 
@RequestMapping(path="/formaPagPagamento", method = RequestMethod.GET ) 
public class FormaPagPagamentoController {
	@Autowired
	FormaPagPagamentoRepository formaPagPagamentoRepository;
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String addNewUser (@RequestParam Pagamento idPagamento,@RequestParam  FormaPagamento idformaPagamento ) {
		FormaPagPagamento formaPagPagamento = new FormaPagPagamento(0,idformaPagamento,idPagamento);

		formaPagPagamentoRepository.save(formaPagPagamento);
		return "Salvo";
	}
	
	@PostMapping(value="/listarTodos") 
	public @ResponseBody  Iterable<FormaPagPagamento> listarTodos() {
		return formaPagPagamentoRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return formaPagPagamentoRepository.existsById(id);
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<FormaPagPagamento> buscar(@RequestParam Integer id) {
	    return formaPagPagamentoRepository.findById(id);
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		formaPagPagamentoRepository.deleteById(id);
	    return "Deletado";
	}
	
	@GetMapping(path="/editar")
	public @ResponseBody boolean editar(@RequestParam Integer id,@RequestParam Pagamento idPagamento,@RequestParam  FormaPagamento idformaPagamento) {
		FormaPagPagamento formaPagPagamento = formaPagPagamentoRepository.findById(id).get();
		formaPagPagamento.setFormaPagamento(idformaPagamento);
		formaPagPagamento.setPagamento(idPagamento);
		
		formaPagPagamentoRepository.save(formaPagPagamento);
		return true;
	}
	
	
}
