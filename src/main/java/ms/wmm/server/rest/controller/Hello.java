package ms.wmm.server.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.database.repository.UserRepository;

@RestController
public class Hello {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String hello(){
		/*User user=new User();
		user.setUsername("user");
		user.setPassword("pass");
		userRepository.save(user);*/
		return "Hello";
	}
}
