package com.bridgeit.ipl.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * It is the simple class that defines mailSender property. An object of
 * MailSender will be provided to this property at runtime In the sendMail()
 * method, we are creating the instance of SimpleMailMessage and storing the
 * information into this object such as from, to, subject and message. The
 * send() method of MailSender interface is used here to send the simple mail.
 * 
 * @author bridgeit Satyendra Singh.
 *
 */
public class MailImpl implements Mail {
	@Autowired
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bridgeit.ipl.email.Mail#sendMail(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	public void sendMail(String senderEmail, String receiverEmail, String subject, String message) {

		// Creating Message
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(senderEmail);
		msg.setTo(receiverEmail);
		msg.setSubject(subject);
		msg.setText(message);

		// sending message
		mailSender.send(msg);
	}

}
