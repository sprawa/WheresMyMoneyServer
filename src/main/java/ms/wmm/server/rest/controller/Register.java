package ms.wmm.server.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Register {

	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
}
