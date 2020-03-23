package qword.spring.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String isbn;


    @ManyToMany()
    @JoinTable(name = "author_book", joinColumns = @JoinColumn("book_id"), inverseJoinColumns = @JoinColumn("author_id"))
    private Set<Author> authors;

    public Book() {
    }

    public Book(String name, String isbn, Set<Author> authors) {
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
