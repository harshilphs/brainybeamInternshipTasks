package com.harshilphs.dao;

import java.sql.Statement;

import com.harshilphs.model.User;

public class editProfileDAO {
	public boolean updateProfile(User user) throws Exception {
		Statement st = DBConnection.getConnection().createStatement();
		String sql = "update user set firstname='"+user.getFirstname()
		+"',lastname='"+user.getLastname()+"',email='"+user.getEmail()+"',mobile='"+user.getMobile()+"',password='"+user.getPassword()+"' where id = "
				+ user.getId();
		int success = st.executeUpdate(sql);		
		if(success>0) {
			return true;
		} else {
			return false;
		}
	}
}
