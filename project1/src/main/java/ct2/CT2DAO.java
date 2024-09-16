package ct2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import ct.CTDTO;

public class CT2DAO {
	public static Connection getConnection(){
		Connection con=null;
		// con = new DbcpBean().getConn();
		con = DBConnection.getConnection();
		return con;
	}
	public ArrayList<CT2DTO> getRecords2(String ID) {
		ArrayList<CT2DTO> list = new ArrayList<CT2DTO>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select Id, Seat, Movie, Price from ct2 where Id = ?");
			ps.setString(1,ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CT2DTO e = new CT2DTO();
				e.setId(rs.getString(1));
				System.out.println(rs.getString(1));
				e.setSeat(rs.getString(2));
				e.setMovie(rs.getString(3));
				e.setPrice(rs.getInt(4));
				list.add(e);
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(list);
		return list;
	}
	
	public boolean registerCT(CT2DTO dto) throws ServletException{
		Connection conn = getConnection();
		String query = "insert into ct2(ID, Movie, Seat, Price) values (?, ?, ?, ?)";
		System.out.println(dto.getId());
		boolean success = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  dto.getId());
			pstmt.setString(2, dto.getMovie());
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
	
	public boolean updateCT2(CT2DTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "update ct2 set ID = ? where seat = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getSeat());

			result = ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

	
}