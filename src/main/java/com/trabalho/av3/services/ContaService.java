package com.trabalho.av3.services;

import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.av3.domain.Conta;
import com.trabalho.av3.repositories.ContaRepository;


@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	public Conta find(Integer id) throws ObjectNotFoundException{
		
		Optional<Conta> obj = repository.findById(id);
		
		return obj.orElse(null);
	}

}
