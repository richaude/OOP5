package kochkurven;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Display {
	
	private Stage stage;
	
	public Display(Stage stage) {
		this.stage = stage;
	}
	
	
	public void start() {
		
		// Init
		
		this.stage.setTitle("Kochkurven - stetige, aber undifferenzierbare Funktionen!");
		
		
		// Layouts einrichten, Freezen!
		VBox layoutLeft = new VBox();
		StackPane layoutRight = new StackPane();
		
		SplitPane layoutControl = new SplitPane(layoutLeft, layoutRight);

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
			Label successInitiators = new Label("Initiator erfolgreich aufgenommen!");
			Label successGenerators = new Label("Generator erfolgreich aufgenommen!");
			
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
		layoutLeft.getChildren().add(successInitiators);
		layoutLeft.getChildren().add(successGenerators);
		
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
		successInitiators.setTranslateX(6.0);
		successGenerators.setTranslateX(6.0);
		
		// Sichtbarkeit
		
		successInitiators.setVisible(false);
		successGenerators.setVisible(false);
		initiatorPoints.setDisable(true);
		generatorPoints.setDisable(true);
		
		// Button - Funktionalitaet
		
		calculateInitiator.setOnAction(e -> {
			String eingabeInitiator = initiatorPoints.getText();
			System.out.println(eingabeInitiator); // Ersichtlichkeit der Button-Funktionalitaet
		});
		
		calculateGenerator.setOnAction(e -> {
			String eingabeGenerator = generatorPoints.getText();
			System.out.println(eingabeGenerator); // Ersichtlichkeit der Button-Funktionalitaet
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
		
		//Scene Initialisieren
		
		Scene scene = new Scene(layoutControl, 900, 600);
		
		this.stage.setScene(scene);
		this.stage.show();
	}

}
