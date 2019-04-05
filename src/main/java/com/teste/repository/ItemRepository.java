package com.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.model.Item;
public interface ItemRepository extends JpaRepository<Item, Long>{
	Optional<Item> findById(Long id);
}
