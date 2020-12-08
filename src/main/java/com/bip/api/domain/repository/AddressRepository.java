package com.bip.api.domain.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bip.api.domain.model.Address;



public interface AddressRepository extends MongoRepository<Address, String> {

	List<Address> findAll();
	//Optional<Address> findByfindBy_Id(String idAddress);
	Address findBy_id(String id);
	Address findByZip(String cpf);
	//Optional<Address> findBy_Id(String idAddress);
//	@Query("{ 'zip' : { $gt: ?0, $lt: ?1 } }")
 //   List<Address> findEmployeeByCpfBetween(int zipGT, int zipLT);
//	@Query("{ 'zip' : ?0 }")
   // List<Address> findByZipQuery(String zip);
	 
}
