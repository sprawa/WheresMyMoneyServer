package ms.wmm.server.database.repository.custom;

import java.util.List;

import ms.wmm.server.database.entity.TransactionDB;

public interface TransactionRepositoryCustom {

	public List<TransactionDB> getByGroupId(String user, long groupId);
}
