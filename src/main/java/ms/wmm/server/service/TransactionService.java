package ms.wmm.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ms.wmm.server.bo.Transaction;
import ms.wmm.server.database.entity.TransactionDB;
import ms.wmm.server.database.repository.TransactionRepository;
import ms.wmm.server.exception.TransactionException;

@Component
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> getTransactionsByGroupId(long groupId){
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		List<TransactionDB> dbList=transactionRepository.getByGroupId(user, groupId);
		List<Transaction> transactions=new ArrayList<Transaction>();
		for(TransactionDB db:dbList){
			Transaction tr=getTransactionFromDb(db);
			if(tr!=null)
			transactions.add(tr);
		}
		return transactions;
	}

	private Transaction getTransactionFromDb(TransactionDB db){
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		Transaction transaction=new Transaction();
		transaction.setId(db.getId());
		transaction.setValue(db.getValue());
		if(db.getLender().equals(user)){
			transaction.setUser(db.getBorrower());
			transaction.setLender(true);
		}
		else if(db.getBorrower().equals(user)){
			transaction.setUser(db.getLender());
			transaction.setLender(false);
		}else{
			return null;
		}
		return transaction;
	}
	
	public void borrow(BigDecimal value,String lender,String description,Long groupId){
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		TransactionDB db=new TransactionDB();
		db.setBorrower(user);
		db.setDescription(description);
		db.setGroupId(groupId);
		db.setLender(lender);
		transactionRepository.save(db);
	}
}
