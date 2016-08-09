package ms.wmm.server.database.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tr_group")
public class GroupDB {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column
	String name;
	
	@Column
	String admin_id;
	
	@Column
	String open;
	
	@ElementCollection
	@CollectionTable(name="user_group", joinColumns=@JoinColumn(name="group_id"))
	@Column(name="user")
	Set<String> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(Set<String> users) {
		this.users = users;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
}
