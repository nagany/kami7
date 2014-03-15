package com.zaipon.kami7.servlet;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaipon.kami7.business.MemberBusiness;
import com.zaipon.kami7.service.form.MemberForm;

/**
 * Servlet implementation class ButtleServlet
 */
@WebServlet("/ButtleServlet")
public class ButtleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBusiness business;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ButtleServlet() {
        super();
        this.business = new MemberBusiness();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		boolean login_flag = false;
		login_flag = (Boolean) session.getAttribute("login_flag");

		if(login_flag){
			HashSet<MemberForm> pair = this.business.getPair(1);

			ArrayList<MemberForm> list = new ArrayList<MemberForm>(pair);
			
			//対戦相手を選ぶ処理
			String nameA = list.get(0).getMemberName();
			String idA = list.get(0).getMemberId();
			String nameB = list.get(1).getMemberName();
			String idB = list.get(1).getMemberId();
			request.setAttribute("member_A", idA);
			request.setAttribute("member_B", idB);
			request.setAttribute("member_A_name", nameA);
			request.setAttribute("member_B_name", nameB);

			System.out.println("A, B");

			request.getRequestDispatcher("WEB-INF/buttle.jsp").forward(request, response);
			
		}else{
			request.getRequestDispatcher("login.html").forward(request, response);
		}

	}

}
