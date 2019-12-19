package com.wintech.datacenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wintech.datacenter.pojo.Cooperate;
import com.wintech.datacenter.util.JDBCPoolUtil;

public class CooperateDaoImpl extends JDBCPoolUtil implements CooperateDao {

	@Override
	public Integer addCooperate(Cooperate cooperate) {
		Connection ct = getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
		String sql = " insert into cooperate (cooperate_name,fdtime,totaltime,onlioncount) values (?,?,?,?) ;";
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + sql);
		try {
			ps = ct.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			ps.setString(index++, cooperate.getCooperate_name());
			ps.setDouble(index++, cooperate.getFdtime());
			ps.setInt(index++, cooperate.getTotaltime());
			ps.setInt(index++, cooperate.getOnlioncount());
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
	public Integer getCooperateCount() {
		Connection ct = getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
		String sql = " select count(id) from  cooperate ; ";
		try {
			ps = ct.prepareStatement(sql);
			st = ps.executeQuery();
			if (st.next()) {
				int count = st.getInt(1);
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release(ct, ps, st);
		}
		return null;
	}

	@Override
	public Cooperate getCooperateByName(Cooperate cooperate) {
		Connection ct = getConnection();
		PreparedStatement ps = null;
		String sql = " select * from cooperate where cooperate_name = ? ;";
		ResultSet st = null;
		try {
			ps = ct.prepareStatement(sql);
			ps.setObject(1, cooperate.getCooperate_name());
			st = ps.executeQuery();
			Cooperate c = null;
			while (st.next()) {
				c = new Cooperate();
				c.setId(st.getInt("id"));
				c.setCooperate_name(st.getString("cooperate_name"));
				c.setFdtime(st.getDouble("fdtime"));
				c.setOnlioncount(st.getInt("onlioncount"));
				c.setTotaltime(st.getInt("totaltime"));
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release(ct, ps, st);
		}
		return null;
	}

}
