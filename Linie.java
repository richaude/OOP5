package kochkurven;

import javafx.geometry.Point2D;

public class Linie {

	private double startX;
	private double startY;
	private double endX;
	private double endY;
	
	public Linie(double startX, double startY, double endX, double endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	public double getLaenge() {
		double length = Math.sqrt(Math.pow((endX-startX), 2.0)+Math.pow((endY-startY), 2.0));
		return length;
	}
	
	public Point2D getStart() {
		Point2D start = new Point2D(startX, startY);
		return start;
	}
	
	public Point2D getEnd() {
		Point2D end = new Point2D(endX, endY);
		return end;
	}
	
	public Point2D getMitte() {
		double x = (startX+endX)/2;
		double y = (startY+endY)/2;
		Point2D point = new Point2D(x, y);
		return point;
	}
}
