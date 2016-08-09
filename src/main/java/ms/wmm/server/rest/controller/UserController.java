package ms.wmm.server.rest.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.exception.UserExistsException;
import ms.wmm.server.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestParam(value="user") String username, @RequestParam(value="pass") String password){
		try {
			userService.register(username, password);
		} catch (UserExistsException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ResponseEntity<String>  getUser(Principal user){
		return new ResponseEntity<String>(user.getName(), HttpStatus.OK);
	}
	
}
