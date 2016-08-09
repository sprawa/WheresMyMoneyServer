package ms.wmm.server.rest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.database.entity.GroupDB;
import ms.wmm.server.service.GroupService;

@RestController
public class GroupController {

	@Autowired
	GroupService groupService;
	
	@RequestMapping(value="/createGroup", method=RequestMethod.POST)
	public ResponseEntity<Long> createGroup(@RequestParam(value="name") String name){
		long id=groupService.create(name);
		return new ResponseEntity<Long>(new Long(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getGroups", method=RequestMethod.GET)
	public ResponseEntity<List<GroupDB>> getGroups(Principal user){
		List<GroupDB> groups=groupService.getGroups(user.getName());
		return new ResponseEntity<List<GroupDB>>(groups,HttpStatus.OK);
	}
}
