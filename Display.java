package kochkurven;
// Mehrfaches Zeichnen ermoeglichen
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Display {
	
	private Verwaltung verwaltung;
	private Stage stage;
	private VBox layoutLeft;
	private Pane layoutRight;
	private SplitPane layoutControl;
	private BorderPane layoutUpside;
	private Label successInitiator;
	private Label successGenerator;
	private Paint paintColor;
	
	
	public Display(Stage stage) {
		this.stage = stage;
		this.verwaltung = new Verwaltung(this);
		
		// Layouts einrichten
		layoutUpside = new BorderPane();
		layoutLeft = new VBox();
		layoutRight = new Pane();
		layoutControl = new SplitPane(layoutLeft, layoutRight);
		paintColor = Color.RED;
	}
	
	
	public void start() {
		
		//Scene Initialisieren
		
		Scene scene = new Scene(layoutUpside, 1000, 710);
		layoutUpside.setCenter(layoutControl);
		
		// MenuBar
		MenuBar menuBar = new MenuBar();	
		
		//	Menu
		Menu optionMenu = new Menu("Options"); 

		// MenuItems
		MenuItem m1 = new MenuItem("Export Snapshot");
		MenuItem m2 = new MenuItem("Quit Programm");
		MenuItem separator = new SeparatorMenuItem();
		
		// Linking
		optionMenu.getItems().addAll(m1,separator,m2);
		menuBar.getMenus().add(optionMenu);
		layoutUpside.setTop(menuBar);
		
		// Funktionalitaet
		m2.setOnAction(e -> {
			boolean answer = NoExitBox.display("Really=?", "Willst du das Programm Wirklich beenden?", "Schliesse das Fenster...");
			if(!answer) {
				Platform.exit();
			}
		});
		
		// Screenshot
		m1.setOnAction(e -> { 	// Funktioniert noch nicht

			//Stage shotStage = new Stage();

			WritableImage image = scene.snapshot(null);
			Boolean worked = true;
			String s = new String("Snapshot");
			File outputfile = new File(s + new Date().getTime() +".png");
			
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
		
		
		// Divider Setzen und freezen
		double dividerPos = 0.305;
		layoutControl.setDividerPosition(0, dividerPos);
		Divider d = layoutControl.getDividers().get(0);
		d.positionProperty().addListener(e -> {
			d.setPosition(dividerPos);
		});
		
		//
		//
		// Zuerst die Linke Seite:
		//
		//
		
		
		// Elemente
		
			// Labels
																		
			Label startTextLabel = new Label("Kochkurven - Programm");
			Label initiatorLabel1 = new Label("Initiators:");
			Label initiatorLabel2 = new Label("Zu verwendende Werte (Custom):");
			Label initiatorLabel3 = new Label("Eingabe-Maske:    '(a.b,c.d);(e.f,g.h);...;innen'");
			Label initiatorLabel4 = new Label("Am Schluss Ausrichtung der Linien! (Innen/Aussen)");
			Label generatorLabel1 = new Label("Generators:");
			Label generatorLabel2 = new Label("Zu verwendende Werte (Custom):");
			Label generatorLabel3 = new Label("Eingabe-Maske:    '(0.0,a.b);(c.d,e.f);...;(x.y,1.0);minLaenge'");
			Label linienFarbe = new Label("Linienfarbe:");
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
			
			// ColorPicker
			
			ColorPicker colorPicker = new ColorPicker();
			colorPicker.setValue(Color.RED);
			colorPicker.setDisable(true);
			
			// TextBoxes
			
			TextField initiatorPoints = new TextField();
			TextField generatorPoints = new TextField();
			
			// Buttons
			
			Button calculateInitiator = new Button("Berechne Initiator");
			Button calculateGenerator = new Button("Berechne Generator");
			Button starteBerechnung = new Button("Kalkuliere Kurven");
			
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
		layoutLeft.getChildren().add(initiatorLabel3);
		layoutLeft.getChildren().add(initiatorLabel4);
		layoutLeft.getChildren().add(placeHolder4);
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
		layoutLeft.getChildren().add(generatorLabel3);
		layoutLeft.getChildren().add(placeHolder3);
		layoutLeft.getChildren().add(calculateGenerator);
		layoutLeft.getChildren().add(placeHolder9);
		layoutLeft.getChildren().add(starteBerechnung);
		layoutLeft.getChildren().add(placeHolder12);
		
		layoutLeft.getChildren().add(successInitiator);
		layoutLeft.getChildren().add(successGenerator);
		layoutLeft.getChildren().add(placeHolder10);
		layoutLeft.getChildren().add(linienFarbe);
		layoutLeft.getChildren().add(colorPicker);
		
		// Ausrichtung der Elemente bearbeiten
		
		startTextLabel.setTranslateX(70.0);
		initiatorLabel1.setTranslateX(4.0);
		initiator1.setTranslateX(3.0);
		initiator2.setTranslateX(3.0);
		initiator3.setTranslateX(3.0);
		initiator4.setTranslateX(3.0);
		initiatorCustom.setTranslateX(3.0);
		initiatorLabel2.setTranslateX(4.0);
		initiatorLabel3.setTranslateX(4.0);
		initiatorLabel4.setTranslateX(4.0);
		calculateInitiator.setTranslateX(85.0);
		
		generatorLabel1.setTranslateX(4.0);
		generator1.setTranslateX(3.0);
		generator2.setTranslateX(3.0);
		generatorCustom.setTranslateX(3.0);
		generatorLabel2.setTranslateX(4.0);
		generatorLabel3.setTranslateX(4.0);
		calculateGenerator.setTranslateX(85.0);
		successInitiator.setTranslateX(57.0);
		successGenerator.setTranslateX(53.0);
		starteBerechnung.setMinSize(180.0, 45.0);
		starteBerechnung.setTranslateX(60.0);
		
		linienFarbe.setTranslateX(10.0);
		colorPicker.setMinHeight(25);
		colorPicker.setTranslateX(162.0);
		colorPicker.setTranslateY(-21.0);
		
		// Sichtbarkeit
		
		successInitiator.setVisible(false);
		successGenerator.setVisible(false);
		initiatorPoints.setDisable(true);
		generatorPoints.setDisable(true);
		
		// Button - Funktionalitaet
		
		starteBerechnung.setOnAction(e -> {
			//zeichneAlleLinien(new ArrayList<Linie>());
			this.verwaltung.verwalten();
		});
		
		// Berechne Initiator
		calculateInitiator.setOnAction(e -> {
			String eingabe;
			//this.layoutRight = new StackPane();
			if(toggleInitiators.getSelectedToggle().equals(initiator1)) {
				// Gerade Linie
				eingabe = "(10.0,0.0);(600.0,0.0);aussen";
			}
			else if(toggleInitiators.getSelectedToggle().equals(initiator2)) {
				// Quadrat, Kurven aussen
				eingabe = "(160.0,-200.0);(460.0,-200.0);(460.0,100.0);(160.0,100.0);(160.0,-200);aussen";
			}
			else if(toggleInitiators.getSelectedToggle().equals(initiator3)) {
				// Quadrat, Kurven innen
				eingabe = "(160.0,-200.0);(460.0,-200.0);(460.0,100.0);(160.0,100.0);(160.0,-200);innen";
			}
			else if(toggleInitiators.getSelectedToggle().equals(initiator4)) {
				//	Gleichseitiges Dreieck
				eingabe = "(0.0,-260);(300,259.6);(600.0,-260.0);(0.0,-260.0);aussen";
			}
			else {
				// Initiator Custom, unterscheide noch Kurvenrichtung,
				eingabe = initiatorPoints.getText();
					// Ermittle Kurvenrichtung
			}		
			//	System.out.println(eingabe); // Ersichtlichkeit der Button-Funktionalitaet
			// EIngabe, Innen
			verwaltung.initInitiator(eingabe);
			
			// ColorPicker aktivieren
			if(this.successInitiator.isVisible() && this.successGenerator.isVisible()) {
				colorPicker.setDisable(false);
			}	
		});
		
		// Berechne Generator
		calculateGenerator.setOnAction(e -> {
			String eingabe;
			int code;
			
			if(toggleGenerators.getSelectedToggle().equals(generator1)) {
				// Generator 1
				code = 0;
				eingabe = "";
			}
			else if(toggleGenerators.getSelectedToggle().equals(generator2)) {
				// Generator 2
				code = 1;
				eingabe = "";
			}
			else {
				// Generator Custom
				code = 2;
				eingabe = generatorPoints.getText();
			}
			verwaltung.initGenerator(code, eingabe);
			
			// ColorPicker aktivieren
			if(this.successInitiator.isVisible() && this.successGenerator.isVisible()) {
				colorPicker.setDisable(false);
			}	
		});
		
		// Faerbe richtig die Linien
		
		colorPicker.setOnAction(e -> {
			this.paintColor = colorPicker.getValue();	
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
		
		
		// Debug
		//List<Linie> lul = new ArrayList<Linie>();
		//	lul.add(new Linie(10, 0, 100, 0));
		//zeichneAlleLinien(lul);
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
		// Momentane Linien clearen
		for(Node n : this.layoutRight.getChildren()) {
			n.setVisible(false);
		}
		
		// Neue Linien Zeichnen
		
		double xOffset = 50.0;
		double yOffset = 350.0;
		// Zeichne alle Linien aus linien
		for(Linie l : linien) {
			// Erzeuge Linien und zentriere sie
			Line line = new Line(l.getStart().getX()+ xOffset,l.getStart().getY() + yOffset,l.getEnd().getX() + xOffset,l.getEnd().getY() + yOffset);
			
			line.setStroke(this.paintColor);
			this.layoutRight.getChildren().add(line);
		}
		System.out.println("Erfolgreich gezeichnet");
	}
}
