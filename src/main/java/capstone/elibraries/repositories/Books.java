package capstone.elibraries.repositories;

import capstone.elibraries.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface Books extends CrudRepository<Book, Long> {
}
