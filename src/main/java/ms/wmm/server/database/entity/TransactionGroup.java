package ms.wmm.server.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_group")
public class TransactionGroup {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@Column
	String name;
	
}
