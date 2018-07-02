package kochkurven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.geometry.Point2D;

public class GeneratorCustom extends Generator {
	
	private List<Point2D> gegeben;
	private List<Point2D> ergebnisse;
	private List<Linie> prodLinien;

	public GeneratorCustom(Linie linie, double minL) {
		super(linie, minL);
		// TODO Auto-generated constructor stub
	}
	
	public GeneratorCustom() {
		super();
	}
	public GeneratorCustom(List<Point2D> punkte) {
		this.gegeben = punkte;
	}
	
	/**
	 * fuellt eine Liste von Linien mit den aus der Relation der gegebenen Punkte ermittelten Zwischenlinien
	 * @param boolean innen: ob die durch die gegebenen Punkte verursachte Form nach innen (unten) oder aussen (oben) zeigt. Dabei wird angenommen, dass der Startpunkt einer Linie immer links ist. True, falls es nach innen, false falls es nach aussen zeigen soll.
	 */
	@Override
	public void produziereLinien(boolean innen) {
		//bestimme Allgemeines, Vektoren, Normalenvektoren, und sortiere die Punkte in der richtigen Reihenfolge
		Linie ausgangsLinie = getLinie();
		double vektorX = ausgangsLinie.getEnd().getX()-ausgangsLinie.getStart().getX();
		double vektorY = ausgangsLinie.getEnd().getY()-ausgangsLinie.getStart().getY();
		double laenge = ausgangsLinie.getLaenge();
		sortierePunkteAufsteigend();
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
		for (int i=0; i<ergebnisse.size(); i++) {
			if (!(i+1 == ergebnisse.size())) {
				prodLinien.add(new Linie(ergebnisse.get(i).getX(), ergebnisse.get(i).getY(), ergebnisse.get(i+1).getX(), ergebnisse.get(i+1).getY()));
			} else {
				continue;
			}
		}
	}
	
	private void sortierePunkteAufsteigend() {
		Map<Double, Double> xZuY = new HashMap<>();
		for (int i=0; i<gegeben.size(); i++) {
			xZuY.put(gegeben.get(i).getX(), gegeben.get(i).getY());
		}
		List<Double> xWerte = new ArrayList<>();
		for (int i=0; i<gegeben.size(); i++) {
			xWerte.add(gegeben.get(i).getX());
		}
		Collections.sort(xWerte);
		List<Point2D> sortiert = new ArrayList<>();
		for (int i=0; i<xWerte.size(); i++) {
			sortiert.add(new Point2D(xWerte.get(i), xZuY.get(xWerte.get(i))));
		}
		gegeben = sortiert;
		/*for (Point2D p : gegeben) {
			System.out.println(p);
		}*/
	}

}
