package ms.wmm.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ms.wmm.server.bo.GroupHead;
import ms.wmm.server.database.entity.GroupDB;
import ms.wmm.server.database.entity.GroupUserDB;
import ms.wmm.server.database.repository.GroupRepository;
import ms.wmm.server.database.repository.GroupUserRepository;
import ms.wmm.server.database.repository.UserRepository;
import ms.wmm.server.exception.GroupNotFoundException;
import ms.wmm.server.exception.NotAGroupAdminException;
import ms.wmm.server.exception.UserNotFoundException;

@Component
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private GroupUserRepository groupUserRepository;

	@Autowired
	private UserRepository userRepository;

	public long create(String name) {
		GroupDB group = new GroupDB();
		group.setName(name);
		group.setOpen("Y");
		group = groupRepository.save(group);

		GroupUserDB groupUser = new GroupUserDB();
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		groupUser.setUser(user);
		groupUser.setAdmin("Y");
		groupUser.setExited("N");
		groupUser.setGroupId(group.getId());
		groupUserRepository.save(groupUser);

		return group.getId();
	}

	public List<GroupHead> getGroupHeads(List<GroupDB> groupsDB) {
		List<GroupHead> groups = new ArrayList<GroupHead>();
		for (GroupDB db : groupsDB) {
			groups.add(getGroupHead(db));
		}
		return groups;
	}

	private GroupHead getGroupHead(GroupDB db) {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		GroupHead groupHead = new GroupHead();
		groupHead.setName(db.getName());
		groupHead.setOpen(db.getOpen().equals("Y") ? true : false);
		List<GroupUserDB> groupUsers = groupUserRepository.findByGroupId(db.getId());
		List<String> users = new ArrayList<String>();
		for (GroupUserDB groupUser : groupUsers) {
			if (groupUser.getAdmin().equals("Y")) {
				groupHead.setAdminName(groupUser.getUser());
				if (groupUser.getUser().equals(user)) {
					groupHead.setAdmin(true);
				} else
					groupHead.setAdmin(false);
			} else if (!groupUser.getExited().equals("Y"))
				users.add(groupUser.getUser());
		}
		groupHead.setId(db.getId());
		groupHead.setUsers(users);
		return groupHead;
	}

	public List<GroupHead> getGroups() {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		return getGroupHeads(groupRepository.getGroups(user));
	}

	public void closeGroup(Long id) throws NotAGroupAdminException, GroupNotFoundException {
		if (!isAdmin(id))
			throw new NotAGroupAdminException();
		GroupDB db = groupRepository.findOne(id);
		db.setOpen("N");
		groupRepository.save(db);
	}

	public void deleteGroup(Long id) throws NotAGroupAdminException, GroupNotFoundException {
		if (!isAdmin(id))
			throw new NotAGroupAdminException();
		groupRepository.delete(id);
	}

	private boolean isAdmin(Long id) throws GroupNotFoundException {
		if (!groupRepository.exists(id))
			throw new GroupNotFoundException();
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		GroupUserDB groupUser = groupUserRepository.findByGroupIdAndUser(id, user).get(0);
		return groupUser.getAdmin().equals("Y");
	}

	public void addUser(Long groupId, String user)
			throws NotAGroupAdminException, UserNotFoundException, GroupNotFoundException {
		if (!groupRepository.exists(groupId))
			throw new GroupNotFoundException();
		if (!isAdmin(groupId))
			throw new NotAGroupAdminException();
		if (!userRepository.exists(user))
			throw new UserNotFoundException();
		GroupUserDB db = new GroupUserDB();
		db.setAdmin("N");
		db.setExited("N");
		db.setGroupId(groupId);
		db.setUser(user);
		groupUserRepository.save(db);
	}

	public void exitGroup(Long groupId) {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		GroupUserDB groupUser = groupUserRepository.findByGroupIdAndUser(groupId, user).get(0);
		groupUser.setExited("Y");
		groupUserRepository.save(groupUser);
	}
}
