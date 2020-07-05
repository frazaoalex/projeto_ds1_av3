package com.trabalho.av3.resources;

import java.util.ArrayList;
import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.av3.domain.Cliente;
import com.trabalho.av3.services.ClienteService;



@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Cliente> find(@PathVariable Integer id) throws ObjectNotFoundException {
		 
		 Cliente obj = service.find(id);
	     return ResponseEntity.ok().body(obj);
	}
	
}
