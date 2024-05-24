package com.dev.registration;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String email = request.getParameter("email");
		String form = "";
		String fPw = "";
		RequestDispatcher dispatcher = null;
		int otpVal = 0;
		HttpSession mySession = request.getSession();

		if (email != null || !"".equals(email)) {
			// Sending OTP
			Random rand = new Random();
			otpVal = rand.nextInt(999999);

			String to = email; // Change accordingly

			// Get the session object
			Properties props = new Properties();
//			props.setProperty("mail.transport.protocol", "smtp");
//			props.setProperty("mail.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
//			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//			props.put("mail.smtp.socketFactory.fallback", "false");

//			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(form, fPw);
				}
			});
//			session.getProperties().put("mail.smtp.starttls.enable", "true");
//			session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");

			// Compose message
			try {
//				Transport transport = session.getTransport("smtp");
				MimeMessage message = new MimeMessage(session);
//				message.setFrom(new InternetAddress(email)); // Change accordingly
				message.setFrom(new InternetAddress(form));
//				message.setSender(new InternetAddress(""));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Hello", "utf-8");
				message.setContent("Your OTP is: " + otpVal, "text/plain");
//				message.setText("Hello", "utf-8", "html");
				// Send message
//				transport.connect();
				Transport.send(message);
//				transport.close();
				System.out.println("Message sent successfully!");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

			dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
			request.setAttribute("message", "OTP is sent to your email id");

			mySession.setAttribute("otp", otpVal);
			mySession.setAttribute("email", email);
			dispatcher.forward(request, response);

		}
	}

}
