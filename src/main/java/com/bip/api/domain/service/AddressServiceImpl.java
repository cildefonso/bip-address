package com.bip.api.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.bip.api.domain.model.Address;
import com.bip.api.domain.repository.AddressRepository;
import com.bip.domain.exception.NegocioException;

@Service
public class AddressServiceImpl implements AddressService{
	
	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);
	@Autowired
	private AddressRepository addressRepository;
	private Address userExistente;
	
	@Autowired
	MongoTemplate mongoTemplate;

	
	public Address insert(Address address) {
		
		 userExistente = addressRepository.findByZip(address.getZip());
		
		if (userExistente != null && !userExistente.equals(address)) {
			throw new NegocioException("Este empregado encontra-se cadastrada. ");
		}
	
		return addressRepository.save(address);
	}
	
	public Address upDate(Address address) {
		userExistente = addressRepository.findByZip(address.getZip());
		
		if (userExistente == null && userExistente.equals(address)) {
			throw new NegocioException("Este empregado não está cadastrada. ");
		}
	
		return addressRepository.save(address);
	}

	public Address list(Address address) {
		
		Address objaddress = addressRepository.findByZip(address.getZip());
		
		if (objaddress == null || "".equals(objaddress.toString())) {
			throw new NegocioException("Este espregado não foi encontrado. ");
		}
	
		return objaddress;
	}
	
   public void deletar(Address address) {
	   addressRepository.delete(address);
   }
   

   public long count() {
       return addressRepository.count();
   }
   
   public List<Address> findAll() {
	   log.info("Buscar todos os endereços. ");
	      return addressRepository.findAll();
	   }

//   public Optional<Address> findByfindBy_Id(String idAddress) {
//	   log.info("Buscar os endereços pelo ID. ", idAddress);
//	      return addressRepository.findByfindBy_Id(idAddress);
//   }

   public Address findBy_id(String id) {
	   log.info("Buscar o endereço pelo ID. ", id);
	   return addressRepository.findBy_id(id);
   }

   public Address findByZip(String cpf) {
	   log.info("Buscar o endereço pelo ID. ", cpf);
	   return addressRepository.findByZip(cpf);
   }

//   public List<Address> findEmployeeByCpfBetween(int zipGT, int zipLT) {
//	   log.info("Buscar faixa de endereço. ");
//	   return addressRepository.findEmployeeByCpfBetween(zipGT,zipLT);
//   }
   
//   public List<Address> findByZipQuery(String zip) {
//	   log.info("Buscar endereço por nome. ");
//	   return addressRepository.findByZipQuery(zip);
//   }

//	@Override
//	public Optional<Address> findBy_Id(String idAddress) {
//		   log.info("Buscar endereço por nome. ", idAddress);
//		   return addressRepository.findBy_Id(idAddress);
//	}

}

