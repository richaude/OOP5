package kochkurven;

import javafx.geometry.Point2D;

public class Linie {

	private double mitteX;
	private double mitteY;
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	
	public Linie(double mitteX, double mitteY, double startX, double startY, double endX, double endY) {
		this.mitteX = mitteX;
		this.mitteY = mitteY;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	public double getLaenge() {
		//Berechnung pls
		return 1.0;
	}
	public Point2D getMitte() {
		Point2D point = new Point2D(mitteX, mitteY);
		return point;
	}
}
