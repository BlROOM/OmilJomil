package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeUpdateForm
 */
@WebServlet("/noticeUpdate.me")
public class NoticeUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int noticeNo=Integer.parseInt(request.getParameter("no"));
		 String noticeTitle=request.getParameter("title");
		 String noticeContent=request.getParameter("content");
		 String noticeWriter=request.getParameter("writer");
		 String noticeDate=request.getParameter("date");
		 
		 
		 request.setAttribute("no", noticeNo);
		 request.setAttribute("title", noticeTitle);
		 request.setAttribute("content", noticeContent);
		 request.setAttribute("writer", noticeWriter);
		 request.setAttribute("date", noticeDate);
		
		request.getRequestDispatcher("WEB-INF/views/notice/noticeUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
