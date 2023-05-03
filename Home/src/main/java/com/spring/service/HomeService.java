package com.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.spring.model.Home;
import com.spring.repository.HomeRepository;

@Service
public class HomeService {
     @Autowired
     private HomeRepository repository;
     public String checkLogin(String uname, String pwd) {
    	 Home user = repository.findByuname(uname);
    	 if (user == null) {
    		 return " no user found" ;
    	 }
    	 else
    	 {
    		 if(user.getPwd().equals(pwd)) {
    			 return "Login Successfull";
    		 }
    		 else {
    			 return "Login failed";
    		 }
    	 }
     }
     public Home addUser(Home home) {
    	 return repository.save(home);
     }
     public List<Home> getUser(){
    	 return repository.findAll();
     }
     
     public List<Home> paginationAndSorting(int pageNumber, int pageSize, String column_name){
			Page<Home> i = repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(column_name).descending()));
			return i.getContent();
		}
		public List<Home> sortDescending(String field){	
			return repository.findAll(Sort.by(Direction.DESC, field));
		}
		
		public List<Home> sortAscending(String field){	
			return repository.findAll(Sort.by(Direction.ASC, field));
		}
		public List<Home> pagination(int pageNumber, int pageSize){
			Page<Home> i = repository.findAll(PageRequest.of(pageNumber, pageSize));
			return i.getContent();
		}
		
		public List<Home> paginationAndSortingList(int pageNumber, int pageSize, String column_name){
			Page<Home> i = repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(column_name).descending()));
			return i.getContent();
		}
}