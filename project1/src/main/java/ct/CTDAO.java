package ct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class CTDAO {
	public static Connection getConnection() {
		Connection conn = null;
		// con = new DbcpBean().getConn();
		conn = DBConnection.getConnection();
		return conn;
	}

	public ArrayList<CTDTO> getRecords(String ID) {
		ArrayList<CTDTO> list = new ArrayList<CTDTO>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select Id, Seat, Movie, Price from ct where Id = ?");
			ps.setString(1,ID);
			System.out.println("실행됨");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CTDTO e = new CTDTO();
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

	public boolean updateCT(CTDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "update ct set ID = ? where seat = ?";
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