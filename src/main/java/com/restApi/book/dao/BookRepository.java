package com.restApi.book.dao;


import org.springframework.data.repository.CrudRepository;


import com.restApi.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);

}
