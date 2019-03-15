package com.acme.mailreader.presentation;

public class ClientMail {
	
	public static void main(String[] args) {
		boolean production = Boolean.parseBoolean(args[0]);
		InterpreteurLigneCommande cli = new InterpreteurLigneCommande();
		cli.nouveauMail(args);
	}

}
