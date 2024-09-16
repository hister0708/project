package ct3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import ct.CTDTO;



public class CT3DAO {
	public static Connection getConnection(){
		Connection con=null;
		// con = new DbcpBean().getConn();
		con = DBConnection.getConnection();
		return con;
	}
	public ArrayList<CT3DTO> getRecords3(String ID) {
		ArrayList<CT3DTO> list = new ArrayList<CT3DTO>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select Id, Seat, Movie, Price from ct3 where Id = ?");
			ps.setString(1,ID);
			System.out.println("실행됨");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CT3DTO e = new CT3DTO();
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

	public boolean updateCT3(CT3DTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "update ct3 set ID = ? where seat = ?";
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