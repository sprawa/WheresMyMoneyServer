package ms.wmm.server.database.repository;

import org.springframework.data.repository.CrudRepository;

import ms.wmm.server.database.entity.GroupDB;

public interface GroupRepository extends CrudRepository<GroupDB, Long>, GroupRepositoryCustom {
	
}
