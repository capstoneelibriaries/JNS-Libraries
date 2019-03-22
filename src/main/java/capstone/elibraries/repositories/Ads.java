package capstone.elibraries.repositories;

import capstone.elibraries.models.Ad;
import capstone.elibraries.models.Book;
import capstone.elibraries.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Ads extends CrudRepository<Ad, Long> {

    Iterable<Ad> findAdBySeller(User user);

    List<Ad> findByTitleIsLikeOrDescriptionIsLike(String title, String description);

    List<Ad> findByBooks(List<Book> books);
}

