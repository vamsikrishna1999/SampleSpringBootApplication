package com.sample.SampleWebApplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sample.SampleWebApplication.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
