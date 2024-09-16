package res;

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


@WebServlet("/ResProcess")
public class ResProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResProcess() {
        super();
    }
    // get 방식 -> CRUD
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("action"); // 클라이언트에서 요청할때 ,hidden
		request.setCharacterEncoding("UTF-8");
		if(str.equals("select")) {
			ResDAO dao = new ResDAO();	// 요것이(1번)
			ArrayList<ResDTO> vec = new ArrayList<ResDTO>(); // 요것을 리턴(2번)
			vec = dao.getRecords(1, 5);
			request.setAttribute("data1", vec);		// request에 데이터 추가 (요걸 하려고(4번))
			// MVC로 작업
			ServletContext context = this.getServletContext(); // 라고 요놈한테 말함(3번)
			RequestDispatcher dispatcher = context.getRequestDispatcher("/sub_rev.jsp"); // 요 페이지로 보내라(2번)
			dispatcher.forward(request, response); // 실제 전달하는 행위 요것들을 가지고(1번)
		}else if(str.equals("insert")) {
			String id = request.getParameter("id");
			String name = request.getParameter("movie");
			String seat = request.getParameter("seat");
			int price = Integer.parseInt(request.getParameter("price"));
			
			ResDTO dto = new ResDTO();
			dto.setId(id);
			dto.setName(name);
			dto.setSeat(seat);
			dto.setPrice(price);
			
			ResDAO dao = new ResDAO();
			boolean bool = dao.registerRes(dto);
			PrintWriter out = response.getWriter();
			if(bool) {
				response.sendRedirect("./sub.html");
			}else {
				out.println("입력에 실패하였습니다.");
				out.println("<a href = 'sub.html'> 메뉴로 돌아가기 </a>");
			}
			
		}else if(str.equals("delete")) {
			ResDAO dao = new ResDAO();
			String id = request.getParameter("id");
			
			ResDTO dto = new ResDTO();
			dto.setName(id);
			boolean bool = dao.deleteRes(dto);
			PrintWriter out = response.getWriter();
			if(bool) {
				response.sendRedirect("sub.html");
			}else {
				response.sendRedirect("sub.html");
			}
		}else {
			response.sendRedirect("sub.html");
		}
	}
	
}