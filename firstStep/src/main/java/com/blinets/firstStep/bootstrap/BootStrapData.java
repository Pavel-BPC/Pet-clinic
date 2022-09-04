package com.blinets.firstStep.bootstrap;

import com.blinets.firstStep.domain.Author;
import com.blinets.firstStep.domain.Book;
import com.blinets.firstStep.domain.Publisher;
import com.blinets.firstStep.repositories.AuthorRepository;
import com.blinets.firstStep.repositories.BookRepository;
import com.blinets.firstStep.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = Publisher.builder()
                .name("SFG Publishing")
                .city("St Petersburg")
                .state("FL")
                .build();

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = Author.builder()
                .firstName("Eric")
                .lastName("Evans")
                .build();
        Book ddd = Book
                .builder()
                .title("Domain Driven Design")
                .isbn("123123")
                .build();

        eric.setBooks(Set.of(ddd));
        ddd.setAuthors(Set.of(eric));

        ddd.setPublisher(publisher);
        publisher.setBooks(Set.of(ddd));

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.setBooks(Set.of(noEJB));

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}