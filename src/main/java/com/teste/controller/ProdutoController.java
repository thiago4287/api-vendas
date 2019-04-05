package com.teste.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.Cliente;
import com.teste.model.Produto;
import com.teste.repository.ProdutoRepository;
import com.teste.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Api REST Vendas")
@CrossOrigin(origins="*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService prodService;
	
	@GetMapping("/produtos")
	@ApiOperation("Lista  produtos")
	public List<Produto> listaProdutos(){
		return prodService.listaProdutos();
	}
	
	@PostMapping("/produto")
	@ApiOperation("Salva um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return prodService.adicionaProduto(produto);
	}
	
	  @GetMapping("/produtos/{id}") 
	  @ApiOperation("Recupera produto por id") 
	  public Optional<Produto> getProduto(@PathVariable Long id) { 
	  return prodService.deletaProduto(id);
			  
	  }
	
	@DeleteMapping("/produtos/{id}")
	@ApiOperation("Deleta um produto")
	public Optional<Produto> deletaProduto(@PathVariable Long id){
		return prodService.deletaProduto(id);
	}
	
	@PutMapping("/produto/{id}")
	@ApiOperation("Atualiza um produto")
	public String atualizaProduto(@PathVariable Long id) {
		Optional<Produto> prod = prodService.produtoPorId(id);
		if(prod.isPresent()) {
			return "Cliente atualizado com sucesso";
		}else {
			return "Erro ao salvar cliente";
		}
	}
}
