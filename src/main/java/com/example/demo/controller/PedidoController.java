package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.models.Pagamento;
import com.example.demo.models.Pedido;
import com.example.demo.models.Usuario;
import com.example.demo.repository.PedidoRopository;

@Controller
@RequestMapping(path="/pedido", method = RequestMethod.GET ) 
public class PedidoController {
	private PedidoRopository pedidoRopository ;
	@GetMapping(path="/cadastrar")
	public @ResponseBody String cadastrar (@RequestParam  Usuario idUsuario,@RequestParam Pagamento idPagamento,@RequestParam int status,@RequestParam LocalDate hora,@RequestParam LocalDate data,
			@RequestParam Integer lugar) {
		Pedido produto = new Pedido(0,idUsuario,idPagamento,status,hora,data,lugar);
		pedidoRopository.save(produto);
		return "Cadastrado";
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
	    return "Deletado";
	}
	
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam Integer id,@RequestParam  Usuario idUsuario,@RequestParam Pagamento idPagamento,@RequestParam int status,@RequestParam LocalDate hora,@RequestParam LocalDate data,
			@RequestParam Integer lugar) {
		Pedido pedido =  pedidoRopository.findById(id).get();
		pedido.setData(data);
		pedido.setHora(hora);
		pedido.setIdPagamento(idPagamento);
		pedido.setIdUsuario(idUsuario);
		pedido.setLugar(lugar);
		pedido.setStatus(status);
	    return "Editado";
	}
}
