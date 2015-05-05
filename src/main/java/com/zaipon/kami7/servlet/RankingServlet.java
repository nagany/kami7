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
 * Servlet implementation class RankingServlet
 */
@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberBusiness business;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankingServlet() {
        super();
        this.business = new MemberBusiness();
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

				//上位7人の名前を取得
				String[] rank = this.business.getKami7();

				request.setAttribute("rank", rank);

				request.getRequestDispatcher("WEB-INF/ranking.jsp").forward(request, response);
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
		this.doGet(request, response);
	}
}
