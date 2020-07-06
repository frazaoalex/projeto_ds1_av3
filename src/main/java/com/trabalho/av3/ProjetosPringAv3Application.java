package com.trabalho.av3;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trabalho.av3.domain.Cartao;
import com.trabalho.av3.domain.Categoria;
import com.trabalho.av3.domain.Cliente;
import com.trabalho.av3.domain.Conta;
import com.trabalho.av3.domain.Endereco;
import com.trabalho.av3.domain.Fatura;
import com.trabalho.av3.repositories.CartaoRepository;
import com.trabalho.av3.repositories.CategoriaRepository;
import com.trabalho.av3.repositories.ClienteRepository;
import com.trabalho.av3.repositories.ContaRepository;
import com.trabalho.av3.repositories.EnderecoRepository;
import com.trabalho.av3.repositories.FaturaRepository;

@SpringBootApplication
public class ProjetosPringAv3Application implements CommandLineRunner{
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ContaRepository contaRepository;
	@Autowired
	FaturaRepository faturaRepository;
	@Autowired
	CartaoRepository cartaoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetosPringAv3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* Inserindo dados do Cliente e Endereço */
		Cliente cli1 = new Cliente(null,"Alex Frazão","(85)8545-2633","alextest@gmail.com");
		Cliente cli2 = new Cliente(null,"Diego B","(85)9577-2633","diegob@gmail.com");
		Cliente cli3 = new Cliente(null,"Marcia Toledo","(85)9977-9999","marciatoledo@gmail.com");
		
		Endereco end1 = new Endereco(null,"Rua A","Jerreissati 1","195","Maracanau",cli1);
		Endereco end2 = new Endereco(null,"Rua B","Vila Velha","1050","Fortaleza",cli2);
		Endereco end3 = new Endereco(null,"Rua C","Barroso","1905","Fortaleza",cli3);
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));
		
		Categoria cat2 = new Categoria(null,"Bronze");
		Categoria cat1 = new Categoria(null,"Silver");
		Categoria cat3 = new Categoria(null,"Gold");
		
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/mm/yyyy");
		
		Cartao card1 = new Cartao(null,65478915,dataFormatada.parse("01/01/2024"),cli1.getNome(),4984,"989812");
		Cartao card2 = new Cartao(null,75998515,dataFormatada.parse("01/01/2022"),cli2.getNome(),1284,"985500");
		Cartao card3 = new Cartao(null,35477505,dataFormatada.parse("01/01/2023"),cli3.getNome(),3584,"120598");
		
		Conta cont1 = new Conta(null,35598,50.00,true,cat1,card1);
		Conta cont2 = new Conta(null,35598,550.00,true,cat2,card2);
		Conta cont3 = new Conta(null,35598,3550.00,true,cat3,card3);
		
		card1.getContas().addAll(Arrays.asList(cont1));
	 	card2.getContas().addAll(Arrays.asList(cont2));
	 	card3.getContas().addAll(Arrays.asList(cont3));
	 	
	 	categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	 	
	 	cont1.setCliente(cli1);
	 	cont2.setCliente(cli2);  
	 	cont3.setCliente(cli3);
	  
	   	cli1.getEnderecos().addAll(Arrays.asList(end1));
	   	cli2.getEnderecos().addAll(Arrays.asList(end2));
	   	cli3.getEnderecos().addAll(Arrays.asList(end3));
	   	
		
	   	Fatura fat1Cl1 = new Fatura(null,dataFormatada.parse("01/05/2020"),dataFormatada.parse("15/05/2020"),0.15,true,175.15,card1);
	   	Fatura fat2Cl1 = new Fatura(null,dataFormatada.parse("01/03/2020"),dataFormatada.parse("15/03/2020"),0.05,true,575.15,card1);
	   	Fatura fat3Cl1 = new Fatura(null,dataFormatada.parse("01/04/2020"),dataFormatada.parse("15/04/2020"),0.25,true,1075.15,card1);
	   	
	   	Fatura fat1Cl2 = new Fatura(null,dataFormatada.parse("01/05/2020"),dataFormatada.parse("15/05/2020"),0.15,true,175.15,card2);
	   	Fatura fat2Cl2 = new Fatura(null,dataFormatada.parse("01/03/2020"),dataFormatada.parse("15/03/2020"),0.05,true,575.15,card2);
	   	Fatura fat3Cl2 = new Fatura(null,dataFormatada.parse("01/04/2020"),dataFormatada.parse("15/04/2020"),0.25,true,1075.15,card2);
	   	
	   	Fatura fat1Cl3 = new Fatura(null,dataFormatada.parse("01/05/2020"),dataFormatada.parse("15/05/2020"),0.15,true,175.15,card3);
	   	Fatura fat2Cl3 = new Fatura(null,dataFormatada.parse("01/03/2020"),dataFormatada.parse("15/03/2020"),0.05,true,575.15,card3);
	   	Fatura fat3Cl3 = new Fatura(null,dataFormatada.parse("01/04/2020"),dataFormatada.parse("15/04/2020"),0.25,true,1075.15,card3);
	   	
	   	card1.getFaturas().addAll(Arrays.asList(fat1Cl1,fat2Cl1,fat3Cl1));
	   	card1.getFaturas().addAll(Arrays.asList(fat1Cl2,fat2Cl2,fat3Cl2));
	   	card1.getFaturas().addAll(Arrays.asList(fat1Cl3,fat2Cl3,fat3Cl3));
	   	
	   	cartaoRepository.saveAll(Arrays.asList(card1,card2,card3));
	   	faturaRepository.saveAll(Arrays.asList(fat1Cl1,fat2Cl1,fat3Cl1,fat1Cl2,fat2Cl2,fat3Cl2,fat1Cl3,fat2Cl3,fat3Cl3));
	   	contaRepository.saveAll(Arrays.asList(cont1,cont2,cont3));
	}

	
}
