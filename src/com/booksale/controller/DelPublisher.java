package com.booksale.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booksale.module.UserBeanDeal;

/**
 * Servlet implementation class DelUser
 */
@WebServlet("/DelPublisher")

public class DelPublisher extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("gb2312");
		request.setCharacterEncoding("gb2312");
		UserBeanDeal ubd = new UserBeanDeal();
		if(ubd.delPublisher(request.getParameter("id"))) {
			response.sendRedirect("DealSuccess.jsp");
		} else {
			response.sendRedirect("DealFailed.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
