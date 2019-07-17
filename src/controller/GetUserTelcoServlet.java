package controller;

//http://localhost:8080/MP1_Keypad_App

//remove get/setAttribute() and just directly save the values to the session and cookie
//getRequestDispatcher = server side | sendRedirect = client side
//also sendRedirect("/MP1_Keypad_App/displayInfo")  instead of getRequestDispatcher

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PhoneKeypadImpl;

//@WebServlet("/getInfo.java")
public class GetUserTelcoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("on GET");
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("GetUserTelcoServlet");
		System.out.println("on POST");
		
		String getInput = request.getParameter("input"); //input number from html form input type "input"
		String[] inputSplit = getInput.split("-");
		String telco = inputSplit[0];
		String number = inputSplit[1]; 
		String convertedTelco = "";
		String convertedNum = "";
		String finalNum = "";
		
		PhoneKeypadImpl phone = new PhoneKeypadImpl(telco, number, getServletContext());
		
		if (phone.validateTelcoNumber() && phone.validatePhoneNumber()) {
			// true == passed
			System.out.println("Validation Passed");
			getServletContext().log("Data from HTML Form received at " + new java.util.Date());
			
			// Converted
			convertedTelco = phone.determineTelcoProvider();
			convertedNum = phone.convertToNumeric();
			finalNum = inputSplit[0] + "-" + convertedNum;
			
			System.out.println("Telco is " + convertedTelco);
			System.out.println("Phone is " + finalNum);
			
			
			
			//Cookie
		    Cookie ck = new Cookie("Telco", convertedTelco); //create cookie object -->  Cookie(name, value)
			ck.setMaxAge(-1);//changing the maximum age to 0 seconds   //non persistent for negative int
		    response.addCookie(ck);//adding cookie in the response  
			
					
			//Session
		    HttpSession session=request.getSession();
		    session.setAttribute("cNum", convertedNum);
			
			
			request.setAttribute("telco", convertedTelco);
			request.setAttribute("finalPhoneNum", finalNum);
			getServletContext().getRequestDispatcher("/displayInfo").forward(request, response);
			//response.sendRedirect("/MP1_Keypad_App/displayInfo");
			
		}
		else {
			System.out.println("Wrong Input");
			response.sendRedirect("wrongInput.html"); // Design the wrong input page
		}
	}

}
