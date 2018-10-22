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

import com.teste.model.Cliente;
import com.teste.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Api REST Vendas")
@CrossOrigin(origins="*")
public class ClienteController {
	
	@Autowired
	private ClienteService cliService;
	
	@GetMapping("/clientes")
	@ApiOperation("Lista os clientes")
	public List<Cliente> listaClientes(){
		return cliService.listaClientes();
	}
	
	@PostMapping("/cliente")
	@ApiOperation("Salva um cliente")
	public String salvaCliente(@RequestBody @Valid Cliente cliente) {
		Cliente cli = cliService.adicionaCliente(cliente);
		if(cli != null) {
			return "Cliente Salvo com sucesso";
		}else {
			return "Erro ao salvar cliente";
		}
	}
}
