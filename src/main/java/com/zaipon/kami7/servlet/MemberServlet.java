package com.zaipon.kami7.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaipon.kami7.business.MemberBusiness;
import com.zaipon.kami7.dto.MemberDto;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBusiness business;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        this.business = new MemberBusiness();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		boolean login_flag = false;
		
		try {
			login_flag = (Boolean) session.getAttribute("login_flag");
			if(login_flag){
				//ログインしている場合

				ArrayList<MemberDto> memberList = this.business.getAllMember();
				request.setAttribute("memberList", memberList);

				request.getRequestDispatcher("WEB-INF/members.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("login.html").forward(request, response);
			}
			
		} catch (NullPointerException e) {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
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
				this.business.insertMember((String) session.getAttribute("member_name"));

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
