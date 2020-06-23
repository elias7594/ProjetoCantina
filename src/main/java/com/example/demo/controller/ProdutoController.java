package com.example.demo.controller;

import java.util.Optional;
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
@RequestMapping(path="/produtos", method = RequestMethod.GET ) 
public class ProdutoController {
	
	private ProdutoRepository produtosRepository;
	
	@PostMapping(value="/cadastrar") 
	public @ResponseBody String cadastrar (@RequestParam Categoria categoria, @RequestParam UnidadeMedida unidadeMedida ,@RequestParam String nome, @RequestParam Double preco, @RequestParam String descricao ) {
		Produto produto = new Produto(0,  categoria, unidadeMedida,  nome,  preco,  descricao);
		produtosRepository.save(produto);
		return "Cadastrado";
	}
	
	@GetMapping(path="/listarTodos")
	public @ResponseBody Iterable<Produto> ListarTodos() {
	    return produtosRepository.findAll();
	}
	
	@GetMapping(path="/existePorId")
	public @ResponseBody boolean existePorId(@RequestParam Integer id) {
	    return produtosRepository.existsById(id);
	}

	@GetMapping(path="/busca")
	public @ResponseBody Optional<Produto> buscar(@RequestParam Integer id) {
		Optional<Produto> produto = produtosRepository.findById(id);
		return produto;
	}
	
	@GetMapping(path="/deletar")
	public @ResponseBody String deletar(@RequestParam Integer id) {
		produtosRepository.deleteById(id);
	    return "Deletado";
	}
	
	@PostMapping(value="/editar") 
	public @ResponseBody String editar (@RequestParam Integer id,@RequestParam String nome,Double preco, String descricao, Categoria categoria) {
		Produto produto =  produtosRepository.findById(id).get();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setDescricao(descricao);
		produto.setCategoria(categoria);
		produtosRepository.save(produto);
	    return "Editado";
	}
}
