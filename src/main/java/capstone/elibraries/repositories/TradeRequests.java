package capstone.elibraries.repositories;

import capstone.elibraries.models.TradeRequest;
import capstone.elibraries.models.User;
import org.springframework.data.repository.CrudRepository;

public interface TradeRequests extends CrudRepository<TradeRequest, Long> {
    Iterable<TradeRequest> findTradeRequestByPendingIsTrueAndTo(User user);

}

