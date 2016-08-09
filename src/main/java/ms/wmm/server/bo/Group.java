package ms.wmm.server.bo;

import java.util.HashMap;
import java.util.List;

public class Group {

	Long id;
	String name;
	boolean admin;
	List<HashMap<String,Boolean>> users;
	boolean accepted;
	
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public List<HashMap<String,Boolean>> getUsers() {
		return users;
	}
	public void setUsers(List<HashMap<String,Boolean>> users) {
		this.users = users;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
