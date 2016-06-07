package ms.wmm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ms.wmm.server.database.entity.User;
import ms.wmm.server.database.repository.UserRepository;

@Component
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findOne(username);
		if(user!=null) return user;
		else throw new UsernameNotFoundException("Could not find user '"+username+"'");
	}
	
	public void register(String username,String password){
		User user=new User(username,password);
		userRepository.save(user);
	}

}
