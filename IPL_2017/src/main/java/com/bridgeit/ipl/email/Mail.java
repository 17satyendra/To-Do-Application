package com.bridgeit.ipl.email;

public interface Mail 
{

	void sendMail(String senderEmail, String receiverEmail, String subject, String message);

}
