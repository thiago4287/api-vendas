package com.teste.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Cliente> clientePorId(Long id){
		return cliRepo.findById(id);
	}
	
	public Optional<Cliente> deletaCliente(Long id) {
		Optional<Cliente> cli =  cliRepo.findById(id);
		if(cli.isPresent()) {
			Cliente cliente = cli.get();
			cliRepo.delete(cliente);
		}
		return cli;
	}
}
