package kochkurven;

import java.util.ArrayList;
import java.util.List;

public class Verwaltung {
	
	private Initiator initiator;
	private Generator generator;
	private Display display;
	private List<Linie> alleLinien;
	

	public Verwaltung(Display display) {
		this.display = display;
	}
	
	
	
	public void initInitiator(String eingabe) {

			// Uebergebe Initiator seine Punkte und die Ausrichtung
			// Text muss noch formattiert werden
			this.initiator = new Initiator(eingabe);
			if(!this.initiator.getSuccess()) {
				display.communicate("Fehler beim Uebergeben des Initiators! Bitte achten sie auf die Eingabe-Maske!");
			}
			else {
				System.out.println("Erfolgreiche Uebergabe, eingabe :=" + eingabe + ";;;;; ");
			}
	}
	public void initGenerator(int code, String eingabe) {
		if(code == 0) {
			// 0 fuer Gen 1
			this.generator = new Generator1();
		}
		else if(code == 1) {
			// 1 fuer Gen 2
			this.generator = new Generator2();
		}
		else {
			// 2 fuer GenCustom, Text ist nicht formattiert!, uebergib dann die Punkte
		}
		System.out.println("Generator angekommen, Eingabe:=" + eingabe +"; UnfallCode :="+code);
	}
	
	//	display.communicate("Works");
	public void verwalten() {
	//Wir haben Initiator und Generator, erzeuge nun alle Linien und lass sie Zeichnen.
		List<Linie> currentLines = this.initiator.getLinien();
		List<Linie> finalLines = new ArrayList<Linie>();
		boolean mindestlaenge = false;
		
		/*do {
			mindestlaenge = false;
			Linie currentLinie = currentLines.get(0);
			if(currentLinie.getLaenge() >= this.generator.()) {
				// Mindestlaenge erreicht
				for(Linie l: currentLines) {
					// Wende Generator auf Linie an und speicher die Ergebnisse
				}
				mindestlaenge = true;
				
			}
		}
		while(mindestlaenge);
		*/
		this.alleLinien = finalLines;
		display.zeichneAlleLinien(alleLinien);
	}
	
}
