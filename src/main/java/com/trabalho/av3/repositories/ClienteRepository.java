package com.trabalho.av3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.av3.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
