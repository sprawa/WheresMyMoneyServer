package ms.wmm.server.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.bo.Transaction;
import ms.wmm.server.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="/getTransactions",method=RequestMethod.POST)
	public ResponseEntity<List<Transaction>> getTransactions(@RequestParam(value="groupId") Long groupId){
		List<Transaction> transactions=transactionService.getTransactionsByGroupId(groupId);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(value="/borrow", method=RequestMethod.POST)
	public ResponseEntity<Object> borrow(@RequestParam(value="value") BigDecimal value,
			@RequestParam(value="lender") String lender,@RequestParam(value="description") String description,
			@RequestParam(value="groupId") Long groupId){
		transactionService.borrow(value, lender, description, groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
