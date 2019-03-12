package com.acme.mailreader.bdd;

import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.acme.mailreader.domain.DateIncorrecteException;
import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.Mail.Statut;
import com.acme.mailreader.domain.MailComparator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Les steps (actions) du test
 * 
 * <p>
 * A noter qu'une nouvelle instance de cette classe est créée à chaque scenario
 * </p>
 *
 */

public class MailComparaisonStep {

	private Mail mail1;
	private Mail mail2;
	private String resultatComparaison;
	Comparator<Mail> comparator = new MailComparator();
	private static final Map<Integer, String> resuAsString = new HashMap<Integer, String>();
	static {
		resuAsString.put(MailComparator.PREMIER_PLUS_PETIT , "MAIL1_APRES");
		resuAsString.put(MailComparator.EGAUX, "EGAUX");
		resuAsString.put(MailComparator.PREMIER_PLUS_GRAND, "MAIL1_AVANT");
	}
	

	@Given("^un premier mail avec l'importance \"([^\"]*)\", le statut \"([^\"]*)\", le sujet \"([^\"]*)\" et la date \"([^\"]*)\"$")
	public void un_premier_mail(boolean importance, Statut statut,
			String sujet, String date) throws DateIncorrecteException {
		mail1.setImportant(importance);
		mail1.setStatut(statut);
		mail1.setSujet(sujet);
		mail1.setDate(Instant.parse(date));
	}

	@Given("^un second mail avec l'importance \"([^\"]*)\", le statut \"([^\"]*)\", le sujet \"([^\"]*)\" et la date \"([^\"]*)\"$")
	public void un_second_mail(boolean importance, Statut statut, String sujet,
			String date) throws DateIncorrecteException {
		mail2.setImportant(importance);
		mail2.setStatut(statut);
		mail2.setSujet(sujet);
		mail2.setDate(Instant.parse(date));
	}

	

	@When("^je trie$")
	public void je_trie() throws Throwable {
		resultatComparaison = Integer.toString(comparator.compare(mail1,mail2));
		
	}

	@Then("^le tri doit retourner \"([^\"]*)\"$")
	public void le_tri_doit_retourner(String resu) throws Throwable {
		System.out.println(resuAsString.get(resultatComparaison));
	}
	

}
