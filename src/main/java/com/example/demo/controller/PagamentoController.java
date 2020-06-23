package com.example.demo.controller;

import java.util.Optional;

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
	private PagamentoRepository pagamentoRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar(@RequestParam Double valor) {
		Pagamento pagamento = new Pagamento(0,  valor);
		pagamentoRepository.save(pagamento);
		return "Salvo";
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
	    return "Deletado";
	}
	@GetMapping(path="/editar")
	public @ResponseBody boolean editar(@RequestParam Integer id, @RequestParam Double valor) {
		Pagamento pagamento = pagamentoRepository.findById(id).get();
		pagamento.setValor(valor);
		pagamentoRepository.save(pagamento);
		return true;
	}
}
