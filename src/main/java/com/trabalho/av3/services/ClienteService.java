package com.trabalho.av3.services;

import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.av3.domain.Cliente;
import com.trabalho.av3.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente find(Integer id) throws ObjectNotFoundException{
		
		Optional<Cliente> obj = repository.findById(id);
		
		return obj.orElse(null);
	}

}
