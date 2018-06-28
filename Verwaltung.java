package kochkurven;

// Die Hauptschleife fehlt noch!

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

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
			
			// 2 fuer GenCustom, Text ist nicht formattiert!, uebergib dann die Punkte
			System.out.println("Generator angekommen, Eingabe:=" + eingabe +"; UnfallCode :="+code+" Jetzt TEST:");
		
			boolean failed = uebergibGenerator(eingabe);
						
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
	private boolean uebergibGenerator(String eingabe) {
		boolean failed = false;
		
		
		// Untersuche hier den String auf Fehler, und erschaffe den Initiator bzw. dessen Punkte
					// FehlerSuche, fange noch Laenge 1 und 0 ab
					String[] punkte = eingabe.split(";");
					if(!eingabe.contains(";")) {
						System.out.println("Debug: Kein ';' Innerhalb der Eingabe");
						//display.communicate("Generator konnte nicht berechnet werden.");
						return true;
					}

					else {
						//Zuerst die Ausrichtung
						Double lastItem = Double.parseDouble(punkte[punkte.length-1]);
						if(lastItem <= 0) {
							System.out.println("Debug: Linie kleiner gleich 0");
							return true;
						}
						
						List<Point2D> allePunkte = new ArrayList<Point2D>();
						// Jetzt die Punkte

						for(int i = 0; i<punkte.length-1; i++) {
							// Punkte haben die Form "(x.y,a.b)"
							String[] word1 = punkte[i].split(",");
							
							String xCoordString = word1[0].replace('(', ' ').replace(')', ' ').trim();
							String yCoordString = word1[1].replace('(', ' ').replace(')', ' ').trim();
							Double xCoord = Double.parseDouble(xCoordString);
							Double yCoord = Double.parseDouble(yCoordString);
							// System.out.println("X1:= "+xCoord1+" Y1:= "+yCoord1+" X2:= "+xCoord2+" Y2:= " +yCoord2);
							Point2D point = new Point2D(xCoord,yCoord);
							allePunkte.add(point);
							
						}
						this.generator = new GeneratorCustom(allePunkte);
						this.generator.setMinL(lastItem);
					
					}
		return failed;
	}
}
