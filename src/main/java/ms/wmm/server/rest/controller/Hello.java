package ms.wmm.server.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.database.repository.UserRepository;

@RestController
public class Hello {
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello";
	}
}
