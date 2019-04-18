package App.Repositories;

import App.Entities.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("SELECT * FROM TRANSACTIONS WHERE ACCOUNT_ID = :accountID")
    Iterable<Transaction> findAll(@Param("accountID") long accountID);
}
