package com.teste.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.model.Cliente;
import com.teste.model.Venda;
import com.teste.repository.ProdutoRepository;
import com.teste.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	
	public List<Venda> vendas(){
		return vendaRepo.findAll();
	}
	
	public Optional<Venda> vendaPorId(Long id){
		return vendaRepo.findById(id);
	}
	
	public List<Venda> vendaPorCliente(Cliente cliente){
		return vendaRepo.findByCliente(cliente);
	}
	
	public Venda adicionarVenda(Venda venda) {
		venda.setCadastro(LocalDateTime.now());
		venda.getItems().forEach(i -> {
			i.setVenda(venda);
			i.setProduto(prodRepo.findById(i.getProduto().getId()).get());
		});
		
		BigDecimal totalItems = venda.getItems().stream()
				.map(i -> i.getProduto().getValor().multiply(new BigDecimal(i.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		venda.setValorTotal(totalItems.add(venda.getFrete()));
		
		return vendaRepo.save(venda);
	}
}
