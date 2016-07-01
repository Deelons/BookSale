package com.booksale.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booksale.module.UserBeanDeal;

/**
 * Servlet implementation class UpdatePublisher
 */
@WebServlet("/UpdatePublisher")
public class UpdatePublisher extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("gb2312");
		request.setCharacterEncoding("gb2312");
		UserBeanDeal ubd = new UserBeanDeal();
		String id1 = request.getParameter("id1");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String zipcode = request.getParameter("zipcode");
		String website = request.getParameter("website");
		String city = request.getParameter("city");
		String addr = request.getParameter("addr");
		
		boolean state = ubd.updatePublisher(id1,id, name, phone, zipcode, website, city, addr);
		if(state) {
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
		this.doGet(request, response);
	}

}
