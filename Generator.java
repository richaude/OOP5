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
	
	public Generator() {
		
	}
	
	public abstract void produziereLinien(boolean innen);

	public List<Linie> getLinien() {
		prodLinien = new ArrayList<Linie>();
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

}
