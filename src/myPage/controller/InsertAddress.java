package myPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.model.service.ShppingService;
import User.model.vo.Shpping;

/**
 * Servlet implementation class InsertAddress
 */
@WebServlet("/insertAddress.me")
public class InsertAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String alias = request.getParameter("alias");
		String recipient = request.getParameter("recipient");
		int postal = Integer.parseInt(request.getParameter("postal"));
		String address = request.getParameter("address");
		String de_address = request.getParameter("de_address");
		String sp_Phone = request.getParameter("sp_Phone");
		
		if(de_address == "") {
			de_address="-";
		}

		String basics = request.getParameter("basics");
		String userId = request.getParameter("userId");
		
		if(basics.equals("Y")) {
			int bNum = new ShppingService().selectBasicsShpping(userId);
			System.out.println(bNum);
			if(bNum >0) {
				int deleteB = new ShppingService().deleteBasicsShpping(bNum);
				System.out.println(deleteB);
				if(deleteB > 0) {
					System.out.println("기존 basics 'n' 변경");
				}else {
					request.setAttribute("msg", "주소지 등록에 실패하였습니다");
					request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
				}
			}
		}
		
		Shpping sp = new Shpping(0, userId, postal, address, de_address, alias,basics ,recipient,sp_Phone);
		int result = new ShppingService().insertShpping(sp);
		
		if(result > 0) {
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
		}else {
			request.setAttribute("msg", "배송지 등록에 실패하였습니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
