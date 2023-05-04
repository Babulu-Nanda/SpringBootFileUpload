package com.example.demo;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MATMUserOnboardJpaRepository extends JpaRepository<MATMUserOnboard, Long> {

	
	MATMUserOnboard findFirstByUsername(String username);

	List<MATMUserOnboard> findByCreatedDateBetween(Date fromDate, Date toDate);
	
	MATMUserOnboard findByUsernameContaining(String username);
	
	
	
}
