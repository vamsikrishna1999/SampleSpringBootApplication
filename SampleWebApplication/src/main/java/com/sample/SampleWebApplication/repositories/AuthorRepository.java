package com.sample.SampleWebApplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sample.SampleWebApplication.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
