package ct3;

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

import ct.CTDAO;
import ct.CTDTO;

@WebServlet("/CT3Process")
public class CT3Process extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CT3Process() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String str = request.getParameter("action");
		String str2 = request.getParameter("action_select");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String ID = (String) session.getAttribute("userID");

		if (str2.equals("select")) {
			CT3DAO dao = new CT3DAO();
			ArrayList<CT3DTO> vec = new ArrayList<CT3DTO>();
			vec = dao.getRecords3(ID);
			request.setAttribute("data3", vec);
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/payment3.jsp");
			dispatcher.forward(request, response);
		}
		if (str.equals("update")) {
			String seat = request.getParameter("seat");

			CT3DTO dto = new CT3DTO();
			dto.setId(ID);
			dto.setSeat(seat);

			CT3DAO dao = new CT3DAO();
			boolean check = dao.updateCT3(dto);
			PrintWriter out = response.getWriter();
			if (check) {
				response.sendRedirect("payment3.jsp");
			} else {
				out.println("<script>");
				out.println("alert('예매 실패하였습니다.');");
				out.println("</script>");
				response.sendRedirect("sub3.jsp");
			}

		}
	}
}
