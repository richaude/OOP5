package kochkurven;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Display {
	// Positionen nochmal justieren, Kommunikation zu Verwaltung innnerhalb Verwaltung, ZeichneLinien-Button
	private Verwaltung verwaltung;
	private Stage stage;
	private VBox layoutLeft;
	private StackPane layoutRight;
	private SplitPane layoutControl;
	private Label successInitiator;
	private Label successGenerator;
	
	
	public Display(Stage stage) {
		this.stage = stage;
		this.verwaltung = new Verwaltung(this);
		
		// Layouts einrichten, Freezen!
		layoutLeft = new VBox();
		layoutRight = new StackPane();
		layoutControl = new SplitPane(layoutLeft, layoutRight);
	}
	
	
	public void start() {
		
		//Scene Initialisieren
		
		Scene scene = new Scene(layoutControl, 1000, 700);
		
		// Divider Setzen 
		layoutControl.setDividerPosition(0, 0.24);
		
		
		//
		//
		// Zuerst die Linke Seite:
		//
		//
		
		
		// Elemente
		
			// Labels
																				//	TextFlow text = new TextFlow();
			
			Label startTextLabel = new Label("Kochkurven - Programm");
			Label initiatorLabel1 = new Label("Initiators:");
			Label initiatorLabel2 = new Label("Zu verwendende Punkte (Custom):");
			Label generatorLabel1 = new Label("Generators:");
			Label generatorLabel2 = new Label("Zu verwendende Punkte (Custom):");
			successInitiator = new Label("Initiator erfolgreich aufgenommen!");
			successGenerator = new Label("Generator erfolgreich aufgenommen!");
			
			// PlaceHolders
			Label placeHolder1 = new Label("");
			Label placeHolder2 = new Label("");
			Label placeHolder3 = new Label("");
			Label placeHolder4 = new Label("");
			Label placeHolder5 = new Label("");
			Label placeHolder6 = new Label("");
			Label placeHolder7 = new Label("");
			Label placeHolder8 = new Label("");
			Label placeHolder9 = new Label("");
			Label placeHolder10 = new Label("");
			Label placeHolder11 = new Label("");
			Label placeHolder12 = new Label("");


			// RadioButtons
			
			RadioButton initiator1 = new RadioButton("Gerade Linie");
			RadioButton initiator2 = new RadioButton("Quadrat mit Kurven aussen");
			RadioButton initiator3 = new RadioButton("Quadrat mit Kurven innen");
			RadioButton initiator4 = new RadioButton("Gleichseitiges Dreieck");
			RadioButton initiatorCustom = new RadioButton("Custom - Initiator");
			RadioButton generator1 = new RadioButton("Generator 1");
			RadioButton generator2 = new RadioButton("Generator 2");
			RadioButton generatorCustom= new RadioButton("Custom - Generator");
			
			
			// TextBoxes
			
			TextField initiatorPoints = new TextField();
			TextField generatorPoints = new TextField();
			
			// Buttons
			
			Button calculateInitiator = new Button("Berechne Initiator");
			Button calculateGenerator = new Button("Berechne Generator");
			Button starteBerechnung = new Button("Kalkuliere Kurven");
			Button exportScreenshot = new Button("Exportiere Bilddatei");
			Button quitProgramm = new Button("Beende das Programm");
			// ToggleGroups -> Nur ein RadioButton darf aktiviert sein
			
			ToggleGroup toggleInitiators = new ToggleGroup();
			ToggleGroup toggleGenerators = new ToggleGroup();

			// Fuer Initiatoren
			
			initiator1.setToggleGroup(toggleInitiators);
			initiator2.setToggleGroup(toggleInitiators);
			initiator3.setToggleGroup(toggleInitiators);
			initiator4.setToggleGroup(toggleInitiators);
			initiatorCustom.setToggleGroup(toggleInitiators);
		
			// Fuer Generatoren
			
			generator1.setToggleGroup(toggleGenerators);
			generator2.setToggleGroup(toggleGenerators);
			generatorCustom.setToggleGroup(toggleGenerators);
			
		
		// Waehl schon mal einen RadioButton pro ToggleGroup aus
		
		initiator1.setSelected(true);
		generator1.setSelected(true);
		
		
		// Hinzufuegen der Elemente zum Layout Links
		
		layoutLeft.getChildren().add(startTextLabel);
		layoutLeft.getChildren().add(placeHolder8);
		layoutLeft.getChildren().add(initiatorLabel1);
		layoutLeft.getChildren().add(placeHolder5);
		layoutLeft.getChildren().add(initiator1);
		layoutLeft.getChildren().add(initiator2);
		layoutLeft.getChildren().add(initiator3);
		layoutLeft.getChildren().add(initiator4);
		layoutLeft.getChildren().add(initiatorCustom);
		layoutLeft.getChildren().add(placeHolder1);
		layoutLeft.getChildren().add(initiatorLabel2);
		layoutLeft.getChildren().add(initiatorPoints);
		layoutLeft.getChildren().add(placeHolder3);
		layoutLeft.getChildren().add(calculateInitiator);
		
		layoutLeft.getChildren().add(placeHolder7);

		layoutLeft.getChildren().add(generatorLabel1);
		layoutLeft.getChildren().add(placeHolder6);
		layoutLeft.getChildren().add(generator1);
		layoutLeft.getChildren().add(generator2);
		layoutLeft.getChildren().add(generatorCustom);
		layoutLeft.getChildren().add(placeHolder2);
		layoutLeft.getChildren().add(generatorLabel2);
		layoutLeft.getChildren().add(generatorPoints);
		layoutLeft.getChildren().add(placeHolder4);
		layoutLeft.getChildren().add(calculateGenerator);
		layoutLeft.getChildren().add(placeHolder9);
		layoutLeft.getChildren().add(starteBerechnung);
		layoutLeft.getChildren().add(placeHolder12);
		
		layoutLeft.getChildren().add(successInitiator);
		layoutLeft.getChildren().add(successGenerator);
		layoutLeft.getChildren().add(placeHolder10);
		layoutLeft.getChildren().add(exportScreenshot);
		layoutLeft.getChildren().add(placeHolder11);
		layoutLeft.getChildren().add(quitProgramm);
		
		// Ausrichtung der Elemente bearbeiten
		
		startTextLabel.setTranslateX(32.0);
		initiatorLabel1.setTranslateX(4.0);
		initiator1.setTranslateX(3.0);
		initiator2.setTranslateX(3.0);
		initiator3.setTranslateX(3.0);
		initiator4.setTranslateX(3.0);
		initiatorCustom.setTranslateX(3.0);
		initiatorLabel2.setTranslateX(4.0);
		calculateInitiator.setTranslateX(42.0);
		
		generatorLabel1.setTranslateX(4.0);
		generator1.setTranslateX(3.0);
		generator2.setTranslateX(3.0);
		generatorCustom.setTranslateX(3.0);
		generatorLabel2.setTranslateX(4.0);
		calculateGenerator.setTranslateX(42.0);
		successInitiator.setTranslateX(23.0);
		successGenerator.setTranslateX(19.0);
		starteBerechnung.setMinSize(180.0, 45.0);
		starteBerechnung.setTranslateX(30.0);
		exportScreenshot.setTranslateX(41.0);
		quitProgramm.setTranslateX(39.0);
		
		// Sichtbarkeit
		
		successInitiator.setVisible(false);
		successGenerator.setVisible(false);
		initiatorPoints.setDisable(true);
		generatorPoints.setDisable(true);
		
		// Button - Funktionalitaet
		
		starteBerechnung.setOnAction(e -> {
			this.verwaltung.verwalten();
		});
		
		// Berechne Initiator
		calculateInitiator.setOnAction(e -> {
			String eingabeInitiator = new String("");
			String eingabe;
			boolean innen = false;
			
			if(toggleInitiators.getSelectedToggle().equals(initiator1)) {
				// Gerade Linie
				eingabeInitiator = "";
				innen = false;
				eingabe = "1" + eingabeInitiator;
			}
			else if(toggleInitiators.getSelectedToggle().equals(initiator2)) {
				// Quadrat, Kurven aussen
				eingabeInitiator = "";
				innen = false;
				eingabe = "2" + eingabeInitiator;
			}
			else if(toggleInitiators.getSelectedToggle().equals(initiator3)) {
				// Quadrat, Kurven innen
				eingabeInitiator = "";
				innen = true;
				eingabe = "3" + eingabeInitiator;
			}
			else if(toggleInitiators.getSelectedToggle().equals(initiator4)) {
				//	Gleichseitiges Dreieck
				eingabeInitiator = "";
				innen = false;
				eingabe = "4" + eingabeInitiator;
			}
			else {
				// Initiator Custom, unterscheide noch Kurvenrichtung
				 eingabeInitiator = initiatorPoints.getText();
				 // Ermittle Kurvenrichtung
				 eingabe = "5" + eingabeInitiator;
			}
			
		
			System.out.println(eingabe); // Ersichtlichkeit der Button-Funktionalitaet
			// EIngabe, Innen
			
			verwaltung.initInitiator(eingabe, innen);
		});
		
		// Berechne Generator
		calculateGenerator.setOnAction(e -> {
			String eingabeGenerator;
			int code;
			
			if(toggleGenerators.getSelectedToggle().equals(generator1)) {
				// Generator 1
				code = 0;
				eingabeGenerator = "";
			}
			else if(toggleGenerators.getSelectedToggle().equals(generator2)) {
				// Generator 2
				code = 1;
				eingabeGenerator = "";
			}
			else {
				// Generator Custom
				code = 2;
				eingabeGenerator = generatorPoints.getText();
			}
			
			verwaltung.initGenerator(code, eingabeGenerator);
			
			System.out.println(eingabeGenerator); // Debug
		});
		
		
		// Screenshot
		exportScreenshot.setOnAction(e -> { 	// Funktioniert noch nicht

			//StackPane shotPane = layoutRight;
			//Scene shotScene = new Scene(layoutRight);	
			WritableImage image = scene.snapshot(null);
			Boolean worked = true;
			String s = new String("Snapshot.png");
			File outputfile = new File(s);
			
			try {
				ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outputfile);
			}
			catch(IOException ioex) {
				System.out.println("Fail");
				worked = false;
			}
			if(worked) {
				// Schreibe Erfolgsmeldung!
				NoExitBox.display("Save-Info", "Datei " + s + " erfolgreich gespeichert!");
			}
		});
		
		quitProgramm.setOnAction(e -> {
			boolean answer = NoExitBox.display("Tu das nicht....", "Willst du das Programm Wirklich beenden?", "Schliesse das Fenster");
			if(!answer) {
				Platform.exit();
			}
		});
		
		
		// Radio-Button Funktionalitaet
			// Fuer Initiatoren
		toggleInitiators.selectedToggleProperty().addListener(e -> {
			if(toggleInitiators.getSelectedToggle().equals(initiatorCustom)) {
				initiatorPoints.setDisable(false);
			}
			else {
				initiatorPoints.setDisable(true);
			}
		});
			// Fuer Generatoren
		toggleGenerators.selectedToggleProperty().addListener(e -> {
			if(toggleGenerators.getSelectedToggle().equals(generatorCustom)) {
				generatorPoints.setDisable(false);
			}
			else {
				generatorPoints.setDisable(true);
			}
		});
		
		
		//
		//
		// Jetzt die rechte Seite:
		// Pane ist layoutRight
		//
		
		// Elemente
		
			// Text
		
		//	Text t1 = new Text("haaaalllellllulllja");
		
		//	t1.setFill(Color.RED);
		//	t1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
			
		//	layoutRight.getChildren().add(t1);
		
				
		//
		//
		// Abschluss
		//
		//
		
		// Stage bearbeiten
		stage.setTitle("Kochkurven - stetige, aber undifferenzierbare Funktionen!");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
			
		// Penetrantes Exit-Verhinderen 
		stage.setOnCloseRequest(e -> {
			boolean answer = NoExitBox.display("Tu das nicht....", "Willst du das Programm Wirklich beenden?", "Schliesse das Fenster");
			if(answer) {
				// Bleiben
				e.consume();
			}
		});
	}
	
	public void communicate(String message) {
		// Tu aufgrund von message etwas
		System.out.println(message);
		
		
		if(message.equals("Initiator erfolgreich berechnet.")) {
			successInitiator.setVisible(true);
		}
		else if(message.equals("Initiator konnte nicht berechnet werden.")) {
			successInitiator.setVisible(false);
			//Error-Meldung
			NoExitBox.display("FehlerMeldung - Initiatorberechnung", "Initiator konnte nicht berechnet werden. Bitte pruefen sie ihre Eingabe.");
		}
		else if(message.equals("Generator erfolgreich berechnet.")) {
			successGenerator.setVisible(true);
		}
		else if(message.equals("Generator konnte nicht berechnet werden.")) {
			successGenerator.setVisible(false);
			//Error-Meldung
			NoExitBox.display("FehlerMeldung - Generatorberechnung", "Generator konnte nicht berechnet werden. Bitte pruefen sie ihre Eingabe.");
		}
	}
	
	public void zeichneAlleLinien(List<Linie> linien) {
		// Zeichne alle Linien aus linien
		
		
	}
}
