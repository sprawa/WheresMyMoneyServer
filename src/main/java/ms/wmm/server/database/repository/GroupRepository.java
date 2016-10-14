package ms.wmm.server.database.repository;

import org.springframework.data.repository.CrudRepository;

import ms.wmm.server.database.entity.GroupDB;
import ms.wmm.server.database.repository.custom.GroupRepositoryCustom;

public interface GroupRepository extends CrudRepository<GroupDB, Long>, GroupRepositoryCustom {
	
}
