package com.lovi.java.ex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovi.java.ex.common.ErrorMessages;

@WebServlet("/")
public class IndexController extends HttpServlet{
	
	private static final long serialVersionUID = -1538368851464512295L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("loggedUserId") == null ){
			
			if(request.getParameter("error") != null)
				request.setAttribute("errorMessage", ErrorMessages.SIGN_IN_FAIL.getMessage());
			
			request.setAttribute("title", "java-ex");
			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		else
			getServletContext().getRequestDispatcher("/WEB-INF/user-pages/list.jsp").forward(request, response);
		
		
	}
}
