package com.wintech.datacenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wintech.datacenter.pojo.Individual;
import com.wintech.datacenter.util.JDBCPoolUtil;

public class IndividualDaoImpl extends JDBCPoolUtil implements IndividualDao {

	@Override
	public Integer addIndividual(Individual individual) {
		Connection ct = getConnection();
		PreparedStatement ps = null;
		ResultSet st = null;
		String sql = " insert into individual (group_id,group_name,indi_v,indi_tem) values (?,?,?,?) ;";
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + sql);
		try {
			ps = ct.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			ps.setInt(index++, individual.getGroup_id());
			ps.setString(index++, individual.getGroup_name());
			ps.setDouble(index++, individual.getIndi_v());
			ps.setDouble(index++, individual.getIndi_tem());
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

}
