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
import com.example.demo.models.Caixa;
import com.example.demo.repository.CaixaRepository;

@Controller
@RequestMapping(path="/caixa", method = RequestMethod.GET )
public class CaixaController {
	@Autowired
	private CaixaRepository caixaRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar(@RequestParam double valorAbertura,@RequestParam double valorFechamento, @RequestParam String data,int status) {
		Caixa caixa = new Caixa(0,valorAbertura,valorFechamento,data,status);
		
		caixaRepository.save(caixa);
		return "Cadastrar";
	}
	
	@PostMapping(value="/listarTodos") 
	public @ResponseBody  Iterable<Caixa> listarTodos() {
		return caixaRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam int id) {
	    return caixaRepository.existsById(id);
	    
	}
	@GetMapping(path="/busca")
	public @ResponseBody Optional<Caixa> buscar(@RequestParam int id) {
		Optional<Caixa> caixa = caixaRepository.findById(id);
		return caixa;
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam int id) {
		caixaRepository.deleteById(id);
	    return "Deletado";
	}
	
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam int id,@RequestParam double valorAbertura,@RequestParam double valorFechamento, @RequestParam String data) {
		Caixa caixa =  caixaRepository.findById(id).get();
		caixa.setData(data);
		caixa.setValorAbertura(valorAbertura);
		caixa.setValorFechamento(valorFechamento);
		caixaRepository.save(caixa);
	    return "Editado";
	}
	
	@PostMapping(value="/abrirCaixaFechar") 
	public @ResponseBody String abrirCaixaFechar (@RequestParam int id, int status) {
		Caixa caixa =  caixaRepository.findById(id).get();
		caixa.setStatus(status);
		caixaRepository.save(caixa);
	    return "Editado";
	}

	
}
