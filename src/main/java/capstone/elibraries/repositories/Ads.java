package capstone.elibraries.repositories;

import capstone.elibraries.models.Ad;
import capstone.elibraries.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

public interface Ads extends CrudRepository<Ad, Long> {

    Iterable<Ad> findAdBySeller(User user);

    @Query(nativeQuery = true,
            value = "SELECT * FROM ads WHERE ads.title " +
                    "like '%:title%' " +
                    "OR ads.description like '%:description%'")
    Iterable<Ad> findAdByAd(@Param("title") String title, @Param("description") String description);

    @Query(nativeQuery = true,
            value = "SELECT * FROM ads " +
                    "WHERE ads.title like '%:title%' " +
                    "OR ads.author like '%:author%' " +
                    "OR ads.synopsis like '%:synopsis%' ")
    Iterable<Ad> findAdByBook(@Param("title") String title,
                              @Param("author") String author,
                              @Param("synopsis") String synopsis);

}

