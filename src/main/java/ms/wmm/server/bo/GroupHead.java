package ms.wmm.server.bo;

import java.util.List;

public class GroupHead {
	
	private Long id;
	private String name;
	private String adminName;
	private List<String> users;
	//private List<String> exitedUsers;
	private boolean open;
	private boolean admin;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public List<String> getUsers() {
		return users;
	}
	public void setUsers(List<String> users) {
		this.users = users;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	/*public List<String> getExitedUsers() {
		return exitedUsers;
	}
	public void setExitedUsers(List<String> exitedUsers) {
		this.exitedUsers = exitedUsers;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
