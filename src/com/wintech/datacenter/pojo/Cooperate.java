package com.wintech.datacenter.pojo;

import java.util.Arrays;

public class Cooperate {
	private Integer id;
	// private String ip;
	private String cooperate_name;
	private Double fdtime;// 放电倒计时
	private Integer totaltime;// 放电总时长
	private Integer onlioncount;// 电池组在线数量
	private Group[] groups = new Group[6];

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getFdtime() {
		return fdtime;
	}

	public void setFdtime(Double fdtime) {
		this.fdtime = fdtime;
	}

	public Integer getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}

	public Integer getOnlioncount() {
		return onlioncount;
	}

	public void setOnlioncount(Integer onlioncount) {
		this.onlioncount = onlioncount;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	public String getCooperate_name() {
		return cooperate_name;
	}

	public void setCooperate_name(String cooperate_name) {
		this.cooperate_name = cooperate_name;
	}

	@Override
	public String toString() {
		return "Cooperate [id=" + id + ", cooperate_name=" + cooperate_name + ", fdtime=" + fdtime + ", totaltime="
				+ totaltime + ", onlioncount=" + onlioncount + ", groups=" + Arrays.toString(groups) + "]";
	}


}
