package kochkurven;


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
				//for(Linie l : this.initiator.getLinien()) {
				//	System.out.println(l);
				//}
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
			// System.out.println("Generator angekommen, Eingabe:=" + eingabe +"; UnfallCode :="+code+" Jetzt TEST:");
		
			boolean failed = uebergibGenerator(eingabe);
						
			// Rueckmeldung
			
			if(failed) {
				display.communicate("Generator konnte nicht berechnet werden.");
				activeGenerator = false;
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
		int zaehler = 0;
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
			//System.out.println("Berechnung erfolgt!");			//Debug
			
			List<Linie> currentLines = this.initiator.getLinien();
			List<Linie> finalLines = new ArrayList<Linie>();
			boolean longerAsMinL = false;
			
			
			Double linienlaenge = currentLines.get(0).getLaenge();
			
			//System.out.println("Minimale Generator-Laenge = "+this.generator.getMinL());
			if(linienlaenge >= this.generator.getMinL()) {
				longerAsMinL = true;
			}
			else {
				longerAsMinL = false;
			}
			//(0,0);(0.3333333,0);(0.5, 0.288675);(0.666666,0);(1,0);1
			
			while(longerAsMinL) {
				for(Linie l: currentLines) {
				//	System.out.println(l);
					// Wende Generator auf Linie an und speicher die Ergebnisse
					this.generator.setLinie(l.getStart().getX(), l.getStart().getY(), l.getEnd().getX(), l.getEnd().getY());
					this.generator.produziereLinien(this.initiator.getInnen());
					
					//System.out.println("\n\n Linien kommen \n\n");
					for(Linie m : this.generator.getLinien()) {
						finalLines.add(m);
					//	System.out.println(m); // Debug
					}
					//System.out.println("\n\n");
					
				}
								
				for(Linie a : currentLines) {
					if(a.getLaenge() < this.generator.getMinL()) {
						longerAsMinL = false;
					}
					// Entferne Alte Linien
					else if(finalLines.contains(a)) {
						finalLines.remove(a);
					}
				}
				// Hier sind alle berechneten Linien in finalLines
				currentLines = new ArrayList<Linie>(finalLines); 
				zaehler += 1;
			}
			
			//System.out.println(zaehler);	
			// Uebergabe ans Display
			
			//for(Linie c: finalLines) {			// Debug
			//	System.out.println(c);
			//}
	
			this.alleLinien = finalLines;
			display.zeichneAlleLinien(alleLinien);
		}
	}
	private boolean uebergibGenerator(String eingabe) {
		boolean failed = false;
		
		// Untersuche hier den String auf Fehler, und erschaffe den Initiator bzw. dessen Punkte
					// FehlerSuche, fange noch Laenge 1 und 0 ab; Bitte noch die Ausgangslinien wieder rausnehmen
					String[] punkte = eingabe.split(";");
					boolean nurZahlen = true;
					for(char c : eingabe.toCharArray()) {
						if(Character.isLetter(c)) {
							nurZahlen = false;
						}
					}
					if(!eingabe.contains(";")) {
						System.out.println("Debug: Kein ';' Innerhalb der Eingabe");
						//display.communicate("Generator konnte nicht berechnet werden.");
						return true;
					}
					else if(!nurZahlen) {
						//Fange Buchstaben in der Zeichenkette ab
						System.out.println("Zahlen am Start");
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
				//			System.out.println(point);
						}
						this.generator = new GeneratorCustom(allePunkte);
						this.generator.setMinL(lastItem);
					
					}
		return failed;
	}
}
