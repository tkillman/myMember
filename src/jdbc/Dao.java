package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	Connection connection=null;
	PreparedStatement pstmt = null;
	ResultSet resultSet =null;
	
	static Dao dao= new Dao();
	
	//»ý¼ºÀÚ
	private Dao() {
		try {
			String url = "jdbc:apache:commons:dbcp:pool"; 
			String uid = "cc";
			String upw = "1234";
			connection = DriverManager.getConnection(url,uid,upw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//½Ì±ÛÅÏÆÐÅÏ
	public static Dao getInstance(){
		return dao;
		
	}
	
	//¸â¹ö »ðÀÔ
	public int insertMember(Dto dto){
		int resultNum =-1;
		
		try {
			String sql = "insert into members(id,passwd,name,jumin1,jumin2,email,blog,reg_date,zipcode,address) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getJumin1());
			pstmt.setString(5, dto.getJumin2());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getBlog());
			pstmt.setTimestamp(8, dto.getReg_date());
			pstmt.setString(9, dto.getZipcode());
			pstmt.setString(10, dto.getAddress());
			resultNum = pstmt.executeUpdate();
			
			return resultNum;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultNum;
		} 
	}
	
	public Dto login(String id, String passwd){
		Dto dto = new Dto();
		
		try {
			String sql = "select id from members where id=? and passwd=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()){
				dto.setId(id);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
		
	}
	
	
	
	
	
	
	
}
