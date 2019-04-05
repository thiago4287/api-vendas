package com.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.model.Produto;
import com.teste.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository prodRepo; 
	
	public List<Produto> listaProdutos(){
		return prodRepo.findAll();
	}
	
	public Produto adicionaProduto(Produto produto) {
		return prodRepo.save(produto);
	}
	
	public Optional<Produto> produtoPorId(Long id){
		return prodRepo.findById(id);
	}
	
	public Optional<Produto> deletaProduto(Long id) {
		Optional<Produto> prod =  prodRepo.findById(id);
		if(prod.isPresent()) {
			Produto produto = prod.get();
			prodRepo.delete(produto);
		}
		return prod;
	}
}
