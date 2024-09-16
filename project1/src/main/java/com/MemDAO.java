package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class MemDAO {
	public static Connection getConnection() {
		Connection conn = null;
		conn = DBConnection.getConnection();
		return conn;
	}

	public ArrayList<MemDTO> getRecords(int start, int total) {
		ArrayList<MemDTO> list = new ArrayList<MemDTO>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"select name, age, ID " + " from info order by name limit " + (start - 1) + "," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MemDTO e = new MemDTO();
				e.setName(rs.getString(1));
				e.setAge(rs.getInt(2));
				e.setID(rs.getString(3));
				list.add(e);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public ArrayList<MemDTO> getID(MemDTO dto) {
		ArrayList<MemDTO> list = new ArrayList<MemDTO>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select ID from info where name = ? ");
			ps.setString(1, dto.getName());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MemDTO e = new MemDTO();
					e.setID(rs.getString("ID"));
					list.add(e);
				}
				System.out.println(list);
				ps.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getPwd(MemDTO dto) {
		String pwd = "";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select pwd from info where id = ? and phone = ? ");
			ps.setString(1, dto.getID());
			ps.setString(2, dto.getPhone());

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					System.out.println(rs.getString("pwd"));
					pwd = rs.getString("pwd");
				}
				ps.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}

	public boolean registerMem(MemDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "insert into info(name, age, ID, pwd, phone, acount) values(?,?,?,?,?,?);";
		boolean success = false;

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getID());
			pstmt.setString(4, dto.getPwd());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getAcount());

			int result = pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			if (result > 0) {
				success = true;
			} else {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
			return true;
		} else {
			return false;
		}
	}

	public String updatePhone(MemDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "update info set phone = ? where phone = ?";
		String phone = "";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getChPhone());
			ps.setString(2, dto.getPhone());

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					phone = rs.getString("phone");
				}
				ps.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phone;
	}

	public String updatePwd(MemDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "update info set pwd = ? where pwd = ?";
		String phone = "";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getChPwd());
			ps.setString(2, dto.getPwd());

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					phone = rs.getString("pwd");
				}
				ps.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phone;
	}

	public String updateAcount(MemDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "update info set acount = ? where acount = ?";
		String phone = "";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getChAcount());
			ps.setString(2, dto.getAcount());

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					phone = rs.getString("acount");
				}
				ps.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phone;
	}

	public boolean deleteMem(MemDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "delete from info where ID = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getID());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean longinMem(MemDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = " select ID, pwd from info where ID = ? and pwd = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getID());
			ps.setString(2, dto.getPwd());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// 결과가 있으면 로그인 성공
				return true;
			} else {
				// 결과가 없으면 로그인 실패
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
