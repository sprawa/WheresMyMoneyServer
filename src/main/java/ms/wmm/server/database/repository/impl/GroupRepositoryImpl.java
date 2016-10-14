package ms.wmm.server.database.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ms.wmm.server.database.entity.GroupDB;
import ms.wmm.server.database.repository.custom.GroupRepositoryCustom;

public class GroupRepositoryImpl implements GroupRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<GroupDB> getGroups(String user) {
		String queryString="SELECT * FROM tr_group g WHERE EXISTS "
				+ "(SELECT * FROM group_user gu WHERE g.id=gu.group_id AND gu.user_id=:user AND gu.exited='N')";
		Query query=em.createNativeQuery(queryString,GroupDB.class);
		query.setParameter("user", user);
		return query.getResultList();
	}
}