package com.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.Venda;
import com.teste.repository.VendaRepository;
import com.teste.service.VendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Api REST Vendas")
@CrossOrigin(origins="http://localhost:4200")
public class VendaController {

	
	@Autowired
	private VendaRepository vendaRepo;
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping("/vendas")
	@ApiOperation("Lista de vendas")
	public List<Venda> listaVendas(){
		return vendaService.vendas();
	}
	
	
	
	@PostMapping("/venda")
	@ApiOperation("Salva uma venda")
	public Venda salvaVenda(@RequestBody @Valid Venda venda) {
		return vendaService.adicionarVenda(venda);
	}
}
