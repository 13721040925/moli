package com.wintech.datacenter.services;

import com.wintech.datacenter.dao.CooperateDao;
import com.wintech.datacenter.dao.CooperateDaoImpl;
import com.wintech.datacenter.pojo.Cooperate;

public class CooperateServiceImpl implements CooperateService {
	private CooperateDao cooperateDao = new CooperateDaoImpl();

	@Override
	public Integer addCooperate(Cooperate cooperate) {
		// TODO Auto-generated method stub
		return cooperateDao.addCooperate(cooperate);
	}

	@Override
	public Integer getCooperateCount() {
		// TODO Auto-generated method stub
		return cooperateDao.getCooperateCount();
	}

	@Override
	public Cooperate getCooperateByName(Cooperate cooperate) {
		// TODO Auto-generated method stub
		return cooperateDao.getCooperateByName(cooperate);
	}

}
