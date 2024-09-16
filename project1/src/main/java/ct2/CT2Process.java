package ct2;

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

@WebServlet("/CT2Process")
public class CT2Process extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CT2Process() {
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
			CT2DAO dao = new CT2DAO();
			ArrayList<CT2DTO> vec = new ArrayList<CT2DTO>();
			vec = dao.getRecords2(ID);
			request.setAttribute("data2", vec);
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/payment2.jsp");
			dispatcher.forward(request, response);
		}
		if (str.equals("update")) {
			String seat = request.getParameter("seat");

			CT2DTO dto = new CT2DTO();
			dto.setId(ID);
			dto.setSeat(seat);

			CT2DAO dao = new CT2DAO();
			boolean check = dao.updateCT2(dto);
			PrintWriter out = response.getWriter();
			if (check) {
				response.sendRedirect("payment2.jsp");
			} else {
				out.println("<script>");
				out.println("alert('예매 실패하였습니다.');");
				out.println("</script>");
				response.sendRedirect("sub2.jsp");
			}

		}
	}
}