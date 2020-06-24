package com.xebia.covid_app.utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	public static String sendMail(String toAddress, int otp) {

		String userName = "noreply_helpdesk@xebia.com";
		String password = "rxjywnwmtswvpzbl";
		String host = "outlook.office365.com";
		String port = "587";

		/*
		 * String userName = env.getProperty("spring.mail.username"); String host =
		 * env.getProperty("spring.mail.host"); String port =
		 * env.getProperty("spring.mail.port"); String password =
		 * env.getProperty("spring.mail.password");
		 */

		String subject = "Login Confirmation";
		String message = "You have logged in successfully. Your One Time Password is :" + otp;
		String status;

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		properties.put("mail.smtp.user", userName);

		// creates a new session, no Authenticator (will connect() later)
		Session session = Session.getDefaultInstance(properties);

		// creates a new e-mail message
		try {
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(userName));
			InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			// set plain text message
			msg.setText(message);

			Transport t = session.getTransport("smtp");
			t.connect(userName, password);
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();
			status = "done";

		} catch (Exception e) {

			e.printStackTrace();

			status = "error";
		}
		return status;
	}

}
