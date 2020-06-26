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
import com.example.demo.models.Categoria;
import com.example.demo.models.Produto;
import com.example.demo.models.UnidadeMedida;
import com.example.demo.repository.ProdutoRepository;

@Controller
@RequestMapping(path="/produto", method = RequestMethod.GET ) 
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar (@RequestParam Categoria categoria, @RequestParam UnidadeMedida unidadeMedida ,@RequestParam String nome, @RequestParam Double preco, @RequestParam String descricao ) {
		Produto produto = new Produto(0,  categoria, unidadeMedida,  nome,  preco,  descricao);
		produtoRepository.save(produto);
		return "Cadastrado";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<Produto> ListarTodos() {
	    return produtoRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return produtoRepository.existsById(id);
	}

	@GetMapping(path="/busca")
	public @ResponseBody Optional<Produto> buscar(@RequestParam Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto;
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		produtoRepository.deleteById(id);
	    return "Deletado";
	}
	
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam Integer id, Produto produto) {
		produtoRepository.findById(id)
				.map( (Function<? super Produto, ? extends Produto>) Record->{
					Record.setCategoria(produto.getCategoria());
					Record.setDescricao(produto.getDescricao());
					Record.setNome(produto.getNome());
					Record.setUnidadeMedida(produto.getUnidadeMedida());
					Record.setPreco(produto.getPreco());
					produtoRepository.save(Record);
					return Record;
				});
		
	    return "Salvo";
	}
}
