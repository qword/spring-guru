package qword.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import qword.spring.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
