package qword.spring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qword.spring.domain.Author;
import qword.spring.domain.Book;
import qword.spring.repositories.AuthorRepository;
import qword.spring.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        final Author eric = new Author("Eric", "Evans");
        final Book ddd = new Book("Domain Drive Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        final Author rod = new Author("Rod", "Johnson");
        final Book noEJB = new Book("J2EE Development without EJB", "321321");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Application bootstrap, books added: " + bookRepository.count());
    }
}
