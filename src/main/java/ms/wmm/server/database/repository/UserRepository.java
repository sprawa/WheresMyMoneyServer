package ms.wmm.server.database.repository;

import org.springframework.data.repository.CrudRepository;

import ms.wmm.server.database.entity.User;
import java.lang.String;

public interface UserRepository extends CrudRepository<User,String> {
}
