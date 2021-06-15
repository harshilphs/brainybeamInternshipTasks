package com.harshilphs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.harshilphs.model.ComplaintData;

public class ComplainDAO {
	public boolean registerComplaint(ComplaintData com) throws Exception {
		Statement st = DBConnection.getConnection().createStatement();
		com.setStatus("pending");
		String sql = "insert into complaint(user_id,subject,description,address,status) values("+com.getUserId()+",'"+com.getSub()
		+"','"+com.getDesc()+"','"+com.getAddress()+"','"+com.getStatus()+"')";
		int success = st.executeUpdate(sql);		
		if(success>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateComplaint(ComplaintData com) throws Exception {
		Statement st = DBConnection.getConnection().createStatement();
		com.setStatus("pending");
		String sql = "update complaint set subject='"+com.getSub()
		+"',description='"+com.getDesc()+"',address='"+com.getAddress()+"',status='"+com.getStatus()+"' where id = "+ com.getId();
		int success = st.executeUpdate(sql);		
		if(success>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteComplaint(int id) throws Exception {
		Statement st = DBConnection.getConnection().createStatement();
		String sql = "delete from complaint where id="+id;
		int success = st.executeUpdate(sql);		
		if(success>0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public List<ComplaintData> getAllComplaintByUserId(int userId) throws ClassNotFoundException, SQLException{
		Statement st = DBConnection.getConnection().createStatement();
		String sql = "select * from complaint where user_id="+userId;
		ResultSet res = st.executeQuery(sql);
		List<ComplaintData> data = getComplaintListByResultSet(res);
		return data;
	}
	
	public List<ComplaintData> getAllComplaint() throws ClassNotFoundException, SQLException{
		Statement st = DBConnection.getConnection().createStatement();
		String sql = "select * from complaint ORDER BY timestamp(datetime) DESC";
		ResultSet res = st.executeQuery(sql);
		List<ComplaintData> data = getComplaintListByResultSet(res);
		return data;
	}
	
	public List<ComplaintData> getComplaintById(int id) throws ClassNotFoundException, SQLException{
		Statement st = DBConnection.getConnection().createStatement();
		String sql = "select * from complaint where id="+id;
		ResultSet res = st.executeQuery(sql);
		List<ComplaintData> data = getComplaintListByResultSet(res);
		return data;
	}
	
	
	private List<ComplaintData> getComplaintListByResultSet(ResultSet resData) throws SQLException{
		List<ComplaintData> complaintList = new ArrayList<ComplaintData>();
		while(resData.next()) {
			ComplaintData data = getComplaintObjectByResultset(resData);
			complaintList.add(data);
		}
		return complaintList;
	}
	
	
	private ComplaintData getComplaintObjectByResultset(ResultSet resData) throws SQLException {
		ComplaintData ob = new ComplaintData();
		ob.setId(resData.getInt("id"));
		ob.setUserId(resData.getInt("user_id"));
		ob.setSub(resData.getString("subject"));
		ob.setDesc(resData.getString("description"));
		ob.setAddress(resData.getString("address"));
		ob.setStatus(resData.getString("status"));
		ob.setDatetime(resData.getTimestamp("datetime"));
		return ob;	
	}
}
