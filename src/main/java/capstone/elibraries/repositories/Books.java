package capstone.elibraries.repositories;

import capstone.elibraries.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Books extends CrudRepository<Book, Long> {

    List<Book> findByTitleIsLikeOrAuthorIsLikeOrSynopsisIsLike(
            String title,
            String author,
            String synopsis
    );

}
