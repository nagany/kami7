package com.zaipon.kami7.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingServlet() {
        super();
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
			//ログインしている場合
			
			String id_win = request.getParameter("id_win");
			String id_lose = request.getParameter("id_lose");
			
			//レート処理
			
			request.setAttribute("member_A", "xさんのID");
			request.setAttribute("member_B", "yさんのID");
			
			System.out.println("レーティング");
			
			request.getRequestDispatcher("ButtleServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		
	}

}
