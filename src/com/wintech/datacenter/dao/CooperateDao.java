package com.wintech.datacenter.dao;

import com.wintech.datacenter.pojo.Cooperate;

public interface CooperateDao {
	Integer addCooperate(Cooperate cooperate);

	Integer getCooperateCount();

	Cooperate getCooperateByName(Cooperate cooperate);
}
