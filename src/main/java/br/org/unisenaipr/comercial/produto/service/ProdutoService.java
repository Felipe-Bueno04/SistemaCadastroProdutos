package br.org.unisenaipr.comercial.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.org.unisenaipr.comercial.produto.entity.Produto;
import br.org.unisenaipr.comercial.produto.repositorio.ProdutoRepository;

@Service
public class ProdutoService  {
	
	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public void saveProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	public void updateProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void deleteProduto(Produto produto) {
		produtoRepository.delete(produto);
	}

	public Produto findId(long id) {
		
		Optional<Produto> objProduto = produtoRepository.findById(id);
		Produto produto = objProduto.get();
		
		return produto;
	}
}
