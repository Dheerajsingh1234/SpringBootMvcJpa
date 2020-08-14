package com.jpa.mvcboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.mvcboot.model.book;

public interface bookRepository extends CrudRepository<book,Long> {

}
