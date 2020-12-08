package com.bip.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bip.api.domain.model.Address;
import com.bip.api.domain.service.AddressService;
/* Teste de stress e performace com Apache Ab
   ab -n 10000 -c 100 http://localhost:8080/api/companymongodb/
*/
import com.bip.api.domain.service.UfCacheService;

@RestController
@EnableCaching
@RequestMapping("/api/employee")
public class AddressController {
	
	private static final Logger log = LoggerFactory.getLogger(AddressController.class);
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private UfCacheService ufCacheService;
	
	@Autowired
	private AddressService adressService;
	
	
	@GetMapping(value = "/zip/{strZip:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Address> findByZip(@PathVariable ("strZip") String strZip) {
		System.out.println("--------------------------------");
		Address address = adressService.findByZip(strZip);
		System.out.println("Informações do CEP "+ address);
		log.info("Informações da empresa "+ address);
		
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(address == null)) {
		   return ResponseEntity.ok(address);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	@GetMapping(value = "/{strId:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Address> findByCpf(@PathVariable ("strId") String strId) {
		System.out.println("--------------------------------");
		Address address = adressService.findBy_id(strId);
		System.out.println("Informações da empresa "+ address);
		log.info("Informações da empresa "+ address);
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(address == null)) {
		   return ResponseEntity.ok(address);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	@PostMapping(value = "/", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Address> register(@Valid @RequestBody Address address) {
		if ((address == null )) {
			return ResponseEntity.notFound().build();
		}
		Address addressDB = adressService.insert(address);
		
		return ResponseEntity.ok(addressDB);
	}
	
	@PutMapping(value = "/{strZip}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Address> change(@Valid @PathVariable ("strZip") String strZip, @RequestBody Address address){
		
		if ((address == null )) {
			return ResponseEntity.notFound().build();
		}
	
		Address addressDB = adressService.upDate(address);
		
		
		return ResponseEntity.ok(addressDB);
	}
	
	@DeleteMapping(value = "/{strZip}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Void> deletar(@PathVariable String strZip){
		Address address = adressService.findByZip(strZip);
		
		if ((address == null)) {
			return ResponseEntity.notFound().build();
			
		}
		adressService.deletar(address);
	
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/v4/{strZip}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Address> buscarV1(@PathVariable ("strZip") String strZip) {
		Address addressDB = new Address();
		//addressRepository.findAll().forEach(System.out::println);
		System.out.println();
	
		System.out.println("--------------------------------");
		//userRepository.findByNumberAddressBetween(18, 90).forEach(System.out::println);
		System.out.println("--------------------------------");
		
		System.out.println("Executando serviço pela primeira vez: ");
		System.out.println(this.ufCacheService.lisUfCache());
		
		System.out.println("Executando serviço pela segunda vez, deve obter dados do cache: ");
		System.out.println(this.ufCacheService.lisUfCache());
	    
	    return ResponseEntity.ok(addressDB);	
	}
	
	

}
