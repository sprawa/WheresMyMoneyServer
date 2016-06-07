package ms.wmm.server.rest.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.service.UserService;

@RestController
public class User {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void register(@RequestParam(value="user") String username, @RequestParam(value="pass") String password){
		userService.register(username, password);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getUser(Principal user){
		return user.getName();
	}
	
}
