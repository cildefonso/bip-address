package com.bip.api.domain.service;

import java.util.List;
//import java.util.Optional;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.bip.api.domain.model.Address;

@Service
public interface AddressService {	
	
	Address insert(Address address);
	Address upDate(Address address);
	Address list(Address address);
	void deletar(Address address);
	List<Address> findAll();
	long count();
	//Optional<Address> findByfindBy_Id(String idAddress);
	Address findBy_id(String id);
	Address findByZip(String cpf);
	//Optional<Address> findBy_Id(String idAddress);
//	@Query("{ 'zip' : { $gt: ?0, $lt: ?1 } }")
//    List<Address> findEmployeeByCpfBetween(int zipGT, int zipLT);
//	@Query("{ 'zip' : ?0 }")
//    List<Address> findByZipQuery(String zip);
	
	
}