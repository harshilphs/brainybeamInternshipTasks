package com.harshilphs.dao;

import java.sql.Connection;
import java.sql.Statement;

public class FeedbackRegister {
	public boolean registerFeedback(int uid,int rate) throws Exception {
		
		String sql = "insert into feedback(user_id,rating) values("+uid+","+rate+")";
		Connection con = DBConnection.getConnection();
		
		Statement st = con.createStatement();

		int success = st.executeUpdate(sql);		
		if(success>0) {
			return true;
		} else {
			return false;
		}
	}
}
