package ms.wmm.server.database.repository;

import org.springframework.data.repository.CrudRepository;

import ms.wmm.server.database.entity.TransactionDB;
import ms.wmm.server.database.repository.custom.TransactionRepositoryCustom;

public interface TransactionRepository extends CrudRepository<TransactionDB,String>, TransactionRepositoryCustom {

}
