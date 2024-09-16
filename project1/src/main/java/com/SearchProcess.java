package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchProcess")
public class SearchProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchProcess() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String str = request.getParameter("action");
		request.setCharacterEncoding("UTF-8");

		if (str.equals("searchID")) {
			String name = request.getParameter("name");

			MemDTO dto = new MemDTO();
			dto.setName(name); // 이름을 설정해야 함

			MemDAO dao = new MemDAO();
			ArrayList<MemDTO> list = dao.getID(dto); // ArrayList를 반환받아야 함
			PrintWriter out = response.getWriter();

			if (!list.isEmpty()) {
				MemDTO resultDTO = list.get(0); // 첫 번째 MemDTO 객체만 사용, 어차피 반환받은 값은 list지만 하나의 ID값만 가지고 있기 때문에.
				String id = resultDTO.getID(); // MemDTO 객체의 ID 가져오기
				out.print(name + "님의 아이디는 " + id + "입니다."); // 결과 출력
			} else {
				out.println("<script>");
			    out.println("alert('없는 회원입니다.');");
			    out.println("</script>");
			    response.sendRedirect("searchID.html");
			}
		} else if (str.equals("searchPwd")) {
			String ID = request.getParameter("id");
			String phone = request.getParameter("phone");

			MemDTO dto = new MemDTO();
			dto.setID(ID);
			dto.setPhone(phone);

			MemDAO dao = new MemDAO();
			String pwd = dao.getPwd(dto);
			PrintWriter out = response.getWriter();

			if (!pwd.isEmpty()) {
				out.print(ID + "님의 비밀번호는 " + pwd + "입니다.");
			} else {
				out.println("<script>");
			    out.println("alert('없는 회원입니다.');");
			    out.println("</script>");
			    response.sendRedirect("searchPwd.html");
			}
		}else if(str.equals("login")) {
			String ID = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			HttpSession session = request.getSession();
			session.setAttribute("userID", ID); // id를 다른 페이지에서도 사용할 수 있게 세션에 저장함.
			
			MemDTO dto = new MemDTO();
			dto.setID(ID);
			dto.setPwd(pwd);
			
			MemDAO dao = new MemDAO();
			
			PrintWriter out = response.getWriter();
			
			if(dao.longinMem(dto) == true) {
				out.println("<script>");
			    out.println("alert('로그인하였습니다.');");
			    out.println("</script>");
			    response.sendRedirect("./login.jsp");
			}else {
				out.println("<script>");
			    out.println("alert('ID나 비밀번호가 다릅니다. 다시 시도해주세요.');");
			    out.println("</script>");
			    response.sendRedirect("info.jsp");
			}
		}else if(str.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
		    out.println("alert('로그아웃되었습니다.');");
		    out.println("</script>");
		    response.sendRedirect("./info.jsp");
		}
	}
}