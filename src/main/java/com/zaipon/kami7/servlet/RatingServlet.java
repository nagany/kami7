package com.zaipon.kami7.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaipon.kami7.business.MemberBusiness;
import com.zaipon.kami7.dao.MemberDao;
import com.zaipon.kami7.dao.RateDao;
import com.zaipon.kami7.dto.RateDto;
import com.zaipon.kami7.service.command.MatchResultCommand;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RateDao rateDao;
    private MemberBusiness business;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingServlet() {
        super();
        rateDao = new RateDao();
        this.business = new MemberBusiness();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		boolean login_flag = false;
		login_flag = (Boolean) session.getAttribute("login_flag");
		
		if(login_flag){
			//ログインしている場合
			request.getRequestDispatcher("WEB-INF/entryRegist.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
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
			//ログインしている場合
			
			String id_win = request.getParameter("id_win");
			id_win = id_win.substring(0,id_win.length()-1);
			String id_lose = request.getParameter("id_lose");
			id_lose = id_lose.substring(0,id_lose.length()-1);
			
			MatchResultCommand command = new MatchResultCommand();
			command.setCategoryId(1);
			command.setWinnerId(Integer.parseInt(id_win));
			command.setLoserId(Integer.parseInt(id_lose));
			this.business.updateRate(command);
			//レート処理
			
			System.out.println("レーティング");
			
			request.getRequestDispatcher("ButtleServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		
	}

}
