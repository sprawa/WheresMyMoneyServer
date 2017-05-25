package ms.wmm.server.database.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ms.wmm.server.database.entity.TransactionDB;
import ms.wmm.server.database.repository.custom.TransactionRepositoryCustom;

public class TransactionRepositoryImpl implements TransactionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<TransactionDB> getByGroupId(String user, long groupId) {
		String queryString = "SELECT t FROM TransactionDB t WHERE t.groupId=:groupId "
				+ "AND (t.lender=:user OR t.borrower=:user)";
		Query query = em.createQuery(queryString, TransactionDB.class);
		query.setParameter("groupId", groupId);
		query.setParameter("user", user);
		return query.getResultList();
	}
}
