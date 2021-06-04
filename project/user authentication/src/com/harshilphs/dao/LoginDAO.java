package com.harshilphs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.harshilphs.model.User;

public class LoginDAO {
	public boolean loginUser(User user) throws Exception {
		String sql = "SELECT * FROM user where email=? and password=?";
		PreparedStatement st = DBConnection.getConnection().prepareStatement(sql);		
		st.setString(1, user.getEmail());
		st.setString(2, user.getPassword());


		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
}
