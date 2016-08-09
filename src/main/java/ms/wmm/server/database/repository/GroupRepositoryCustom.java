package ms.wmm.server.database.repository;

import java.util.List;

import ms.wmm.server.database.entity.GroupDB;

public interface GroupRepositoryCustom {
	public List<GroupDB> getGroups(String user);
}
