package com.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.models.Book;
import com.lms.repository.LmsRepository;

@Service
public class LmsService {

private LmsRepository lmsRepository;
	
	@Autowired
	public LmsService(LmsRepository lmsRepository) {
		this.lmsRepository = lmsRepository;
	}
	public List<Book> findBooks(){
		return lmsRepository.findAll();
	}
	public void deleteBook(long id) {
		lmsRepository.delete(id);
		
	}
	public Book findOne(long id) {
		return lmsRepository.findOne(id);
	}
	public void save(Book book) {
		lmsRepository.save(book);
	}
	public void delete(long id) {
		lmsRepository.delete(id);
	}
}
