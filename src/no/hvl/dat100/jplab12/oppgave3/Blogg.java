package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] innleggTabell;
	private int nesteLedige = 0;
	
	public Blogg() {
		
		innleggTabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		
		innleggTabell = new Innlegg[lengde];
	}

	public int getAntall() {
		
		return nesteLedige;
	}
	
	public Innlegg[] getSamling() {
		
		return innleggTabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteLedige; i++) {
			if (innleggTabell[i].erLik(innlegg)) {
				return i;
			}
		}
		
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		
		return (finnInnlegg(innlegg) != -1);
				
	}

	public boolean ledigPlass() {
		
			return (nesteLedige < innleggTabell.length);

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (ledigPlass() == true) {
			innleggTabell[nesteLedige] = innlegg;
			nesteLedige++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String tekst = Integer.toString(nesteLedige) + "\n";
		for (int i = 0; i < nesteLedige; i++) {
			tekst += innleggTabell[i].toString();
		}
		return tekst;
		
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] dobbelTabell = new Innlegg[2*innleggTabell.length];
		
		for (int i = 0; i < nesteLedige; i++) {
			dobbelTabell[i] = innleggTabell[i];
		}
		
		innleggTabell = dobbelTabell;
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = false;
		
		if (finnInnlegg(innlegg) == -1) {
			if (!ledigPlass()) {
				utvid();
			}
			
			innleggTabell[nesteLedige] = innlegg;
			nesteLedige++;
			lagtTil = true;
		}
		
		return lagtTil;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		for (int i = finnInnlegg(innlegg); i < nesteLedige-1; i++) {
			    innleggTabell[i] = innleggTabell[i + 1];
			}
		
		nesteLedige--;
		return true;
					
		}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}