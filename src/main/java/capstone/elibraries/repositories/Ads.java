package capstone.elibraries.repositories;

import capstone.elibraries.models.Ad;
import org.springframework.data.repository.CrudRepository;

public interface Ads extends CrudRepository<Ad, Long> {
}

