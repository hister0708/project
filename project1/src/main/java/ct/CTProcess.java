package ct;

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

@WebServlet("/CTProcess")
public class CTProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CTProcess() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String str = request.getParameter("action");
		String str2 = request.getParameter("action_select");
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		String ID = (String)session.getAttribute("userID");
		
		if(str2.equals("select")) {
			CTDAO dao = new CTDAO();
			ArrayList<CTDTO> vec = new ArrayList<CTDTO>();
			vec = dao.getRecords(ID);
			request.setAttribute("data1", vec);
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/payment.jsp");
			dispatcher.forward(request, response);
			request.setAttribute("data1", null);
		}
		if(str.equals("update")) {
			String seat = request.getParameter("seat");
			
			CTDTO dto = new CTDTO();
			dto.setId(ID);
			dto.setSeat(seat);
			
			CTDAO dao = new CTDAO();
			boolean check = dao.updateCT(dto);
			PrintWriter out = response.getWriter();
			if(check) {
				response.sendRedirect("payment.jsp");
			}else {
				out.println("<script>");
			    out.println("alert('예매 실패하였습니다.');");
			    out.println("</script>");
			    response.sendRedirect("sub2.jsp");
			}
		}
	}
	
}