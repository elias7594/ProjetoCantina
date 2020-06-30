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
import com.example.demo.models.Pedido;
import com.example.demo.repository.PedidoRopository;

@Controller
@RequestMapping(path="/pedido", method = RequestMethod.GET ) 
public class PedidoController {
	@Autowired
	private PedidoRopository pedidoRopository ;
	@GetMapping(path="/cadastrar")
	public @ResponseBody String cadastrar (Pedido produto) {
		pedidoRopository.save(produto);
		return "Cadastrado com sucesso";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<Pedido> ListarTodos() {
	    return pedidoRopository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return pedidoRopository.existsById(id);
	}	
	
	@GetMapping(path="/busca")
	public @ResponseBody Optional<Pedido> buscar(@RequestParam Integer id) {
		Optional<Pedido> Pedido = pedidoRopository.findById(id);
		return Pedido;
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		pedidoRopository.deleteById(id);
	    return "Deletado com sucesso";
	}
	
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam Integer id, Pedido pedido) {
		pedidoRopository.findById(id)
				.map( (Function<? super Pedido, ? extends Pedido>) Record->{
					Record.setIdPagamento(pedido.getIdPagamento());
					Record.setIdUsuario(pedido.getIdUsuario());
					Record.setStatus(pedido.getStatus());
					Record.setHora(pedido.getHora());
					Record.setData(pedido.getData());
					Record.setLugar(pedido.getLugar());
					pedidoRopository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
}
