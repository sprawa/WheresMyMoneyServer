package ms.wmm.server.database.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class UserDB implements UserDetails {
	
	private static final long serialVersionUID = 4586876151030324208L;

	@Id
	@Column
	private String id;
	
	@Column
	private String password;
	
	public UserDB() {}
	
	public UserDB(String username,String password){
		this.id=username;
		this.password=password;
	}

	public String getId() {
		return id;
	}

	public void setUsername(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return id;
	}
}
