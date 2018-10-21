package com.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.Produto;
import com.teste.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Api REST Vendas")
@CrossOrigin(origins="http://localhost:4200")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@GetMapping("/produtos")
	@ApiOperation("Lista  produtos")
	public List<Produto> listaProdutos(){
		return prodRepo.findAll();
	}
	
	@PostMapping("/produto")
	@ApiOperation("Salva um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return prodRepo.save(produto);
	}
}
