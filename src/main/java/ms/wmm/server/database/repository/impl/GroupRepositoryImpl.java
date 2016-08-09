package ms.wmm.server.database.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ms.wmm.server.database.entity.GroupDB;
import ms.wmm.server.database.repository.GroupRepositoryCustom;

public class GroupRepositoryImpl implements GroupRepositoryCustom {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<GroupDB> getGroups(String user) {
		String queryString="SELECT * FROM tr_group g WHERE g.admin_id=:user OR EXISTS "
				+ "(SELECT * FROM user_group ug WHERE g.id=ug.group_id AND ug.user_id=:user)";
		Query query=em.createNativeQuery(queryString);
		query.setParameter("user", user);
		return query.getResultList();
	}

}
