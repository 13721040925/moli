package com.wintech.datacenter.pojo;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private Integer id;
	private Integer cooperate_id;
	private String cooperate_name;
	private String group_name;
	private Double group_v;
	private Double group_a;
	private Integer group_ah;
	private Integer indi_m;// 电池组的单体个数m
	private Integer indi_n;// 电池组的单体温度数n
	private List indis = new ArrayList<Individual>();
	private Integer dod;
	private Double middle_v;
	private Integer surplus_time;
	private Integer group_total_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCooperate_id() {
		return cooperate_id;
	}

	public void setCooperate_id(Integer cooperate_id) {
		this.cooperate_id = cooperate_id;
	}

	public Double getGroup_v() {
		return group_v;
	}

	public void setGroup_v(Double group_v) {
		this.group_v = group_v;
	}

	public Double getGroup_a() {
		return group_a;
	}

	public void setGroup_a(Double group_a) {
		this.group_a = group_a;
	}

	public Integer getGroup_ah() {
		return group_ah;
	}

	public void setGroup_ah(Integer group_ah) {
		this.group_ah = group_ah;
	}

	public Integer getIndi_m() {
		return indi_m;
	}

	public void setIndi_m(Integer indi_m) {
		this.indi_m = indi_m;
	}

	public Integer getIndi_n() {
		return indi_n;
	}

	public void setIndi_n(Integer indi_n) {
		this.indi_n = indi_n;
	}

	public List getIndis() {
		return indis;
	}

	public void setIndis(List indis) {
		this.indis = indis;
	}

	public Integer getDod() {
		return dod;
	}

	public void setDod(Integer dod) {
		this.dod = dod;
	}

	public Double getMiddle_v() {
		return middle_v;
	}

	public void setMiddle_v(Double middle_v) {
		this.middle_v = middle_v;
	}

	public Integer getSurplus_time() {
		return surplus_time;
	}

	public void setSurplus_time(Integer surplus_time) {
		this.surplus_time = surplus_time;
	}

	public Integer getGroup_total_time() {
		return group_total_time;
	}

	public void setGroup_total_time(Integer group_total_time) {
		this.group_total_time = group_total_time;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getCooperate_name() {
		return cooperate_name;
	}

	public void setCooperate_name(String cooperate_name) {
		this.cooperate_name = cooperate_name;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", cooperate_id=" + cooperate_id + ", cooperate_name=" + cooperate_name
				+ ", group_name=" + group_name + ", group_v=" + group_v + ", group_a=" + group_a + ", group_ah="
				+ group_ah + ", indi_m=" + indi_m + ", indi_n=" + indi_n + ", indis=" + indis + ", dod=" + dod
				+ ", middle_v=" + middle_v + ", surplus_time=" + surplus_time + ", group_total_time=" + group_total_time
				+ "]";
	}



}
