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
import com.example.demo.models.PedidoProduto;
import com.example.demo.repository.PedidoProdutoRepository;

@Controller
@RequestMapping(path="/pedidoProduto", method = RequestMethod.GET ) 
public class PedidoProdutoController {
	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository ;
	@GetMapping(path="/cadastrar")
	public @ResponseBody String cadastrar (PedidoProduto pedidoProduto ) {
		pedidoProdutoRepository.save(pedidoProduto);
		return "Cadastrado com sucesso";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<PedidoProduto> ListarTodos() {
	    return pedidoProdutoRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return pedidoProdutoRepository.existsById(id);
	}	
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<PedidoProduto> buscar(@RequestParam Integer id) {
		Optional<PedidoProduto> pedidoProduto = pedidoProdutoRepository.findById(id);
		return pedidoProduto;
	}
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		pedidoProdutoRepository.deleteById(id);
	    return "Deletado com sucesso";
	}
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam Integer id, PedidoProduto pedidoProduto) {
		pedidoProdutoRepository.findById(id)
				.map( (Function<? super PedidoProduto, ? extends PedidoProduto>) Record->{
					Record.setIdPedido(pedidoProduto.getIdPedido());
					Record.setIdProduto(pedidoProduto.getIdProduto());
					pedidoProdutoRepository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
}
