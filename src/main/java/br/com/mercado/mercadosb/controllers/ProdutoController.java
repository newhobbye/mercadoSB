package br.com.mercado.mercadosb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Iterable<Produto> getProduto() {
		return produtoRepository.findAll();

	}

	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;

	}

	@PutMapping
	public @ResponseBody Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;

	}
	//Deleção por id
	@DeleteMapping("/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	
	//Consulta por nome
	@GetMapping("/nome/{partNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String partNome){
		return produtoRepository.findByNomeContaining(partNome);
		
		
	}
	//Consulta por pagina
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdPaginas}")
	public Iterable<Produto> obterProdutoPorPaginas(@PathVariable int numeroPagina,
			@PathVariable int qtdPaginas){
		if(qtdPaginas >= 4) qtdPaginas = 4;
		Pageable page = PageRequest.of(numeroPagina, qtdPaginas);
		return produtoRepository.findAll(page);
	}
	
	//Busca por id
	@GetMapping("/{id}")
	public java.util.Optional<Produto> buscaPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	
		
	

}
