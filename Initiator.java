package kochkurven;

import java.util.ArrayList;
import java.util.List;

/**
 * Enthaelt den jeweiligen Initiator, der zur Berechnung der Koch-Kurve gebraucht wird
 * @author Lukas
 * @version 1.0
 */
public class Initiator {
	private String eingabe;
	private List<Linie> linien;
	private boolean innen, success;
	
	
	/**
	 * Erstellt einen neuen Initiator, indem parseString() aufgerufen wird und Klassenattribute initialisiert werden 
	 * @param eingabe enthaelt alle Punkte der Linien, aus denen der Initiator bestehen soll
	 */
	public Initiator(String eingabe) {
		this.eingabe = eingabe;
		this.linien = new ArrayList<Linie>();
		this.success = false;
		parseString();
	}
	
	/**
	 * Standart-Konstruktor, erzeugt leeren Initiator
	 */
	public Initiator() {
		this.success = false;
	}

	/**
	 * Untersucht den String innerhalb des Klassenattributs 'eingabe' auf die richtige Formatierung, ist er richtig formatiert,
	 * wird ein neuer Initiator erzeugt, die 'linien' gefuellt und 'success' auf true gesetzt, sonst wird eine Debug-Meldung ausgegeben
	 * und 'success' auf false gelassen
	 */
	private void parseString() {
		// Untersuche hier den String auf Fehler, und erschaffe den Initiator bzw. dessen Punkte
			
		// FehlerSuche, 
			String[] punkte = eingabe.split(";");
			int lastItem = punkte.length-1;
			if(!eingabe.contains(";")) {
				this.success = false;
				System.out.println("Debug: Kein ';' Innerhalb der Eingabe");
				return;
			}
			// Fange Laenge 1 und 0 ab usw.
			else if(punkte.length <= 2) {
				this.success = false;
				System.out.println("Zu wenige Elemente des Initiators.");
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
					
					// Leere Punkte abfangen
					
					String xCoord1 = word1[0].replace('(', ' ').replace(')', ' ').trim();
					String yCoord1 = word1[1].replace('(', ' ').replace(')', ' ').trim();
					String xCoord2 = word2[0].replace('(', ' ').replace(')', ' ').trim();
					String yCoord2 = word2[1].replace('(', ' ').replace(')', ' ').trim();
					
					if(xCoord1.equals("") || yCoord1.equals("") || xCoord2.equals("") || yCoord2.equals("")) {
						System.out.println("Leere Punkte im Initiator-String.");
						this.success = false;
						return;
					}
					else {
						// System.out.println("X1:= "+xCoord1+" Y1:= "+yCoord1+" X2:= "+xCoord2+" Y2:= " +yCoord2);
						try {
							Linie linie = new Linie(Double.parseDouble(xCoord1),Double.parseDouble(yCoord1),Double.parseDouble(xCoord2),Double.parseDouble(yCoord2));
							this.linien.add(linie);
						} 
						catch(Throwable t) {
							System.out.println("Fehler beim Linien-Parsen.");
							this.success = false;
							return;
						}	
						//System.out.println(linie);
					}
				}
				// Linien sind gefuellt
				
				this.success = true;
			}
	}
	
	/**
	 * Gibt die Linien dieses Initiators zurueck
	 * @return die Linien dieses Initiators
	 */
	public List<Linie> getLinien() {
		return this.linien;
	}
	
	/**
	 * Gibt die Ausrichtung der Linien des Initiators zurueck
	 * @return die Ausrichtung der Linien des Initiators
	 */
	public boolean getInnen() {
		return this.innen;
	}
	
	/**
	 * Gibt den aktuellen Zustand / die Gueltigkeit des Generators zurueck
	 * @return die Gueltigkeit des Generators
	 */
	public boolean getSuccess() {
		return this.success;
	}
	
}