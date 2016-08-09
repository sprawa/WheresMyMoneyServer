package ms.wmm.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ms.wmm.server.bo.Group;
import ms.wmm.server.database.entity.GroupDB;
import ms.wmm.server.database.repository.GroupRepository;

@Component
public class GroupService {

	@Autowired
	GroupRepository groupRepository;
	
	public long create(String name){
		GroupDB group=new GroupDB();
		String admin=SecurityContextHolder.getContext().getAuthentication().getName();
		group.setName(name);
		group.setAdmin_id(admin);
		group.setOpen("Y");
		return groupRepository.save(group).getId();
	}
	
	public List<GroupDB> getGroups(String user){
		return groupRepository.getGroups(user);
	}

}
