package kochkurven;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;

/**
 * Implementiert die Methode zur Manipulation einer Ausgangslinie nach den angegebenen Punkten des Nutzers. Hier wird mit Hilfe einer gegebenen Liste von Punkten, die alle innerhalb des Intervalls von (0/0) bis (1/0) liegen, die Relation berechnet, um diese Punkte in den relativen Abstaenden zu der gegebenen Ausgangslinie zu berechnen. Anschliessend werden diese Punkte mit Linien verbunden.
 * @author richard
 *
 */
public class GeneratorCustom extends Generator {
	
	private List<Point2D> gegeben;
	private List<Point2D> ergebnisse;
	
	/**
	 * Konstruktor, der den Super-Konstruktor mit Parametern aufruft
	 * @param linie die zu manipulierende Linie
	 * @param minL die Mindestlaenge fuer die Linie
	 */
	public GeneratorCustom(Linie linie, double minL) {
		super(linie, minL);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Dieser Konstruktor ruft den super-Konstruktor auf.
	 */
	public GeneratorCustom() {
		super();
	}
	
	/**
	 * Dieser Konstruktor sorgt dafuer, dass dem Custom-Generator die gegebenen Punkte bekannt sind
	 * @param punkte die gegebenen Punkte, die vorher als String eingelesen und zu einer Liste von Point2D-Objekten geparst wurden.
	 */
	public GeneratorCustom(List<Point2D> punkte) {
		this.gegeben = punkte;
	}
	
	/**
	 * Diese Methode ist die konkrete Implementierung der abstrakten Methode {@link Generator#produziereLinien(boolean) produziereLinien} im Custom-Generator.
	 * Sie fuellt eine Liste von Linien mit den aus der Relation der gegebenen Punkte ermittelten Zwischenlinien.
	 * @param innen ob die durch die gegebenen Punkte verursachte Form nach innen (unten) oder aussen (oben) zeigt. Dabei wird angenommen, dass der Startpunkt einer Linie immer links ist. True, falls es nach innen, false falls es nach aussen zeigen soll.
	 */
	@Override
	public void produziereLinien(boolean innen) {
		//bestimme Allgemeines, Vektoren, Normalenvektoren, und sortiere die Punkte in der richtigen Reihenfolge
		Linie ausgangsLinie = getLinie();
		double vektorX = ausgangsLinie.getEnd().getX()-ausgangsLinie.getStart().getX();
		double vektorY = ausgangsLinie.getEnd().getY()-ausgangsLinie.getStart().getY();
		double laenge = ausgangsLinie.getLaenge();
		//sortierePunkteAufsteigend(); Habe mich gegen das Sortieren entschieden. Die Punkte werden jetzt in der Reihenfolge verbunden, in der sie eingegeben wurden.
		double normalenVektorX;
		double normalenVektorY;
		if (innen) {
			normalenVektorX = -vektorY;
			normalenVektorY = vektorX;
		} else {
			normalenVektorX = vektorY;
			normalenVektorY = -vektorX;
		}
		//zuerst alle Punkte ermitteln, die durch Linien verbunden werden sollen...
		ergebnisse = new ArrayList<>();
		//Startpunkt ist klar
		ergebnisse.add(new Point2D(ausgangsLinie.getStart().getX(), ausgangsLinie.getStart().getY()));
		for (int i=0; i<gegeben.size(); i++) {
			double umrechnungRelation = 1.0/laenge;
			double ratioX = laenge/(gegeben.get(i).getX()/umrechnungRelation);
			double zuAddierenHilfsPX = vektorX*(1/ratioX);
			double zuAddierenHilfsPY = vektorY*(1/ratioX);
			double xP = ausgangsLinie.getStart().getX() + zuAddierenHilfsPX;
			double yP = ausgangsLinie.getStart().getY() + zuAddierenHilfsPY;
			//System.out.println("Hilfspunkt P"+i+": "+xP+"/"+yP);
			double ratio = laenge/(gegeben.get(i).getY()/umrechnungRelation);
			//System.out.println("Ratio Punkt "+i+" "+ratio);
			double zuAddierenX = normalenVektorX*(1/ratio);
			//System.out.println("zuAddieren PX: "+zuAddierenPX+" normalenVektorX: "+normalenVektorX);
			double zuAddierenY = normalenVektorY*(1/ratio);
			double p1X = xP+zuAddierenX;
			double p1Y = yP+zuAddierenY;
			ergebnisse.add(new Point2D(p1X, p1Y));
		}
		//Endpunkt ist auch klar
		ergebnisse.add(new Point2D(ausgangsLinie.getEnd().getX(), ausgangsLinie.getEnd().getY()));
		//dann die Punkte mit Linien verbinden
		List<Linie> prodLinien = new ArrayList<>();
		for (int i=0; i<ergebnisse.size(); i++) {
			if (!(i+1 == ergebnisse.size())) {
				prodLinien.add(new Linie(ergebnisse.get(i).getX(), ergebnisse.get(i).getY(), ergebnisse.get(i+1).getX(), ergebnisse.get(i+1).getY()));
			} else {
				continue;
			}
		}
		this.prodLinien = prodLinien;
	}

}
