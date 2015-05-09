package com.zaipon.kami7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaipon.kami7.business.MemberBusiness;

/**
 * Servlet implementation class RateRegistServlet
 */
@WebServlet("/RateRegistServlet")
public class RateRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberBusiness business;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateRegistServlet() {
        super();
        this.business = new MemberBusiness();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		boolean login_flag = false;
		
		try {
			login_flag = (Boolean) session.getAttribute("login_flag");
			if(login_flag){
				//ログインしている場合
				String memberId = request.getParameter("member_id");
				String categoryId = request.getParameter("category_id");
				this.business.insertRate(memberId,categoryId);

				String url = "/MemberServlet";
			    response.sendRedirect(url);
			}else{
				request.getRequestDispatcher("login.html").forward(request, response);
			}
			
		} catch (NullPointerException e) {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
