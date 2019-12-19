package com.wintech.datacenter.services;

import com.wintech.datacenter.pojo.Group;

public interface GroupService {
	Integer addGroup(Group group);

	Group getGroupByName(Group group);
}
