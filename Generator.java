package kochkurven;

import java.util.List;

/**
 * Abstrakte Generator-Klasse, stellt einige grundlegende Funktionen des Generators bereit. Hauptaufgabe der Generatoren ist es, eine Linie auf eine bestimmte Art, die in den Unterklassen konkret implementiert wird, zu manipulieren.
 * @author richard
 *
 */
public abstract class Generator {

	private Linie linie;
	protected double minL;
	protected List<Linie> prodLinien;
	
	
	/**
	 * Konstruktor.
	 * @param linie die zu manipulierende Linie
	 * @param minL die Mindestlaenge einer Linie, die nicht unterschritten werden darf.
	 */
	public Generator(Linie linie, double minL) {
		this.linie = linie; 
		this.minL = minL;
	}
	
	/**
	 * Leerer Konstruktor. Die Linie kann dann mit der Methode {@link #setLinie(double, double, double, double) setLinie} veraendert werden.
	 */
	public Generator() {
		this.linie = new Linie(0,0,0,0);
	}
	
	/**
	 * Diese abstrakte Methode wird in den einzelnen Unterklassen implementiert.
	 * @param innen Ob die Kurve nach innen oder aussen zeigen soll, true fuer innen, false fuer aussen.
	 */
	public abstract void produziereLinien(boolean innen);
	
	/**
	 * Getter-Methode fuer die vom Attribut linie durch den Generator erzeugten Linien
	 * @return die vom Generator erzeugten Linien
	 */
	public List<Linie> getLinien() {
		return prodLinien;
	}
	
	/**
	 * Getter-Methode fuer die Ausgangslinie
	 * @return die Ausgangslinie
	 */
	public Linie getLinie() {
		return linie;
	}
	
	/**
	 * Setter fuer die Ausgangslinie (um ein staendiges Neuinstanziieren zu vermeiden)
	 * @param startX der x-Wert des Startpunkts
	 * @param startY der y-Wert des Startpunkts
	 * @param endX der x-Wert des Endpunkts
	 * @param endY der y-Wert des Endpunkts
	 */
	public void setLinie(double startX, double startY, double endX, double endY) {
		linie.setLinie(startX, startY, endX, endY);
	}
	
	/**
	 * Setter fuer die Mindestlaenge der Linie
	 * @param minL die neue Mindestlaenge
	 */
	public void setMinL(double minL) {
		this.minL = minL;
	}
	
	/**
	 * Getter fuer die Mindestlaenge
	 * @return die Mindestlaenge
	 */
	public double getMinL() {
		return this.minL;
	}

}
