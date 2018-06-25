package ms.wmm.server.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ms.wmm.server.bo.GroupHead;
import ms.wmm.server.bo.Summary;
import ms.wmm.server.exception.GroupNotFoundException;
import ms.wmm.server.exception.NotAGroupAdminException;
import ms.wmm.server.exception.UserNotFoundException;
import ms.wmm.server.service.GroupService;

@RestController
public class GroupController {

	@Autowired
	private GroupService groupService;

	@RequestMapping(value = "/createGroup", method = RequestMethod.POST)
	public ResponseEntity<Long> createGroup(@RequestParam(value = "name") String name) {
		long id = groupService.create(name);
		return new ResponseEntity<Long>(new Long(id), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getGroups", method = RequestMethod.GET)
	public ResponseEntity<List<GroupHead>> getGroups() {
		List<GroupHead> groups = groupService.getGroups();
		return new ResponseEntity<>(groups, HttpStatus.OK);
	}

	@RequestMapping(value = "/closeGroup", method = RequestMethod.PUT)
	public ResponseEntity<Object> closeGroup(@RequestParam(value = "id") Long id) {
		try {
			groupService.closeGroup(id);
		} catch (NotAGroupAdminException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (GroupNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteGroup", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteGroup(@RequestParam(value = "id") Long id) {
		try {
			groupService.deleteGroup(id);
		} catch (NotAGroupAdminException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (GroupNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.PUT)
	public ResponseEntity<Object> addUser(@RequestParam(value = "groupId") Long id,
			@RequestParam(value = "user") String user) {
		try {
			groupService.addUser(id, user);
		} catch (NotAGroupAdminException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (UserNotFoundException | GroupNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/exitGroup", method = RequestMethod.POST)
	public ResponseEntity<Object> exitGroup(@RequestParam(value = "groupId") Long id) {
		groupService.exitGroup(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/getSummaries", method = RequestMethod.GET)
	public ResponseEntity<List<Summary>> getSummaries(@RequestParam(value = "groupId") Long id) {
		List<Summary> summaries;
		try {
			summaries = groupService.getSummaries(id);
		} catch (GroupNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Summary>>(summaries, HttpStatus.OK);
	}
}
