package com.restApi.book.services;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.restApi.book.dao.BookRepository;
import com.restApi.book.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> allbooks = new ArrayList<>();
	
//	static {
//		allbooks.add(new Book(10, "This is Java Language", "Deepak Yadav"));
//		allbooks.add(new Book(11, "This is Python Language", "Dheeraj Yadav"));
//		allbooks.add(new Book(12, "This is Go Language", "XYZ"));
//		
//	}
	
	public List<Book> getAllBooks(){
		List<Book> list = null;
		try {
				list = (List<Book>)this.bookRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Book getBookById(int id) {
		Book obj = null;
		try {
//			obj =  allbooks.stream().filter(e -> e.getId() == id).findFirst().get();
			obj = this.bookRepository.findById(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return obj;
	}
	
	public Book addBook(Book book) {
		this.bookRepository.save(book);
//		allbooks.add(book);
		return book;
	}
	
	public void deleteBookById(int id) {
		try {
//			allbooks = this.allbooks.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
			this.bookRepository.deleteById(id);	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void update(int id, Book book) {
		try {
//			allbooks = this.allbooks.stream().map(b -> {
//				if(b.getId() == id) {
//					b.setTitle(book.getTitle());
//					b.setAuthor(book.getAuthor());
//				}
//				return b;
//			}).collect(Collectors.toList());
			book.setId(id);
			this.bookRepository.save(book);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
