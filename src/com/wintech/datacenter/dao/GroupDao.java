package com.wintech.datacenter.dao;

import com.wintech.datacenter.pojo.Group;

public interface GroupDao {
	Integer addGroup(Group group);

	Group getGroupByName(Group group);
}
