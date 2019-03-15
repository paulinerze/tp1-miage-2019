package com.acme.mailreader.presentation;

import javax.inject.Inject;

import com.acme.mailreader.domaine.Mail;
import com.acme.mailreader.service.MailService;

public class InterpreteurLigneCommande {

	MailService mailService;
	
	public InterpreteurLigneCommande() {

	}
	
	public void nouveauMail(String[] args) {
		String sujet = args[1];
		Mail mail = new Mail.Builder(sujet).build();
		mailService.envoyerMail(mail);
		
	}
}
