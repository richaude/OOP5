package kochkurven;

import javafx.geometry.Point2D;

/**
 * Eigene Klasse Linie, die Start- und Endkoordinaten beeinhaltet
 * @author Lukas
 * @version 1.0
 */
public class Linie {

	private double startX;
	private double startY;
	private double endX;
	private double endY;
	
	/**
	 * Traegt alle Koordinaten in der Linien-Instanz ein und erzeugt diese
	 * @param startX Start-X-Koordinate
	 * @param startY Start-Y-Koordinate
	 * @param endX End-X-Koordinate
	 * @param endY End-Y-Koordinate
	 */
	public Linie(double startX, double startY, double endX, double endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	/**
	 * Gibt die Laenge dieser Linien-Instanz zurueck
	 * @return Laenge dieser Linie
	 */
	public double getLaenge() {
		double length = Math.sqrt(Math.pow((endX-startX), 2.0)+Math.pow((endY-startY), 2.0));
		return length;
	}
	
	/**
	 * Gibt den Start-Punkt der Linie zurueck
	 * @return Start-Punkt
	 */
	public Point2D getStart() {
		Point2D start = new Point2D(startX, startY);
		return start;
	}
	
	/**
	 * Gibt den End-Punkt der Linie zurueck 
	 * @return End-Punkt
	 */
	public Point2D getEnd() {
		Point2D end = new Point2D(endX, endY);
		return end;
	}
	
	/**
	 * Gibt den Mittel-Punkt der Linie zurueck
	 * @return Mittel-Punkt
	 */
	public Point2D getMitte() {
		double x = (startX+endX)/2;
		double y = (startY+endY)/2;
		Point2D point = new Point2D(x, y);
		return point;
	}
	
	/**
	 * Ermoeglicht das Setzen der Anfangs-und Endkoordinaten der Linie
	 * @param neuStartX neue Start-X-Koordinate
	 * @param neuStartY neue Start-Y-Koordinate
	 * @param neuEndX neue End-X-Koordinate
	 * @param neuEndY neue End-Y-Koordinate
	 */
	public void setLinie(double neuStartX, double neuStartY, double neuEndX, double neuEndY) {
		startX = neuStartX;
		startY = neuStartY;
		endX = neuEndX;
		endY = neuEndY;
	}
	
	
	/**
	 * Gibt die String-Repraesentation der Linie zurueck
	 */
	public String toString() {
		String finalString = new String("Linie von (" + this.startX +","+this.startY+") zu ("+this.endX+","+this.endY+")");	
		return finalString;
	}	
}
