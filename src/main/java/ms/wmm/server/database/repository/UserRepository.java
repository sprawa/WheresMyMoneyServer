package ms.wmm.server.database.repository;

import org.springframework.data.repository.CrudRepository;

import ms.wmm.server.database.entity.User;
import java.lang.String;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

	List<User> findByUsername(String username);
	<S extends User> S save(S user);
}
