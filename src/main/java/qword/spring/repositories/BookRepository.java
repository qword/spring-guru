package qword.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import qword.spring.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
