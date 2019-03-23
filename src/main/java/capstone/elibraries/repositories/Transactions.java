package capstone.elibraries.repositories;

import capstone.elibraries.models.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface Transactions extends CrudRepository<Transaction, Long> {
}

