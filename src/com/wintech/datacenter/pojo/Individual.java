package com.wintech.datacenter.pojo;

public class Individual {
	private Integer id;
	private Integer group_id;
	private String group_name;
	private Double indi_v;
	private Double indi_tem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Double getIndi_v() {
		return indi_v;
	}

	public void setIndi_v(Double indi_v) {
		this.indi_v = indi_v;
	}

	public Double getIndi_tem() {
		return indi_tem;
	}

	public void setIndi_tem(Double indi_tem) {
		this.indi_tem = indi_tem;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	@Override
	public String toString() {
		return "Individual [id=" + id + ", group_id=" + group_id + ", group_name=" + group_name + ", indi_v=" + indi_v
				+ ", indi_tem=" + indi_tem + "]";
	}


}
