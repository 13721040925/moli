package com.wintech.datacenter.services;

import com.wintech.datacenter.dao.GroupDao;
import com.wintech.datacenter.dao.GroupDaoImpl;
import com.wintech.datacenter.pojo.Group;

public class GroupServiceImpl implements GroupService {
	private GroupDao groupDao = new GroupDaoImpl();

	@Override
	public Integer addGroup(Group group) {
		// TODO Auto-generated method stub
		return groupDao.addGroup(group);
	}

	@Override
	public Group getGroupByName(Group group) {
		// TODO Auto-generated method stub
		return groupDao.getGroupByName(group);
	}

}
