package com.wintech.datacenter.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static String url;
	private static String userName;
	private static String passWord;
	private static String driver;

	// 1.加载驱动com.mysql.jdbc.Driver,com.mysql.cj.jdbc.Driver(8.0)
	static {
		// 读取配置文件获得属性值
		Properties p = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream("resource/jdbc.properties");
			p.load(in);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			userName = p.getProperty("userName");
			passWord = p.getProperty("passWord");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 打开连接开启事务
	public static Connection getConnection() {
		try {
			Connection ct = DriverManager.getConnection(url, userName, passWord);
			ct.setAutoCommit(false);
			return ct;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 关闭资源
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

}
