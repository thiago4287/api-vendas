package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
