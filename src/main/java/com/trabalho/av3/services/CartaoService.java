package com.trabalho.av3.services;

import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.av3.domain.Cartao;
import com.trabalho.av3.repositories.CartaoRepository;


@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;
	
	public Cartao find(Integer id) throws ObjectNotFoundException{
		
		Optional<Cartao> obj = repository.findById(id);
		
		return obj.orElse(null);
	}

}
