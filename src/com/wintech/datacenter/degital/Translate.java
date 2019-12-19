package com.wintech.datacenter.degital;

import com.wintech.datacenter.pojo.Cooperate;
import com.wintech.datacenter.pojo.Group;
import com.wintech.datacenter.pojo.Individual;
import com.wintech.datacenter.services.CooperateService;
import com.wintech.datacenter.services.CooperateServiceImpl;
import com.wintech.datacenter.services.GroupService;
import com.wintech.datacenter.services.GroupServiceImpl;
import com.wintech.datacenter.services.IndividualService;
import com.wintech.datacenter.services.IndividualServiceImpl;
import com.wintech.datacenter.util.Changedegital;

public class Translate {
	private static CooperateService cooperateService = new CooperateServiceImpl();
	private static GroupService groupService = new GroupServiceImpl();
	private static IndividualService individualService = new IndividualServiceImpl();

	public static String transDegital(String res) {
		String DATA_FALG = "";
		String VER = res.substring(1, 3);
		String ADR = res.substring(3, 5);
		String CRD1 = res.substring(5, 7);
		String RTN = res.substring(7, 9);
		if (panduan(RTN)) {
			String LENGTH = res.substring(9, 13);
			String LENID = res.substring(10, 13);
			int INFO_Len = Integer.parseInt(LENID, 16) / 2;
			DATA_FALG = res.substring(13, 15);
			switch (DATA_FALG) {
			case "00": {
				System.out.println("无未读取的开关量变化,无未读取的告警量变化");
				break;
			}
			case "11": {
				System.out.println("有未读取的开关量变化,有未读取的告警量变化");
				break;
			}
			case "01": {
				System.out.println("无未读取的开关量变化,有未读取的告警量变化");
				break;
			}
			case "10": {
				System.out.println("有未读取的开关量变化,无未读取的告警量变化");
				break;
			}
			}

			String str = "";
			int n = 0;
			str = res.substring(15, 19);
			n = Integer.parseInt(str, 16);
			double group1V = n / 100;
			str = res.substring(19, 23);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group1A = n / 10;
			str = res.substring(23, 27);
			n = Integer.parseInt(str, 16);
			int group1AH = n;

			str = res.substring(27, 31);
			n = Integer.parseInt(str, 16);
			double group2V = n / 100;
			str = res.substring(31, 35);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group2A = n / 10;
			str = res.substring(35, 39);
			n = Integer.parseInt(str, 16);
			int group2AH = n;

			str = res.substring(39, 43);
			n = Integer.parseInt(str, 16);
			double group3V = n / 100;
			str = res.substring(43, 47);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group3A = n / 10;
			str = res.substring(47, 51);
			n = Integer.parseInt(str, 16);
			int group3AH = n;

			str = res.substring(51, 55);
			n = Integer.parseInt(str, 16);
			double group4V = n / 100;
			str = res.substring(55, 59);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group4A = n / 10;
			str = res.substring(59, 63);
			n = Integer.parseInt(str, 16);
			int group4AH = n;

			str = res.substring(63, 67);
			n = Integer.parseInt(str, 16);
			double group5V = n / 100;
			str = res.substring(67, 71);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group5A = n / 10;
			str = res.substring(71, 75);
			n = Integer.parseInt(str, 16);
			int group5AH = n;

			str = res.substring(75, 79);
			n = Integer.parseInt(str, 16);
			double group6V = n / 100;
			str = res.substring(79, 83);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group6A = n / 10;
			str = res.substring(83, 87);
			n = Integer.parseInt(str, 16);
			int group6AH = n;

			str = res.substring(87, 91);
			n = Integer.parseInt(str, 16);
			double fdtime = n / 10;// 放电倒计时
			str = res.substring(91, 95);
			n = Integer.parseInt(str, 16);
			int totaltime = n;// 放电总时长
			str = res.substring(95, 97);
			n = Integer.parseInt(str, 16);
			int onlioncount = n;// 电池组在线数量

			str = res.substring(97, 99);
			n = Integer.parseInt(str, 16);
			int group1m = n;// 电池组1的单体个数m1
			double[] group1mV = new double[group1m];
			int start = 99;
			for (int i = 0; i < group1m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group1mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group2m = n;// 电池组2的单体个数m2
			double[] group2mV = new double[group2m];
			start += 2;
			for (int i = 0; i < group2m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group2mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group3m = n;// 电池组3的单体个数m3
			double[] group3mV = new double[group3m];
			start += 2;
			for (int i = 0; i < group3m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group3mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group4m = n;// 电池组4的单体个数m4
			double[] group4mV = new double[group4m];
			start += 2;
			for (int i = 0; i < group4m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group4mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group5m = n;// 电池组5的单体个数m5
			double[] group5mV = new double[group5m];
			start += 2;
			for (int i = 0; i < group5m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group5mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group6m = n;// 电池组6的单体个数m6
			double[] group6mV = new double[group6m];
			start += 2;
			for (int i = 0; i < group6m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group6mV[i] = v;
				start += 4;
			} // 电池组6 END

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group1n = n;// 电池组1（或单体）温度数n1
			double[] group1nTem = new double[group1n];
			start += 2;
			for (int i = 0; i < group1n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group1nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group2n = n;// 电池组2（或单体）温度数n2
			double[] group2nTem = new double[group2n];
			start += 2;
			for (int i = 0; i < group2n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group2nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group3n = n;// 电池组3（或单体）温度数n3
			double[] group3nTem = new double[group3n];
			start += 2;
			for (int i = 0; i < group3n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group3nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group4n = n;// 电池组4（或单体）温度数n4
			double[] group4nTem = new double[group4n];
			start += 2;
			for (int i = 0; i < group4n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group4nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group5n = n;// 电池组5（或单体）温度数n5
			double[] group5nTem = new double[group5n];
			start += 2;
			for (int i = 0; i < group5n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group5nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group6n = n;// 电池组6（或单体）温度数n6
			double[] group6nTem = new double[group6n];
			start += 2;
			for (int i = 0; i < group6n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group6nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group1DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group2DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group3DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group4DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group5DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group6DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group1MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group2MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group3MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group4MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group5MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group6MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group1SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group2SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group3SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group4SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group5SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group6SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group1TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group2TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group3TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group4TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group5TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group6TotalTime = n;
			start += 4;

			String CHKSUM = res.substring(start, start + 4);

			Cooperate cooperate = addCooperate(fdtime, totaltime, onlioncount);
			cooperate = cooperateService.getCooperateByName(cooperate);
			String cooperate_name = cooperate.getCooperate_name();
			Integer cooperate_id=cooperate.getId();

			Group group1 = addGroup(cooperate_id, cooperate_name, group1V, group1A, group1AH, group1m, group1n,
					group1DOD, group1MiddleV, group1SurplusTime, group1TotalTime, 1);
			group1 = groupService.getGroupByName(group1);
			Integer group1_id = group1.getId();
			String group1_name = group1.getGroup_name();
			if (addIndividual(group1_id, group1_name, group1mV, group1nTem)) {
				System.out.println("group1单体添加成功！");
			}

			Group group2 = addGroup(cooperate_id, cooperate_name, group2V, group2A, group2AH, group2m, group2n,
					group2DOD, group2MiddleV, group2SurplusTime, group2TotalTime, 2);
			group2 = groupService.getGroupByName(group2);
			Integer group2_id = group2.getId();
			String group2_name = group2.getGroup_name();
			if (addIndividual(group2_id, group2_name, group2mV, group2nTem)) {
				System.out.println("group2单体添加成功！");
			}

			Group group3 = addGroup(cooperate_id, cooperate_name, group3V, group3A, group3AH, group3m, group3n,
					group3DOD, group3MiddleV, group3SurplusTime, group3TotalTime, 3);
			group3 = groupService.getGroupByName(group3);
			Integer group3_id = group3.getId();
			String group3_name = group3.getGroup_name();
			if (addIndividual(group3_id, group3_name, group3mV, group3nTem)) {
				System.out.println("group3单体添加成功！");
			}

			Group group4 = addGroup(cooperate_id, cooperate_name, group4V, group4A, group4AH, group4m, group4n,
					group4DOD, group4MiddleV, group4SurplusTime, group4TotalTime, 4);
			group4 = groupService.getGroupByName(group4);
			Integer group4_id = group4.getId();
			String group4_name = group4.getGroup_name();
			if (addIndividual(group4_id, group4_name, group4mV, group4nTem)) {
				System.out.println("group4单体添加成功！");
			}

			Group group5 = addGroup(cooperate_id, cooperate_name, group5V, group5A, group5AH, group5m, group5n,
					group5DOD, group5MiddleV, group5SurplusTime, group5TotalTime, 5);
			group5 = groupService.getGroupByName(group5);
			Integer group5_id = group5.getId();
			String group5_name = group5.getGroup_name();
			if (addIndividual(group5_id, group5_name, group5mV, group5nTem)) {
				System.out.println("group5单体添加成功！");
			}

			Group group6 = addGroup(cooperate_id, cooperate_name, group6V, group6A, group6AH, group6m, group6n,
					group6DOD, group6MiddleV, group6SurplusTime, group4TotalTime, 6);
			group6 = groupService.getGroupByName(group6);
			Integer group6_id = group6.getId();
			String group6_name = group6.getGroup_name();
			if (addIndividual(group6_id, group6_name, group6mV, group6nTem)) {
				System.out.println("group6单体添加成功！");
			}
		}
		return DATA_FALG;

	}

	public static Cooperate addCooperate(double fdtime, int totaltime, int onlioncount) {
		Cooperate cooperate = new Cooperate();
		cooperate.setFdtime(fdtime);
		cooperate.setTotaltime(totaltime);
		cooperate.setOnlioncount(onlioncount);
		int cooperateCount = cooperateService.getCooperateCount();
		String cooperate_name = "WDT" + (cooperateCount + 1);
		cooperate.setCooperate_name(cooperate_name);
		int i = cooperateService.addCooperate(cooperate);
		if (i > 0) {
			System.out.println("cooperate添加成功！");
		}
		return cooperate;

	}

	public static Group addGroup(Integer cooperate_id, String cooperate_name, Double group_v, Double group_a,
			Integer group_ah, Integer indi_m, Integer indi_n, Integer dod, Double middle_v, Integer surplus_time,
			Integer group_total_time, int n) {
		Group group=new Group();
		group.setCooperate_id(cooperate_id);
		group.setCooperate_name(cooperate_name);
		group.setGroup_v(group_v);
		group.setGroup_a(group_a);
		group.setGroup_ah(group_ah);
		group.setIndi_m(indi_m);
		group.setIndi_n(indi_n);
		group.setDod(dod);
		group.setMiddle_v(middle_v);
		group.setSurplus_time(surplus_time);
		group.setGroup_total_time(group_total_time);
		String group_name = cooperate_name + "_group" + n;
		group.setGroup_name(group_name);
		int i = groupService.addGroup(group);
		if (i > 0) {
			System.out.println("group" + n + "添加成功！");
		}
		return group;

	}

	public static boolean addIndividual(Integer group_id, String group_name, double[] groupmV, double[] groupnTem) {
		boolean flag = true;
		for (int i = 0; i < groupmV.length; i++) {
			Double indi_v = groupmV[i];
			Double indi_tem = groupnTem[i];
			Individual individual = new Individual();
			individual.setGroup_id(group_id);
			individual.setGroup_name(group_name);
			individual.setIndi_v(indi_v);
			individual.setIndi_tem(indi_tem);
			if (individualService.addIndividual(individual) <= 0) {
				flag = false;
			}
		}
		return flag;

	}

	public static boolean panduan(String RTN) {
		switch (RTN) {
		case "00": {
			System.out.println("正常");
			return true;
		}
		case "01": {
			System.out.println("VER错");
			break;
		}
		case "02": {
			System.out.println("CHKSUM错");
			break;
		}
		case "03": {
			System.out.println("LCHKSUM错");
			break;
		}
		case "04": {
			System.out.println("CID2无效");
			break;
		}
		case "05": {
			System.out.println("命令格式错");
			break;
		}
		case "06": {
			System.out.println("无效数据");
			break;
		}
		case "07": {
			System.out.println("无数据");
			break;
		}
		case "E1": {
			System.out.println("CID1无效");
			break;
		}
		case "E2": {
			System.out.println("命令执行失败");
			break;
		}
		case "E3": {
			System.out.println("设备故障");
			break;
		}
		case "E4": {
			System.out.println("无效权限");
			break;
		}
		case "E5": {
			System.out.println("设备写保护");
			break;
		}
		case "FF": {
			System.out.println("不用返回响应包");
			break;
		}
		default: {
			System.out.println("其他错误");
			break;
		}
		}
		return false;

	}
}
