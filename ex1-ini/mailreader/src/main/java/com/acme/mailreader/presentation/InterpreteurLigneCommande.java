package com.acme.mailreader.presentation;

import javax.inject.Inject;

import com.acme.mailreader.infrastructure.MailSender;

public class InterpreteurLigneCommande {
	MailSender mailsender;

	@Inject
	public InterpreteurLigneCommande(MailSender mailsender) {
		this.mailsender = mailsender;
	}
}
