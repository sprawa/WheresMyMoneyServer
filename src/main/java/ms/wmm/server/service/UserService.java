package ms.wmm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ms.wmm.server.database.entity.UserDB;
import ms.wmm.server.database.repository.UserRepository;
import ms.wmm.server.exception.UserExistsException;

@Component
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDB user=userRepository.findOne(username);
		if(user!=null) return user;
		else throw new UsernameNotFoundException("Could not find user '"+username+"'");
	}
	
	public void register(String username,String password) throws UserExistsException{
		if(userRepository.exists(username)) throw new UserExistsException();
		UserDB user=new UserDB(username,new BCryptPasswordEncoder().encode(password));
		userRepository.save(user);
	}
}
