package qword.spring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qword.spring.domain.Author;
import qword.spring.domain.Book;
import qword.spring.domain.Publisher;
import qword.spring.repositories.AuthorRepository;
import qword.spring.repositories.BookRepository;
import qword.spring.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        final Publisher publisher = new Publisher();
        publisher.setAddress("Pavillion Road 45");
        publisher.setName("SFG Publishing");
        publisher.setCity("St. Petersburgh");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        final Author eric = new Author("Eric", "Evans");
        final Book ddd = new Book("Domain Drive Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        final Author rod = new Author("Rod", "Johnson");
        final Book noEJB = new Book("J2EE Development without EJB", "321321");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Application bootstrap, books added: " + bookRepository.count());
    }
}
