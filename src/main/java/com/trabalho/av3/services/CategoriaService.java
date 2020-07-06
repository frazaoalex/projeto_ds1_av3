package com.trabalho.av3.services;

import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.av3.domain.Categoria;
import com.trabalho.av3.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) throws ObjectNotFoundException{
		
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElse(null);
	}

}
