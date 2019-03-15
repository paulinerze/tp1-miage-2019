package com.acme.mailreader.domaine;

import java.util.Comparator;

import com.acme.mailreader.domaine.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {

	public int compare(Mail mail1, Mail mail2) {
		if (mail1 == null || mail2 == null) {
			return 0;
		}
		if (mail1.isImportant() != mail2.isImportant()) {
			return compareImportance(mail1,mail2);
		}
		if (mail1.getStatut() != mail2.getStatut()) {
			return compareStatut(mail1,mail2);
		}
		if (mail1.getSujet() != mail2.getSujet()) {
			return compareSujet(mail1,mail2);
		}
		return compareDate(mail1,mail2);
	}
	
	public int compareImportance(Mail mail1, Mail mail2) {
		if (mail1.isImportant() && !mail2.isImportant()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public int compareStatut(Mail mail1, Mail mail2) {
		int comp = mail1.getStatut().ordinal() - mail2.getStatut().ordinal();
		return comp > 0 ? -1 : 1;
	}
	
	public int compareSujet(Mail mail1, Mail mail2) {
		return mail2.getSujet().compareTo(mail1.getSujet());
	}

	public int compareDate(Mail mail1, Mail mail2) {
		return mail2.getDate().compareTo(mail1.getDate());
	}
}
