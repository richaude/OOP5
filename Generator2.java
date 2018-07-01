package kochkurven;

import java.util.ArrayList;
import java.util.List;

public class Generator2 extends Generator {

	public Generator2(Linie linie, double minL) {
		super(linie, minL);
		// TODO Auto-generated constructor stub
	}

	public Generator2() {
		super();
		this.minL = 1.0;
	}
	
	@Override
	public void produziereLinien(boolean innen) {
		Linie ausgangsLinie = getLinie();
		double vektorX = ausgangsLinie.getEnd().getX()-ausgangsLinie.getStart().getX();
		double vektorY = ausgangsLinie.getEnd().getY()-ausgangsLinie.getStart().getY();
		double laenge = ausgangsLinie.getLaenge();
		double vektorXzuP = vektorX*0.4;
		double vektorYzuP = vektorY*0.4;
		//System.out.println("VektorXzuP: "+vektorXzuP+" vektorYzuP: "+vektorYzuP);
		double xP = ausgangsLinie.getStart().getX() + vektorXzuP;
		double yP = ausgangsLinie.getStart().getY() + vektorYzuP;
		//P und Q sind beides Hilfspunkte auf der ausgangsLinie, mit O bezeichne ich den Startpunkt der Linie
		//System.out.println("P-Koordinaten: "+xP + " "+ yP);
		double normalenVektorX;
		double normalenVektorY;
		if (!innen) { //ja, hab ich erst verwechselt
			normalenVektorX = vektorY;
			normalenVektorY = -vektorX;
		} else {
			normalenVektorX = -vektorY;
			normalenVektorY = vektorX;
		}
		Linie nullZuP = new Linie(ausgangsLinie.getStart().getX(), ausgangsLinie.getStart().getY(), xP, yP);
		double laengeOP = nullZuP.getLaenge();
		//System.out.println("Länge OP "+laengeOP);
		double ratio = laenge/(laengeOP/2);
		//System.out.println("ratio: "+ratio);
		double zuAddierenX = normalenVektorX*(1/ratio);
		//System.out.println("zuAddieren PX: "+zuAddierenPX+" normalenVektorX: "+normalenVektorX);
		double zuAddierenY = normalenVektorY*(1/ratio);
		double p1X = xP+zuAddierenX;
		double p1Y = yP+zuAddierenY;
		//System.out.println("Punkt P1, p1X: "+p1X+" p1Y: "+p1Y); //stimmt jetzt
		//jetzt haben wir den ersten Punkt, P1
		double vektorXzuQ = vektorX*0.6;
		double vektorYzuQ = vektorY*0.6;
		double xQ = ausgangsLinie.getStart().getX() + vektorXzuQ;
		double yQ = ausgangsLinie.getStart().getY() + vektorYzuQ;
		//System.out.println("Punkt Q: X="+xQ+" Y="+yQ);
		double p2X = xQ+zuAddierenX;
		double p2Y = yQ+zuAddierenY;
		//wir haben den zweiten Punkt, P2
		//System.out.println("Punkt P2: X="+p2X+" Y="+p2Y);
		Linie line1 = new Linie(ausgangsLinie.getStart().getX(), ausgangsLinie.getStart().getY(), p1X, p1Y);
		Linie line2 = new Linie(p1X, p1Y, p2X, p2Y);
		Linie line3 = new Linie(p2X, p2Y, ausgangsLinie.getEnd().getX(), ausgangsLinie.getEnd().getY());
		
		List<Linie> prodLinien = new ArrayList<Linie>();
		prodLinien.add(line1);
		prodLinien.add(line2);
		prodLinien.add(line3);
		this.prodLinien = prodLinien;
	}

}
