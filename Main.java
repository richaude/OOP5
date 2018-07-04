package kochkurven;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Startklasse fuer die virtuelle Maschine
 * @author Lukas
 * @version 1.0
 */
public class Main extends Application {

	
	/**
	 * Standart-Konstruktor 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Einsprungspunkt der virutellen Maschine
	 * @param args Argumente der Kommandozeile
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	/**
	 * gibt den Start-Call der Application-Klasse weiter ans Display
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Display display = new Display(primaryStage);
		display.start();
	}

}
