package kochkurven;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public Initiator() {
		this.success = false;
	}

	private void parseString() {
		// Untersuche hier den String auf Fehler, und erschaffe den Initiator bzw. dessen Punkte
			// FehlerSuche, fange noch Laenge 1 und 0 ab
			String[] punkte = eingabe.split(";");
			int lastItem = punkte.length-1;
			if(!eingabe.contains(";")) {
				this.success = false;
				System.out.println("Debug: Kein ';' Innerhalb der Eingabe");
				return;
			}
			else {
				//Zuerst die Ausrichtung
				if(punkte[lastItem].trim().toLowerCase().equals("innen")) {
					this.innen = true;
				}
				else if(punkte[lastItem].trim().toLowerCase().equals("aussen")) {
					this.innen = false;
				}
				else {
					// Keine valide Ausrichtung
					this.success = false;
					return;
				}
				
				// Jetzt die Punkte
				
				for(int i = 0; i<lastItem-1; i++) {
					int j = i + 1;
					// Punkte haben die Form "(x.y,a.b)"
					String[] word1 = punkte[i].split(",");
					String[] word2 = punkte[j].split(",");
					
					String xCoord1 = word1[0].replace('(', ' ').replace(')', ' ').trim();
					String yCoord1 = word1[1].replace('(', ' ').replace(')', ' ').trim();
					String xCoord2 = word2[0].replace('(', ' ').replace(')', ' ').trim();
					String yCoord2 = word2[1].replace('(', ' ').replace(')', ' ').trim();
					// System.out.println("X1:= "+xCoord1+" Y1:= "+yCoord1+" X2:= "+xCoord2+" Y2:= " +yCoord2);

					Linie linie = new Linie(Double.parseDouble(xCoord1),Double.parseDouble(yCoord1),Double.parseDouble(xCoord2),Double.parseDouble(yCoord2));
					this.linien.add(linie);
					//System.out.println(linie);
				}
				// Linien sind gefuellt
				
				this.success = true;
			}
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


