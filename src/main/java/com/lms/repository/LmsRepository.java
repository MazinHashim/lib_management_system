package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.models.Book;

@Repository
public interface LmsRepository extends JpaRepository<Book, Long>{

}
