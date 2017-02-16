package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("################");
		System.out.println("GET");
		System.out.println("################");
		
		/*
		 * get할 때는 forword 사용해도 됨
		 */
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/loginform.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("################");
		System.out.println("POST");
		System.out.println("################");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		System.out.println("id = " + id + ", pw = " + pw);
		/*
		 * Login 처리 (post-redirect를 사용해야함)
		 * 
		 * forword로 한다면 get으로 refresh가 아니라 계속 post로 됨
		 * 그럴경우 두가지 문제점 발생 
		 * 1.url
		 * 2.F5를 할 경우 post로 (은행 이체 업무경우 큰 문제)
		 * 
		 */
		
		resp.sendRedirect("/index.jsp");
	}
}
