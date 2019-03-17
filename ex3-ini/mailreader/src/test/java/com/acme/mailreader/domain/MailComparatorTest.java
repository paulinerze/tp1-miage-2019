package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.MailComparator;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}

	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void egauxSiUnDesMailsNuls() {
		Mail mail1 = new Mail();
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void mailLuEnPremier() {
		Mail mail1 = new Mail.Builder("sujet").statut(Mail.Statut.READ).build();
		Mail mail2 = new Mail.Builder("sujet").statut(Mail.Statut.UNSENT).build();
		assertThat(mail1, not(nullValue()));
		assertThat(comparator.compare(mail1, mail2), is(MailComparator.PREMIER_PLUS_GRAND));		
	}
	
	@Test
	public final void mailSujetTrieOrdreAlphabetique() {
		Mail mail1 = new Mail.Builder("Asujet").important(true).statut(Mail.Statut.UNSENT).build();
		Mail mail2 = new Mail.Builder("Bsujet").important(true).statut(Mail.Statut.UNSENT).build();
		assertThat(mail1, not(nullValue()));
		assertThat(comparator.compare(mail1, mail2), is(MailComparator.PREMIER_PLUS_GRAND));		
	}
	
	@Test
	public final void mailDateRecenteEnPremier() throws DateIncorrecteException {
		Mail mail1 = new Mail.Builder("sujet").date(Instant.now()).build();
		Mail mail2 = new Mail.Builder("sujet").date(Instant.now().plusSeconds(360000)).build();
		assertThat(mail1, not(nullValue()));
		assertThat(comparator.compare(mail1, mail2), is(MailComparator.PREMIER_PLUS_GRAND));		
	}	
		
}