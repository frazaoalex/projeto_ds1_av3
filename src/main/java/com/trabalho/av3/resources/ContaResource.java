package com.trabalho.av3.resources;

import net.minidev.json.annotate.JsonIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.av3.domain.Conta;
import com.trabalho.av3.services.ContaService;

import javassist.tools.rmi.ObjectNotFoundException;
 
 

@RestController
@RequestMapping(value = "/conta")
public class ContaResource {

	@Autowired
	private ContaService  service;
	
	@JsonIgnore
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Conta> find(@PathVariable Integer id) throws ObjectNotFoundException {
		 
		Conta obj = service.find(id);
	     return ResponseEntity.ok().body(obj);
	}
}
