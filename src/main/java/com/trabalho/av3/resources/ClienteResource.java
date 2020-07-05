package com.trabalho.av3.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.av3.domain.Cliente;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@GetMapping
	public List<Cliente> listar(){
		Cliente cli1 = new Cliente(null, "Alex","(85)8526-2221","alextest@gmail.com");
		Cliente cli2 = new Cliente(null, "Diego B.","(85)9555-2221","diegotest@gmail.com");
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cli1);
		clientes.add(cli2);
		
		return clientes;
	}
}
