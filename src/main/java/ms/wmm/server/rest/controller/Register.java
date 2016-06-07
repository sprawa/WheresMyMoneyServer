package ms.wmm.server.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.service.UserService;

@RestController
public class Register {

	@Autowired
	UserService userService;
	
	@RequestMapping("/register")
	public String register(@RequestParam(value="user") String username, @RequestParam(value="pass") String password){
		userService.register(username, password);
		return "Ok";
	}
	
}
