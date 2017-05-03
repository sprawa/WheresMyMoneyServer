package ms.wmm.server.bo;

import java.math.BigDecimal;
import java.util.List;

public class Summary {

	private String user;
	private BigDecimal value;
	private List<Transaction> transactions;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
