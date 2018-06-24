package kochkurven;

import java.util.List;

public class Generator1 extends Generator {

	public Generator1(Linie linie, double minL) {
		super(linie, minL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void produziereLinien() {
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
		//erste Variante, hier würde der Boolean ins Spiel kommen, so zeigt es nach innen (oder unten)
		double richtungsVektorNormaleX = -vektorY; //oder eben +vektorY fuer aussen
		double richtungsVektorNormaleY = vektorX; //oder eben -vektorX
		double ratioGesamtstreckeVsSeitenhalbierende = laenge/dreiecksHalbierende;
		double zuAddierenX = richtungsVektorNormaleX*(1/ratioGesamtstreckeVsSeitenhalbierende);
		double zuAddierenY = richtungsVektorNormaleY*(1/ratioGesamtstreckeVsSeitenhalbierende);
		double xSpitze = xMittelpunkt+zuAddierenX;
		double ySpitze = yMittelpunkt+zuAddierenY;
		Linie line1 = new Linie(ausgangsLinie.getStart().getX(), ausgangsLinie.getStart().getY(), xDrittel1, yDrittel1);
		Linie line2 = new Linie(xDrittel1, yDrittel1, xSpitze, ySpitze);
		Linie line3 = new Linie(xSpitze, ySpitze, xDrittel2, yDrittel2);
		Linie line4 = new Linie(xDrittel2, yDrittel2, ausgangsLinie.getEnd().getX(), ausgangsLinie.getEnd().getY());
		List<Linie> prodLinien = getLinien();
		prodLinien.add(line1);
		prodLinien.add(line2);
		prodLinien.add(line3);
		prodLinien.add(line4);
	}

}
