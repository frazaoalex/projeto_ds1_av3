package com.trabalho.av3;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trabalho.av3.domain.Cliente;
import com.trabalho.av3.repositories.ClienteRepository;

@SpringBootApplication
public class ProjetosPringAv3Application implements CommandLineRunner{
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetosPringAv3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cli1 = new Cliente(null,"Alex Frazão","(85)8545-2633","alextest@gmail.com");
		Cliente cli2 = new Cliente(null,"Diego B","(85)9577-2633","diegob@gmail.com");
		Cliente cli3 = new Cliente(null,"Marcia Toledo","(85)9977-9999","marciatoledo@gmail.com");
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
	}

	
}
