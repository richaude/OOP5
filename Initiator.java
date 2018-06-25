package kochkurven;

import java.util.ArrayList;
import java.util.List;

public class Initiator {
	private String eingabe;
	private List<Linie> linien;
	private boolean innen, success;
	
	public Initiator(String eingabe) {
		this.eingabe = eingabe;
		this.linien = new ArrayList<Linie>();
		this.success = false;
		parseString();
	}

	private void parseString() {
		// Untersuche hier den String auf Fehler, und erschaffe den Initiator bzw. dessen Punkte
		
		
		
		
		this.success = true;
	}
	public List<Linie> getLinien() {
		return this.linien;
	}
	public boolean getInnen() {
		return this.innen;
	}
	public boolean getSuccess() {
		return this.success;
	}
	
}


