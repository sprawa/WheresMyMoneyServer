package ms.wmm.server.database.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ms.wmm.server.database.entity.GroupUserDB;

public interface GroupUserRepository extends CrudRepository<GroupUserDB, Long> {
	
	public List<GroupUserDB> findByGroupId(Long groupId);
	public List<GroupUserDB> findByGroupIdAndUser(Long groupId,String user);
}
