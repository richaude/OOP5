package kochkurven;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementiert die Methode zur Manipulation einer Ausgangslinie nach Generator 1. Manipuliert die Ausgangslinie in Relation zu der Manipulation der Linie von (0/0) bis (1/0) auf dem Aufgabenblatt.
 * @author richard
 *
 */
public class Generator1 extends Generator {
	
	/**
	 * Konstruktor, der den Super-Konstruktor mit Parametern aufruft
	 * @param linie die zu manipulierende Linie
	 * @param minL die Mindestlaenge fuer die Linie
	 */
	public Generator1(Linie linie, double minL) {
		super(linie, minL);
	}
	
	/**
	 * Dieser Konstruktor ruft den super-Konstruktor und setzt die Mindestlaenge auf einen Pixel.
	 */
	public Generator1() {
		super();
		this.minL = 1.0;
		}
	
	/**
	 * Diese Methode ist die konkrete Implementierung der abstrakten Methode {@link Generator#produziereLinien(boolean) produziereLinien} im Generator 1.
	 * Hier wird die Ausgangslinie gemaess des ersten Generators gedrittelt, wobei das mittlere Drittel die nicht sichtbare Grundseite eines gleichseitigen Dreiecks ist.
	 * @param innen ist true, falls die Spitze des gleichseitigen Dreiecks nach innen oder unten zeigen soll, sonst false. Dabei wird davon ausgegangen, dass der Startpunkt einer Linie immer auf der linken Seite liegt.
	 */
	@Override
	public void produziereLinien(boolean innen) {
		Linie ausgangsLinie = getLinie();
		double xMittelpunkt = ausgangsLinie.getMitte().getX();
		double yMittelpunkt = ausgangsLinie.getMitte().getY();
		double laenge = ausgangsLinie.getLaenge();
		double vektorX = ausgangsLinie.getEnd().getX()-ausgangsLinie.getStart().getX();
		double vektorY = ausgangsLinie.getEnd().getY()-ausgangsLinie.getStart().getY();
		double vektorXDrittel1 = vektorX/3;
		double vektorYDrittel1 = vektorY/3;
		double xDrittel1 = ausgangsLinie.getStart().getX()+vektorXDrittel1;
		double yDrittel1 = ausgangsLinie.getStart().getY()+vektorYDrittel1;
		double xDrittel2 = (xDrittel1+ausgangsLinie.getEnd().getX())/2;
		double yDrittel2 = (yDrittel1+ausgangsLinie.getEnd().getY())/2;
		//bis hier ist jetzt erstmal die Dreiteilung der Strecke erreicht
		Linie halbLinie = new Linie(xDrittel1, yDrittel1, xMittelpunkt, yMittelpunkt);
		double haelfte = halbLinie.getLaenge();
		Linie seitenLaengenlinie = new Linie(xDrittel1, yDrittel1, xDrittel2, yDrittel2);
		double seitenlaenge = seitenLaengenlinie.getLaenge();
		double dreiecksHalbierende = Math.sqrt(Math.pow(seitenlaenge, 2.0)-Math.pow(haelfte, 2.0));
		double richtungsVektorNormaleX;
		double richtungsVektorNormaleY;
		if (innen) {
			richtungsVektorNormaleX = -vektorY;
			richtungsVektorNormaleY = vektorX;
		} else {
			richtungsVektorNormaleX = vektorY;
			richtungsVektorNormaleY = -vektorX;
		}
		//double richtungsVektorNormaleX = -vektorY; //oder eben +vektorY fuer aussen
		//double richtungsVektorNormaleY = vektorX; //oder eben -vektorX
		double ratioGesamtstreckeVsSeitenhalbierende = laenge/dreiecksHalbierende;
		double zuAddierenX = richtungsVektorNormaleX*(1/ratioGesamtstreckeVsSeitenhalbierende);
		double zuAddierenY = richtungsVektorNormaleY*(1/ratioGesamtstreckeVsSeitenhalbierende);
		double xSpitze = xMittelpunkt+zuAddierenX;
		double ySpitze = yMittelpunkt+zuAddierenY;
		Linie line1 = new Linie(ausgangsLinie.getStart().getX(), ausgangsLinie.getStart().getY(), xDrittel1, yDrittel1);
		Linie line2 = new Linie(xDrittel1, yDrittel1, xSpitze, ySpitze);
		Linie line3 = new Linie(xSpitze, ySpitze, xDrittel2, yDrittel2);
		Linie line4 = new Linie(xDrittel2, yDrittel2, ausgangsLinie.getEnd().getX(), ausgangsLinie.getEnd().getY());
		List<Linie> prodLinien = new ArrayList<Linie>();
		prodLinien.add(line1);
		prodLinien.add(line2);
		prodLinien.add(line3);
		prodLinien.add(line4);
		this.prodLinien = prodLinien;
	}

}
