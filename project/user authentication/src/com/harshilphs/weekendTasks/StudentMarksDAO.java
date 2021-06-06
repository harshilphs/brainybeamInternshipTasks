package com.harshilphs.weekendTasks;

import java.sql.Statement;
import com.harshilphs.dao.DBConnection;


public class StudentMarksDAO {
	public boolean registerStudentMarks(StudentMarks stm) throws Exception {
				
		Statement st = DBConnection.getConnection().createStatement();
		String sql = "insert into stmarks(name,phy,che,maths,ss,eng,hindi,computer) values('"+stm.getName()+"',"+stm.getPhysics()+","+stm.getChemistry()+","+stm.getMaths()+","+stm.getSocialScience()+","+
		stm.getEnglish()+","+stm.getHindi()+","+stm.getComputer()+")";
		int success = st.executeUpdate(sql);		
		if(success>0) {
			return true;
		} else {
			return false;
		}
	}
}
