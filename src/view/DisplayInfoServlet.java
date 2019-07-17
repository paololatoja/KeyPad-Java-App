package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import model.PhoneKeypadImpl;
import model.TelcoCounter;


//@WebServlet("/displayInfo")
public class DisplayInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(false);
		Cookie ck[] = request.getCookies();

		String telco = request.getAttribute("telco").toString();
		String finalNumber = request.getAttribute("finalPhoneNum").toString();

		String sessionPhone = (String)session.getAttribute("cNum");

		// Update Telco Counter
		TelcoCounter tcounter= new TelcoCounter();
		tcounter.incTelco(telco);

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();


			// only one out.print("") from opening html tag to opening body tag

			out.print("<!DOCTYPE html>\n" +
					"<html lang=\"en\">\n" +
					"	<head>\n" +
					"		<meta charset=\"UTF-8\" />\n" +
					"		<meta\n" +
					"			name=\"viewport\"\n" +
					"			content=\"width=device-width, initial-scale=1.0,shrink-to-fit=no\"\n" +
					"		/>\n" +
					"		<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n" +
					"		<link\n" +
					"			rel=\"stylesheet\"\n" +
					"			href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\"\n" +
					"		/>\n" +
					"		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n" +
					"		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n" +
					"		<link\n" +
					"			rel=\"stylesheet\"\n" +
					"			href='displayInfo.css'>" +
					"		<title>Information</title>\n" +
					"	</head>\n" +
					"\n" +
					"	<body>\n" +
					"		<div class='container' id='con1'>\n" +
					"			Your Telecommunication company is <b>" + telco + "</b><br />" +
					"			Your phone number is <b>" + finalNumber + "</b> <br /><br />Cookie" +
					"			Value: <b>"+ ck[0].getValue() + "</b><br />" +
					"			Session Value: <b>" + sessionPhone + "</b><br /><br />" +
					"			<p id='thanks'>Thank you very much for using this system.</p>" +
					"\n" +
					"			<button\n" +
					"				type=\"button\"\n" +
					"				class=\"btn btn-info btn-lg\"\n" +
					"				data-toggle=\"modal\"\n" +
					"				data-target=\"#myModal\"\n" +
					"			>\n" +
					"				Check Counter\n" +
					"			</button>\n" +
					"\n" +
					"			<div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n" +
					"				<div class=\"modal-dialog modal-sm\">\n" +
					"					<!-- Modal content-->\n" +
					"					<div class=\"modal-content\">\n" +
					"						<div class=\"modal-header\">\n" +
					"							<button\n" +
					"								type=\"button\"\n" +
					"								class=\"close\"\n" +
					"								data-dismiss=\"modal\"\n" +
					"							>\n" +
					"								&times;\n" +
					"							</button>\n" +
					"							<h4 class=\"modal-title\">\n" +
					"								Telecommunications Company Counter\n" +
					"							</h4>\n" +
					"						</div>\n" +
					"						<div class='modal-body'>" +
					"							Smart : " + tcounter.getTelcoSmart() + "<br /><br />" +
					"							Globe : " + tcounter.getTelcoGlobe() + "<br /><br />\n" +
					"							Sun Cellular : " + tcounter.getTelcoSun() + "<br /><br />" +
					"						</div>\n" +
					"						<div class=\"modal-footer\">\n" +
					"							<button\n" +
					"								type=\"button\"\n" +
					"								class=\"btn btn-default\"\n" +
					"								data-dismiss=\"modal\"\n" +
					"							>\n" +
					"								Close\n" +
					"							</button>\n" +
					"						</div>\n" +
					"					</div>\n" +
					"				</div>\n" +
					"			</div>\n" +
					"		</div>\n" +
					"	</body>\n" +
					"</html>\n" +
					"");

			out.close();

			System.out.println("----------DisplayInfoServlet-------------");
			//Cookie
			System.out.println("Cookie Value: " + ck[0].getValue());

			System.out.println("SessionValue: " + sessionPhone);

		//}
	}

}
