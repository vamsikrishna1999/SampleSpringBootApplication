package com.sample.SampleWebApplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sample.SampleWebApplication.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
