package capstone.elibraries.repositories;

import capstone.elibraries.models.Ad;
import capstone.elibraries.models.User;
import org.springframework.data.repository.CrudRepository;

public interface Ads extends CrudRepository<Ad, Long> {
    Iterable<Ad> findAdBySeller(User user);
}

