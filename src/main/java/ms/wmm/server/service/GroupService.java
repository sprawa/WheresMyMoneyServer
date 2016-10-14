package ms.wmm.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ms.wmm.server.bo.GroupHead;
import ms.wmm.server.database.entity.GroupDB;
import ms.wmm.server.database.entity.GroupUserDB;
import ms.wmm.server.database.repository.GroupRepository;
import ms.wmm.server.database.repository.GroupUserRepository;

@Component
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private GroupUserRepository groupUserRepository;
	
	public long create(String name){
		GroupDB group=new GroupDB();
		group.setName(name);
		group.setOpen("Y");
		group=groupRepository.save(group);
		
		GroupUserDB groupUser=new GroupUserDB();
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		groupUser.setUser(user);
		groupUser.setAdmin("Y");
		groupUser.setExited("N");
		groupUser.setGroupId(group.getId());
		groupUserRepository.save(groupUser);

		return group.getId();
	}
	
	public List<GroupHead> getGroupHeads(List<GroupDB> groupsDB){
		List<GroupHead> groups=new ArrayList<GroupHead>();
		for(GroupDB db:groupsDB){
			groups.add(getGroupHead(db));
		}
		return groups;
	}
	
	private GroupHead getGroupHead(GroupDB db) {
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		GroupHead groupHead=new GroupHead();
		groupHead.setName(db.getName());
		groupHead.setOpen(db.getOpen().equals("Y")?true:false);
		List<GroupUserDB> groupUsers=groupUserRepository.findByGroupId(db.getId());
		List<String> users=new ArrayList<String>();
 		for(GroupUserDB groupUser:groupUsers){
			if(groupUser.getAdmin().equals("Y")){
				groupHead.setAdminName(groupUser.getUser());
				if(groupUser.getUser().equals(user)){
					groupHead.setAdmin(true);
				}
				else groupHead.setAdmin(false);
			}
			else if(!groupUser.getExited().equals("Y")) users.add(groupUser.getUser());
		}
		groupHead.setUsers(users);
		return groupHead; 
	}

	public List<GroupHead> getGroups(){
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		return getGroupHeads(groupRepository.getGroups(user));
	}
}
