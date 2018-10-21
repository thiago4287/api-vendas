package com.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.model.Cliente;
import com.teste.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cliRepo; 
	
	public List<Cliente> listaClientes(){
		return cliRepo.findAll();
	}
	
	public Cliente adicionaCliente(Cliente cliente) {
		return cliRepo.save(cliente);
	}
}
