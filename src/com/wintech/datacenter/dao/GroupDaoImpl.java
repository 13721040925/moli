package com.wintech.datacenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wintech.datacenter.pojo.Group;
import com.wintech.datacenter.util.JDBCPoolUtil;

public class GroupDaoImpl extends JDBCPoolUtil implements GroupDao {

	@Override
	public Integer addGroup(Group group) {
		Connection ct = getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
		String sql = " insert into `group` (cooperate_id,cooperate_name,group_name,group_v,group_a,group_ah,indi_m,indi_n,dod,middle_v,surplus_time,group_total_time) values (?,?,?,?,?,?,?,?,?,?,?,?) ;";
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + sql);
		try {
			ps = ct.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			ps.setInt(index++, group.getCooperate_id());
			ps.setString(index++, group.getCooperate_name());
			ps.setString(index++, group.getGroup_name());
			ps.setDouble(index++, group.getGroup_v());
			ps.setDouble(index++, group.getGroup_a());
			ps.setInt(index++, group.getGroup_ah());
			ps.setInt(index++, group.getIndi_m());
			ps.setInt(index++, group.getIndi_n());
			ps.setInt(index++, group.getDod());
			ps.setDouble(index++, group.getMiddle_v());
			ps.setInt(index++, group.getSurplus_time());
			ps.setInt(index++, group.getGroup_total_time());
			int i = ps.executeUpdate();
			st = ps.getGeneratedKeys();//
			if (st.next()) {
				i = st.getInt(1);
			}
			ct.commit();// 提交事务
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ct.rollback();// 事务回滚
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			release(ct, ps, st);
		}
		return null;
	}


	@Override
	public Group getGroupByName(Group group) {
		Connection ct = getConnection();
		PreparedStatement ps = null;
		String sql = " select * from `group` where group_name = ? ;";
		ResultSet st = null;
		try {
			ps = ct.prepareStatement(sql);
			ps.setObject(1, group.getGroup_name());
			st = ps.executeQuery();
			Group g = null;
			while (st.next()) {
				g = new Group();
				g.setId(st.getInt("id"));
				g.setCooperate_id(st.getInt("cooperate_id"));
				g.setCooperate_name(st.getString("cooperate_name"));
				g.setGroup_name(st.getString("group_name"));
				g.setGroup_v(st.getDouble("group_v"));
				g.setGroup_a(st.getDouble("group_a"));
				g.setGroup_ah(st.getInt("group_ah"));
				g.setIndi_m(st.getInt("indi_m"));
				g.setIndi_n(st.getInt("indi_n"));
				g.setDod(st.getInt("dod"));
				g.setMiddle_v(st.getDouble("middle_v"));
				g.setSurplus_time(st.getInt("surplus_time"));
				g.setGroup_total_time(st.getInt("group_total_time"));
			}
			return g;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release(ct, ps, st);
		}
		return null;
	}

}
