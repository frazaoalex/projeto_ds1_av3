package com.trabalho.av3.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.av3.domain.Fatura;
import com.trabalho.av3.services.FaturaService;

import javassist.tools.rmi.ObjectNotFoundException;
 
 

@RestController
@RequestMapping(value = "/fatura")
public class FaturaResource {

	@Autowired
	private FaturaService service;
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<Fatura> find(@PathVariable Integer id) throws ObjectNotFoundException {
		 
		Fatura obj = service.find(id);
	     return ResponseEntity.ok().body(obj);
	}
}
