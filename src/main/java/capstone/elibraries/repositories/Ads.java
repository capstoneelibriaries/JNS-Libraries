package capstone.elibraries.repositories;

import capstone.elibraries.models.Ad;
import capstone.elibraries.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Ads extends CrudRepository<Ad, Long> {

    Iterable<Ad> findAdBySeller(User user);

    @Query("FROM ads WHERE title like ?1 OR description like ?2")
    Iterable<Ad> findAdByAd(String title, String description);

    @Query("FROM ads WHERE title like ?1 OR author like ?2 OR synopsis like ?3")
    Iterable<Ad> findAdByBook(String title, String author, String synopsis);

}

