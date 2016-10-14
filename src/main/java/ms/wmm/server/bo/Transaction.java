package ms.wmm.server.bo;

import java.math.BigDecimal;

public class Transaction {

	private long id;
	private String user;
	private BigDecimal value;
	private boolean lender;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public boolean isLender() {
		return lender;
	}
	public void setLender(boolean lender) {
		this.lender = lender;
	}
	
	
}
