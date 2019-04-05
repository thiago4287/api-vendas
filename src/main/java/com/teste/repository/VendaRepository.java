package com.teste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.model.Cliente;
import com.teste.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	Optional<Venda> findById(Long id);
	
	List<Venda> findByCliente(Cliente cliente);
}
