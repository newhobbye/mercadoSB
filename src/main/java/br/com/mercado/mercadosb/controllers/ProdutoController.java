package br.com.mercado.mercadosb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.mercadosb.model.entities.Produto;
import br.com.mercado.mercadosb.model.entities.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public Iterable<Produto> getProduto(){
		return produtoRepository.findAll();
		
	}
	@PostMapping
	public @ResponseBody Produto novoProduto(@RequestParam String nome,
			@RequestParam Double precoVarejo,@RequestParam Double precoAtacado
			,@RequestParam Integer qtd,@RequestParam String categoria) {
		
		Produto produto = new Produto(nome, precoVarejo, precoAtacado, qtd, categoria);
		produtoRepository.save(produto);
		return produto;
		
	}
	@PutMapping
	public Produto alterarProduto(@RequestParam String nome, 
			@RequestParam Double precoAtacado,@RequestParam Double precoVarejo,
			@RequestParam Integer qtd,@RequestParam String categoria) {
		Produto produto = new Produto(nome, precoVarejo, precoAtacado, qtd, categoria);
		produtoRepository.save(produto);
		return produto;
		
	}

}
