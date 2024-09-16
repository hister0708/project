package res;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;


public class ResDAO {
	public static Connection getConnection(){
		Connection con=null;
		con = DBConnection.getConnection();
		return con;
	}
	public static ArrayList<ResDTO> getRecords(int start,int total){
		ArrayList<ResDTO> list = new ArrayList<ResDTO>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select Id, Seat, Moive, Price "
					+ "from res where Id = ?");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ResDTO e=new ResDTO();
				e.setId(rs.getString(1));
				System.out.println(rs.getString(1));
				e.setName(rs.getString(2));
				e.setSeat(rs.getString(3));
				e.setPrice(rs.getInt(4));
				list.add(e);
			}
			rs.close();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public boolean registerRes(ResDTO dto) throws ServletException{
		Connection conn = getConnection();
		String query = "insert into res(ID, Movie, Seat, Price) values (?, ?, ?, ?)";
		System.out.println(dto.getId());
		boolean success = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSeat());
			pstmt.setInt(4, dto.getPrice());
			int result = pstmt.executeUpdate();	// 업데이트 된 변화된 행수가 result가 된다
			pstmt.close();
			conn.close();
			if(result > 0) {
				success = true;
			}else {
				success = false;
			}
		}catch(SQLException ex) {
			success = false;
		}
		if(success == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteRes(ResDTO dto) throws ServletException{
		Connection conn = getConnection();
		String query = "delete from res where Id = ?";
		boolean success = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			int result = pstmt.executeUpdate();
			
			conn.close();
			if(result > 0) {
				success = true;
			}else {
				success = false;
			}
		}catch(SQLException ex){
			throw new ServletException("삭제 실패");
		}
		return true;
	}
	
}