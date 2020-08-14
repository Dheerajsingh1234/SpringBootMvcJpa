package com.jpa.mvcboot.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.mvcboot.model.book;
import com.jpa.mvcboot.repository.bookRepository;



@Service
public class modelservice {

	@Autowired
	private bookRepository repository;
	
	
	public Collection<book> getAll()
	{
	   // List <book> list=new ArrayList<book>();
		List<book>list= new ArrayList<book>();
		for(book books : repository.findAll())
		{
			list.add(books);
		}
		return list;
	}


	


	public book update(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(new book());
		
	}





	public book edit(book editedbook) {
		// TODO Auto-generated method stub
		
		return repository.save(editedbook);
	}





	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}





	public void addnew(book newbook) {
		// TODO Auto-generated method stub
		repository.save(newbook);
		
	}
}
