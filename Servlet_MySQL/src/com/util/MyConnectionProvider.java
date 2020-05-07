package com.util;

import com.dao.*;

import com.entity.User;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import com.sun.istack.internal.logging.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyConnectionProvider {

	public static PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement stmt = null;
		try {
			// register mySQl driver
			Class.forName("com.mysql.jdbc.Driver");
			// get connection to database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
			// get prepared statement
			stmt = connection.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return prepared statement
		return stmt;
	}

}
