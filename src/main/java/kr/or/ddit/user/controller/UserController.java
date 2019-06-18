package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request 객체로부터 사용자아이디 파라미터 획득
		String userId = request.getParameter("userId");
		
		// 사용자 아이디로 사용자 정보를 조회
		 UserVo userVo = userService.getUser(userId);
		
		//조회 결과를 request객체에 속성으로 저장
		 request.setAttribute("userVo", userVo);
		
		//화면을 담당하는 /user/user.jsp로 forward
		 RequestDispatcher rd = request.getRequestDispatcher("/user/user.jsp");
		 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
