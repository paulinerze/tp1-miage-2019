package com.acme.mailreader.service;

import com.acme.mailreader.domaine.Mail;

public class MailService {
	
	MailSender mailSender = new MailSender();

	public void envoyerMail(Mail mail) {
		
		mailSender.envoyerMail(mail);
		
	}
	
	

}
