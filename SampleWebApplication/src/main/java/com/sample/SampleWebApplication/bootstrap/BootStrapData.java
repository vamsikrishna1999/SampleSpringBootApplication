package com.sample.SampleWebApplication.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sample.SampleWebApplication.domain.Author;
import com.sample.SampleWebApplication.domain.Book;
import com.sample.SampleWebApplication.domain.Publisher;
import com.sample.SampleWebApplication.repositories.AuthorRepository;
import com.sample.SampleWebApplication.repositories.BookRepository;
import com.sample.SampleWebApplication.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	
	private final AuthorRepository authorRepository;
	
	private final BookRepository bookRepository;
	
	private final PublisherRepository publisherRepository;

	


	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}




	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("Started in bootstrap");
		
		Publisher pub = new Publisher();
		pub.setName("vamsi");
		pub.setCity("hyderabad");
		pub.setState("Telangana");
		
		publisherRepository.save(pub);
		System.out.println("Publisher record count: " + publisherRepository.count());
		
		Author vamsi = new Author("vamsi", "krishna");
		Book book = new Book("cp", "1234");
		
		vamsi.getBooks().add(book);
		book.getAuthors().add(vamsi);
		
		book.setPublisher(pub);
		pub.getBooks().add(book);
		
		authorRepository.save(vamsi);
		bookRepository.save(book);
		publisherRepository.save(pub);
		
		Author james = new Author("james", "swan");
		Book book1 = new Book("goose", "1234");
		
		james.getBooks().add(book1);
		book1.getAuthors().add(james);
		
		book1.setPublisher(pub);
		pub.getBooks().add(book1);
		
		
		authorRepository.save(james);
		bookRepository.save(book1);
		
		
		System.out.println("Number of books persisted: "+ bookRepository.count());
		System.out.println("Published books: " + pub.getBooks().size());
		
	}

}
