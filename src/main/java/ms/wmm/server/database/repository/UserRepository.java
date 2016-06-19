package ms.wmm.server.database.repository;

import org.springframework.data.repository.CrudRepository;

import ms.wmm.server.database.entity.UserDB;
import java.lang.String;

public interface UserRepository extends CrudRepository<UserDB,String> {
}
