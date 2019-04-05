package com.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.Cliente;
import com.teste.model.Venda;
import com.teste.repository.ClienteRepository;
import com.teste.repository.VendaRepository;
import com.teste.service.VendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Api REST Vendas")
@CrossOrigin(origins="*")
public class VendaController {

	
	@Autowired
	private VendaRepository vendaRepo;
	
	@Autowired
	private ClienteRepository cliRepo;
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping("/vendas")
	@ApiOperation("Lista de vendas")
	public List<Venda> listaVendas(){
		return vendaService.vendas();
	}
	
	@GetMapping("/vendas/{id}")
	@ApiOperation("Venda por id")
	public Venda getVendaId(Long id) {
		return vendaService.vendaPorId(id).get();
	}
	
	@GetMapping("/vendas/cliente/{id}")
	@ApiOperation("Vendas por cliente")
	public List<Venda> vendasCliente(@PathVariable Long id){
		Cliente cliente = cliRepo.findById(id).get();
		List<Venda> lista =  vendaService.vendaPorCliente(cliente);
		return lista;
	}
	
	
	
	@PostMapping("/venda")
	@ApiOperation("Salva uma venda")
	public Venda salvaVenda(@RequestBody @Valid Venda venda) {
		return vendaService.adicionarVenda(venda);
	}
}
