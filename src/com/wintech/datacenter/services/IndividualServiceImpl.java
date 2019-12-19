package com.wintech.datacenter.services;

import com.wintech.datacenter.dao.IndividualDao;
import com.wintech.datacenter.dao.IndividualDaoImpl;
import com.wintech.datacenter.pojo.Individual;

public class IndividualServiceImpl implements IndividualService {
	private IndividualDao individualDao = new IndividualDaoImpl();

	@Override
	public Integer addIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return individualDao.addIndividual(individual);
	}

}
