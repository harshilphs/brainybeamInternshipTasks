package com.harshilphs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.harshilphs.dao.DBConnection;
import com.harshilphs.model.User;

public class RegisterDAO {
	public boolean registerUser(User user) throws Exception {
		String sql1 = "SELECT * FROM user where email=?";
		PreparedStatement st1 = DBConnection.getConnection().prepareStatement(sql1);
		st1.setString(1, user.getEmail());
		ResultSet rs = st1.executeQuery();
		if(rs.next()) {
			return false;
		} 		
		
		String sql = "insert into user(firstname,lastname,email,mobile,password) values(?,?,?,?,?)";
		PreparedStatement st = DBConnection.getConnection().prepareStatement(sql);
		st.setString(1, user.getFirstname());
		st.setString(2, user.getLastname());
		st.setString(3, user.getEmail());
		st.setString(4, user.getMobile());
		st.setString(5, user.getPassword());
		int success = st.executeUpdate(sql);		
		if(success>0) {
			return true;
		} else {
			return false;
		}
	}
}

