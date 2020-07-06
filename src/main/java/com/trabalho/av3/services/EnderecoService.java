package com.trabalho.av3.services;

import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.av3.domain.Endereco;
import com.trabalho.av3.repositories.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public Endereco find(Integer id) throws ObjectNotFoundException{
		
		Optional<Endereco> obj = repository.findById(id);
		
		return obj.orElse(null);
	}

}
