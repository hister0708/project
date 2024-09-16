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


@WebServlet("/MemProcess")
public class MemProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemProcess() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String str = request.getParameter("action");
		request.setCharacterEncoding("UTF-8");

		if (str != null && str.equals("select")) {
			MemDAO dao = new MemDAO();
			ArrayList<MemDTO> vec = new ArrayList<MemDTO>();
			vec = dao.getRecords(1, 100);
			request.setAttribute("data", vec);

			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/showinfo.jsp");
			dispatcher.forward(request, response);
		} else if (str.equals("insert")) {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String ID = request.getParameter("ID");
			String pwd = request.getParameter("pwd");
			String phone = request.getParameter("phone");
			String acount = request.getParameter("acount");

			MemDTO dto = new MemDTO();
			dto.setName(name);
			dto.setAge(age);
			dto.setID(ID);
			dto.setPwd(pwd);
			dto.setPhone(phone);
			dto.setAcount(acount);

			MemDAO dao = new MemDAO();
			boolean check = dao.registerMem(dto);
			PrintWriter out = response.getWriter();

			if (check) {
				out.println("<script>");
			    out.println("alert('환영합니다.');");
			    out.println("</script>");
			} else {
				out.println("<script>");
			    out.println("alert('회원가입에 실패했습니다.');");
			    out.println("</script>");
			    response.sendRedirect("join.jsp");
			}
		} else if (str.equals("phone_update")) {
			String pPhone = request.getParameter("p_phone");
			String chPhone = request.getParameter("ch_phone");

			MemDTO dto = new MemDTO();
			dto.setPhone(pPhone);
			dto.setChPhone(chPhone);

			MemDAO dao = new MemDAO();
			String result = dao.updatePhone(dto); // dto를 dao에 전달
			PrintWriter out = response.getWriter();
			if (result != null) {
				out.println("<script>");
			    out.println("alert('수정했습니다.');");
			    out.println("</script>");
			    response.sendRedirect("updateAccount.jsp");
			} else {
				out.println("<script>");
			    out.println("alert('수정에 실패하였습니다.');");
			    out.println("</script>");
			    response.sendRedirect("updateAccount.jsp");
			}
		} else if (str.equals("pwd_update")) {
			String pPwd = request.getParameter("p_pwd");
			String chPwd = request.getParameter("ch_pwd");

			MemDTO dto = new MemDTO();
			dto.setPwd(pPwd);
			dto.setChPwd(chPwd);

			MemDAO dao = new MemDAO();
			String result = dao.updatePhone(dto); // dto를 dao에 전달
			PrintWriter out = response.getWriter();
			if (result != null) {
				out.println("<script>");
			    out.println("alert('수정했습니다.');");
			    out.println("</script>");
			    response.sendRedirect("updateAccount.jsp");
			} else {
				out.println("<script>");
			    out.println("alert('수정에 실패하였습니다.');");
			    out.println("</script>");
			    response.sendRedirect("updateAccount.jsp");
			}
		} else if (str.equals("acount_update")) {
			String pAcount = request.getParameter("p_acount");
			String chAcount = request.getParameter("ch_acount");

			MemDTO dto = new MemDTO();
			dto.setPhone(pAcount);
			dto.setChPhone(chAcount);

			MemDAO dao = new MemDAO();
			String result = dao.updatePhone(dto); // dto를 dao에 전달
			PrintWriter out = response.getWriter();
			if (result != null) {
				out.println("<script>");
			    out.println("alert('수정했습니다.');");
			    out.println("</script>");
			    response.sendRedirect("updateAccount.jsp");
			} else {
				out.println("<script>");
			    out.println("alert('수정에 실패하였습니다.');");
			    out.println("</script>");
			    response.sendRedirect("updateAccount.jsp");
			}
		}
		else if (str.equals("delete")) {
			String id = request.getParameter("id");

			MemDTO dto = new MemDTO();
			dto.setID(id);

			MemDAO dao = new MemDAO();
			boolean bool = dao.deleteMem(dto); // dto를 dao에 전달
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			PrintWriter out = response.getWriter();
			if (bool) {
				out.println("<script>");
			    out.println("alert('탈퇴되었습니다.');");
			    out.println("</script>");
			} else {
				out.println("<script>");
			    out.println("alert('정보를 다시 확인해주세요.');");
			    out.println("</script>");
			    response.sendRedirect("derectingAccount.jsp");
			}
		}
	}
}
