package com.wintech.datacenter.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCPoolUtil {
	private static DataSource ds;

	public static DataSource getDs() {
		return ds;
	}

	static {
		Properties p = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream("resource/jdbcpool.properties");
			p.load(in);
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void release(Connection ct, Statement ps, ResultSet st) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ct != null) {
			try {
				ct.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static Statement getStatement(Connection connection) {
		try {
			Statement statement = connection.createStatement();
			return statement;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static void close(Connection connection, Statement statement, PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 通用的增删改方法
	public <T> Integer cud(Class<T> clazz, String sql, Object... args) {
		Connection ct = getConnection();
		PreparedStatement ps = null;
		try {
			ps = ct.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject((i + 1), args[i]);
			}
			int i = ps.executeUpdate();
			ct.commit();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			release(ct, ps, null);
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
