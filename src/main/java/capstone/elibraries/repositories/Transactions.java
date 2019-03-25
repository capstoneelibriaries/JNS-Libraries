package capstone.elibraries.repositories;

import capstone.elibraries.models.Transaction;
import capstone.elibraries.models.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface Transactions extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllBySellerOrBuyerOrderByDateAsc(User user, User userr);
}

