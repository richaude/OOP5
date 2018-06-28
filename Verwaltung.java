package kochkurven;

import java.util.ArrayList;
import java.util.List;

public class Verwaltung {
	
	private Initiator initiator;
	private Generator generator;
	private Display display;
	private List<Linie> alleLinien;
	private boolean activeGenerator;
	

	public Verwaltung(Display display) {
		this.display = display;
		this.initiator = new Initiator();
		activeGenerator = false;
	}
	
	public void initInitiator(String eingabe) {
			// Uebergebe Initiator seine Punkte und die Ausrichtung
			// Text muss noch formattiert werden
			this.initiator = new Initiator(eingabe);
			if(!this.initiator.getSuccess()) {
				display.communicate("Initiator konnte nicht berechnet werden.");
			}
			else {
				// System.out.println("Erfolgreiche Uebergabe, eingabe :=" + eingabe + ";;;;; ");
				for(Linie l : this.initiator.getLinien()) {
					System.out.println(l);
				}
			}
			// Initiator-Initiierung abgeschlossen. GJ
			display.communicate("Initiator erfolgreich berechnet.");
	}
	public void initGenerator(int code, String eingabe) {
		if(code == 0) {
			// 0 fuer Gen 1
			this.generator = new Generator1();
			
			// Rueckmeldung
			activeGenerator = true;
			display.communicate("Generator erfolgreich berechnet.");
		}
		else if(code == 1) {
			// 1 fuer Gen 2
			this.generator = new Generator2();
			
			// Rueckmeldung
			activeGenerator = true;
			display.communicate("Generator erfolgreich berechnet.");

		}
		else {
			
			this.generator = new GeneratorCustom();
			boolean failed = false;
			
			
			
			// 2 fuer GenCustom, Text ist nicht formattiert!, uebergib dann die Punkte
			System.out.println("Generator angekommen, Eingabe:=" + eingabe +"; UnfallCode :="+code+" Jetzt TEST:");
		
			
			

			
			// Rueckmeldung
			
			if(failed) {
				display.communicate("Generator konnte nicht berechnet werden.");
				return;
			}
			else {
				activeGenerator = true;
				display.communicate("Generator erfolgreich berechnet.");
			}
		}
	}
	
	//	display.communicate("Works");
	public void verwalten() {
	//Wir haben Initiator und Generator, erzeuge nun alle Linien und lass sie Zeichnen.
		
		// Fehler abfangen, ACHTUNG: NULL anders abfangen!
		if(!this.initiator.getSuccess()) {
			display.communicate("Initiator konnte nicht berechnet werden.");
			return;
		}
		else if(!this.activeGenerator) {
			display.communicate("Generator konnte nicht berechnet werden.");
			return;
		}
		
		else {
				
			// Fuehre superSchleife aus
			System.out.println("Berechnung steht noch aus!");			//Debug
			
			
			List<Linie> currentLines = this.initiator.getLinien();
			/*
			for(Linie l : currentLines) {
				System.out.println(l);
			}
			*/
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
			
			
			
			
			
			
			
			
			// Uebergabe ans Display
			this.alleLinien = finalLines;
			display.zeichneAlleLinien(alleLinien);
		}
	}
}
