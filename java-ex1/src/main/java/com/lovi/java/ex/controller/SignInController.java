package com.lovi.java.ex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lovi.java.ex.model.User;
import com.lovi.java.ex.service.UserService;
import com.lovi.java.ex.service.UserServiceImpl;

@WebServlet("/signIn")
public class SignInController extends HttpServlet{

	private static final long serialVersionUID = -2303088245788809504L;

	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		User foundUser = userService.findUserByUserIdAndPassword(userId, password);
		if(foundUser != null){
			request.getSession().setAttribute("loggedUserId", foundUser.getUserId());
			request.getSession().setAttribute("loggedUserName", foundUser.getName());
			response.sendRedirect("");
		}else{
			response.sendRedirect("?error=signIn_Fail");
		}
		
		
	}
}
