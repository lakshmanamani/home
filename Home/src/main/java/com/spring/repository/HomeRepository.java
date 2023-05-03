package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Home;

public interface HomeRepository extends JpaRepository<Home, Integer> {
     
	Home findByuname(String unmae);
}
