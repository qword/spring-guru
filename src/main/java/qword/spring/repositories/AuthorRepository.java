package qword.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import qword.spring.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
