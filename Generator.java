package kochkurven;

import java.util.List;

public abstract class Generator {

	private Linie linie;
	private double minL;
	private List<Linie> prodLinien;
	
	
	
	public Generator(Linie linie, double minL) {
		this.linie = linie; 
		this.minL = minL;
	}
	
	public abstract void produziereLinien();

	public List<Linie> getLinien() {
		return this.prodLinien;
	}
	
	public Linie getLinie() {
		return linie;
	}

}
