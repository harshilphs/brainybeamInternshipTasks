package com.harshilphs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.harshilphs.model.User;

public class LoginDAO {
	public boolean loginUser(User user,HttpServletRequest req) throws Exception {
		String sql = "SELECT * FROM user where email=? and password=?";
		PreparedStatement st = DBConnection.getConnection().prepareStatement(sql);		
		st.setString(1, user.getEmail());
		st.setString(2, user.getPassword());

		User sessionUser = new User();
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			sessionUser.setId(rs.getInt("id"));
			sessionUser.setFirstname(rs.getString("firstname"));
			sessionUser.setLastname(rs.getString("lastname"));
			sessionUser.setEmail(rs.getString("email"));
			sessionUser.setMobile(rs.getString("mobile"));
			sessionUser.setPassword(rs.getString("password"));
			HttpSession session = req.getSession();
			session.setAttribute("user", sessionUser);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean findUser(String email) throws Exception {
		String sql = "SELECT * FROM user where email=?";
		PreparedStatement st = DBConnection.getConnection().prepareStatement(sql);		
		st.setString(1, email);


		ResultSet rs = st.executeQuery();
		if(rs.next()) {

			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateUserPassword(String email,String password) throws Exception {
		String sql = "update user set password = ? where email = ?";
		PreparedStatement st = DBConnection.getConnection().prepareStatement(sql);		
		st.setString(1, password);
		st.setString(2, email);


		int rs = st.executeUpdate();
		if(rs>0) {
			return true;
		} else {
			return false;
		}
	}
}
