package kochkurven;

import java.util.List;

public abstract class Generator {

	private Linie linie;
	protected double minL;
	protected List<Linie> prodLinien;
	
	
	
	public Generator(Linie linie, double minL) {
		this.linie = linie; 
		this.minL = minL;
	}
	
	public Generator() {
		this.linie = new Linie(0,0,0,0);
	}
	
	public abstract void produziereLinien(boolean innen);

	public List<Linie> getLinien() {
		return prodLinien;
	}
	
	public Linie getLinie() {
		return linie;
	}
	
	public void setLinie(double startX, double startY, double endX, double endY) {
		linie.setLinie(startX, startY, endX, endY);
	}
	public void setMinL(double minL) {
		this.minL = minL;
	}
	public double getMinL() {
		return this.minL;
	}

}
