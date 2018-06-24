package kochkurven;

import java.util.ArrayList;
import java.util.List;

public abstract class Generator {

	private Linie linie;
	private double minL;
	private List<Linie> prodLinien;
	
	
	
	public Generator(Linie linie, double minL) {
		this.linie = linie; 
		this.minL = minL;
	}
	
	public abstract void produziereLinien(boolean innen);

	public List<Linie> getLinien() {
		prodLinien = new ArrayList<Linie>();
		return prodLinien;
	}
	
	public Linie getLinie() {
		return linie;
	}

}
