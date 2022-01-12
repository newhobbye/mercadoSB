package br.com.mercado.mercadosb.model.entities.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.mercado.mercadosb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
	
	public Iterable<Produto> findByNomeContaining(String partNome);

}
