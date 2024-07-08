package frontproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frontproject.vo.SampleTBlistVO;
import frontproject.vo.SampleTBviewVO;

public class SampleTBDAO {
	private final String url = "jdbc:mysql://localhost:3306/javaspringclass";
	private final String user = "javaspring";
	private final String password = "ezen";
	
	public List<SampleTBlistVO> selectList(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from sampleTB";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			List<SampleTBlistVO> slist = new ArrayList<SampleTBlistVO>();
			while(rs.next()) {
				SampleTBlistVO svo = new SampleTBlistVO();
				svo.setSno(rs.getInt("sno"));
				svo.setTitle(rs.getString("title"));
				svo.setWriter(rs.getString("writer"));
				svo.setRdate(rs.getString("rdate"));
				svo.setBody(rs.getString("body"));
				slist.add(svo);
			}
			
			return slist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public SampleTBviewVO selectSno(int sno){
		String url = "jdbc:mysql://localhost:3306/javaspringclass";
		String user = "javaspring";
		String password = "ezen";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from sampleTB where sno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sno);
			rs = psmt.executeQuery();
			
			SampleTBviewVO svo = null;
			if(rs.next()) {
				svo = new SampleTBviewVO();
				svo.setSno(rs.getInt("sno"));
				svo.setTitle(rs.getString("title"));
				svo.setWriter(rs.getString("writer"));
				svo.setRdate(rs.getString("rdate"));
				svo.setBody(rs.getString("body"));
			}
			return svo;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public int modify(String title, String writer, String body, int sno) {
		
		String url = "jdbc:mysql://localhost:3306/javaspringclass";
		String user = "javaspring";
		String password = "ezen";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "update sampleTB set title = ?, writer = ?, body = ? where sno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, writer);
			psmt.setString(3, body);
			psmt.setInt(4, sno);
			int result = psmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int write(String title, String writer, String body) {
		String url = "jdbc:mysql://localhost:3306/javaspringclass";
		String user = "javaspring";
		String password = "ezen";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "insert into sampleTB(title, writer, rdate, body)";
			sql += " values(?, ?, now(), ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, writer);
			psmt.setString(3, body);
			int result = psmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
