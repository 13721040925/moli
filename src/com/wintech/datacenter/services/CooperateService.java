package com.wintech.datacenter.services;

import com.wintech.datacenter.pojo.Cooperate;

public interface CooperateService {
	Integer addCooperate(Cooperate cooperate);

	Integer getCooperateCount();

	Cooperate getCooperateByName(Cooperate cooperate);
}
