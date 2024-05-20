package com.targetindia.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-greeting-message")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		var writer = response.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset=\"UTF-8\">");
		writer.println("<title>my first webapp</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>My first webapp</h1>");
		writer.println("<hr/>");
		writer.println("<p>Created by Vinod for Target UpCurve 2024</p>");
		writer.println("<a href=\"get-greeting-message\">Get a greeting from server</a>");
		writer.println("<p>Hello, friend!</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	
	}

}
