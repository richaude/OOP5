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
	
	
	
	public void initInitiator(String eingabe, boolean innen) {
		StringBuilder builder = new StringBuilder(eingabe);
		char c = builder.charAt(0);
	//	System.out.println(c);
		
		if(c == '1') {
		// Mode 1, erzeuge Initiator: Gerade-Linie
			
		} 
		else if (c == '2'){
		// Mode 2, erzeuge Initiator Quadrat, aussen
			
		}
		else if (c == '3'){
		// Mode 3, erzeuge Initiator Quadrat, innen	
			
		}
		else if (c == '4'){
		// Mode 4, erzeuge Initiator:gleichseitiges Dreieck	
			
		}
		else {
		// Mode 5, erzeuge custom Initiator
			
			
			
		}
		
	}
	public void initGenerator(int code, String eingabe) {
		if(code == 0) {
			// 0 fuer Gen 1
		}
		else if(code == 1) {
			// 1 fuer Gen 2
		}
		else {
			// 2 fuer GenCustom
		}
		
	}
	
	//	display.communicate("Works");
	public void verwalten() {
	//Wir haben Initiator und Generator, erzeuge nun alle Linien und lass sie Zeichnen.
		List<Linie> currentLines = this.initiator.getLinien();
		List<Linie> finalLines = new ArrayList<Linie>();
		boolean mindestlaenge = false;
		
		do {
			mindestlaenge = false;
			Linie currentLinie = currentLines.get(0);
			if(currentLinie.getLaenge() >= this.generator.getMinL()) {
				// Mindestlaenge erreicht
				for(Linie l: currentLines) {
					// Wende Generator auf Linie an und speicher die Ergebnisse
				}
				mindestlaenge = true;
				
			}
		}
		while(mindestlaenge);
		this.alleLinien = finalLines;
		display.zeichneAlleLinien(alleLinien);
	}
	
}
