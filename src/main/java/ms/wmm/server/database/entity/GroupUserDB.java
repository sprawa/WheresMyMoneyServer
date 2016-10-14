package ms.wmm.server.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_user")
public class GroupUserDB {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="group_id")
	private Long groupId;
	
	@Column(name="user_id")
	private String user;
	
	@Column 
	private String exited;
	
	@Column
	private String admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getExited() {
		return exited;
	}

	public void setExited(String exited) {
		this.exited = exited;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
