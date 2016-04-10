package com.lovi.java.ex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import com.lovi.java.ex.common.ErrorMessages;
import com.lovi.java.ex.common.ResponseMessage;
import com.lovi.java.ex.model.User;
import com.lovi.java.ex.service.UserService;
import com.lovi.java.ex.service.UserServiceImpl;

@WebServlet("/users/*")
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1052555025367164157L;
	
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//requested url path
        String requestPath = extractRequestPath(request);
        
        //list all users
        if(requestPath.equals(""))
        	prepareResponse(response,200,new ResponseMessage(1, userService.listUsers()));
        
        //findUserByUserId
        else{
        	User user = userService.findUserByUserId(requestPath);
        	if(user != null)
        		prepareResponse(response,200,new ResponseMessage(1, user));
        	else
        		prepareResponse(response,404,new ResponseMessage(-1, ErrorMessages.UNABLE_TO_FOUND_USER.getMessage()));
        }
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//requested url path
        String requestPath = extractRequestPath(request);
        
        if(!requestPath.equals(""))
        	prepareResponse(response,404,new ResponseMessage(-1, ErrorMessages.UNABLE_TO_FOUND_RESOURSES.getMessage()));
        
        //create user
        else{
        	try{
        		String userId = request.getParameter("userId");
            	String password = request.getParameter("password");
            	String name = request.getParameter("name");
            	Integer age = Integer.parseInt(request.getParameter("age"));
        		
        		if(userService.create(userId, password, name, age))
            		prepareResponse(response,201,new ResponseMessage(1, userService.findUserByUserId(userId)));
            	else
            		prepareResponse(response,500,new ResponseMessage(-1, ErrorMessages.USER_CREATE_FAIL.getMessage()));
        		
        	}catch(NumberFormatException numberFormatException){
        		prepareResponse(response,400,new ResponseMessage(-1, ErrorMessages.INPUT_PARM_PARSE_ERROR.getMessage()));
        	}
        	
        }
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//requested url path
        String requestPath = extractRequestPath(request);
        
        if(!requestPath.equals(""))
        	prepareResponse(response,404,new ResponseMessage(-1, ErrorMessages.UNABLE_TO_FOUND_RESOURSES.getMessage()));
        
        //create user
        else{
        	try{
        		String userId = request.getParameter("userId");
            	String password = request.getParameter("password");
            	String name = request.getParameter("name");
            	Integer age = Integer.parseInt(request.getParameter("age"));
        		
        		if(userService.update(userId, password, name, age))
            		prepareResponse(response,201,new ResponseMessage(1, userService.findUserByUserId(userId)));
            	else
            		prepareResponse(response,500,new ResponseMessage(-1, ErrorMessages.USER_UPDATE_FAIL.getMessage()));
        		
        	}catch(NumberFormatException numberFormatException){
        		prepareResponse(response,400,new ResponseMessage(-1, ErrorMessages.INPUT_PARM_PARSE_ERROR.getMessage()));
        	}
        	
        }
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/**
     * extractRequestPath
     *
     * @param request
     * @return
     */
    private String extractRequestPath(HttpServletRequest request) {

        try {
            String pathInfo = request.getPathInfo(); // /user/{q} pathInfo => /{q}
            if (pathInfo.length() >= 2) {
                return pathInfo.split("/")[1];
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }

    }
    
    private void prepareResponse(HttpServletResponse response,int responseStatus,ResponseMessage responseMessage) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	response.setStatus(responseStatus);
        response.setContentType("application/json");
        response.getOutputStream().println(objectMapper.writeValueAsString(responseMessage));
    }

	
}
