package capstone.elibraries.repositories;

import capstone.elibraries.models.TradeRequest;
import org.springframework.data.repository.CrudRepository;

public interface TradeRequests extends CrudRepository<TradeRequest, Long> {
}

