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
import com.example.demo.models.ItemCaixa;
import com.example.demo.repository.ItemCaixaRepository;

@Controller 
@RequestMapping(path="/itemCaixa", method = RequestMethod.GET ) 
public class ItemCaixaController {
	@Autowired
	private ItemCaixaRepository itemCaixaRepository;
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar (ItemCaixa itemCaixa ) {
		itemCaixaRepository.save(itemCaixa);
		return "Cadastrado com sucesso";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<ItemCaixa> ListarTodos() {
	    return itemCaixaRepository.findAll();
	}

	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam int id) {
	    return itemCaixaRepository.existsById(id);
	}
	@GetMapping(path="/busca")
	public @ResponseBody Optional<ItemCaixa> buscar(@RequestParam int id) {
		Optional<ItemCaixa> itemCaixa = itemCaixaRepository.findById(id);
		return itemCaixa;
	}
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam int id) {
		itemCaixaRepository.deleteById(id);
	    return "Deletado com sucesso";
	}
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam Integer id, ItemCaixa itemCaixa) {
		itemCaixaRepository.findById(id)
				.map( (Function<? super ItemCaixa, ? extends ItemCaixa>) Record->{
					Record.setDescricao(itemCaixa.getDescricao());
					Record.setIdCaixa(itemCaixa.getIdCaixa());
					Record.setIdPedido(itemCaixa.getIdPedido());
					Record.setTipoOper(itemCaixa.getTipoOper());
					Record.setValor(itemCaixa.getValor());
					itemCaixaRepository.save(Record);
					return Record;
				});
		
	    return "Editado com sucesso";
	}
}
