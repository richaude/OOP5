package kochkurven;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
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
		// Divider Setzen und Freezen
		layoutControl.setDividerPosition(0, 0.24);
		layoutControl.setMouseTransparent(true);
		// Elemente
		
			// Labels
			Label startTextLabel = new Label("Kochkurven - Programm");
			Label initiatorLabel1 = new Label("Initiators:");
			Label initiatorLabel2 = new Label("Zu verwendende Punkte (Custom):");
			Label generatorLabel1 = new Label("Generators:");
			Label generatorLabel2 = new Label("Zu verwendende Punkte (Custom):");
		
			// RadioButtons
			
			RadioButton initiator1 = new RadioButton("Initiator 1");
			RadioButton initiator2 = new RadioButton("Initiator 2");
			RadioButton initiator3 = new RadioButton("Initiator 3");
			RadioButton initiator4 = new RadioButton("Initiator 4");
			RadioButton initiatorCustom = new RadioButton("Initiator Custom");
			RadioButton generator1 = new RadioButton("Generator 1");
			RadioButton generator2 = new RadioButton("Generator 2");
			RadioButton generatorCustom= new RadioButton("Generator Custom");
		
			// TextBoxes
			
			TextField initiatorPoints = new TextField();
			TextField generatorPoints = new TextField();
			
			// Buttons
			
			Button calculateInitator = new Button("Berechne Initiator");
			Button calculateGenerator = new Button("Berechne Generator");
			
			
			
			
		// Nur ein RadioButton darf aktiviert sein
		ToggleGroup toggleInitators = new ToggleGroup();
		ToggleGroup toggleGenerators = new ToggleGroup();
		
			// Fuer Initiatoren
			initiator1.setToggleGroup(toggleInitators);
			initiator2.setToggleGroup(toggleInitators);
			initiator3.setToggleGroup(toggleInitators);
			initiator4.setToggleGroup(toggleInitators);
			initiatorCustom.setToggleGroup(toggleInitators);
		
			// Fuer Generatoren
			generator1.setToggleGroup(toggleGenerators);
			generator2.setToggleGroup(toggleGenerators);
			generatorCustom.setToggleGroup(toggleGenerators);
			
		
		// Waehl schon mal einen RadioButton pro ToggleGroup aus
		initiator1.setSelected(true);
		generator1.setSelected(true);
		
		
		// Hinzufuegen der Elemente zum Layout Links
		layoutLeft.getChildren().add(startTextLabel);
		layoutLeft.getChildren().add(initiatorLabel1);
		layoutLeft.getChildren().add(initiator1);
		layoutLeft.getChildren().add(initiator2);
		layoutLeft.getChildren().add(initiator3);
		layoutLeft.getChildren().add(initiator4);
		layoutLeft.getChildren().add(initiatorCustom);
		layoutLeft.getChildren().add(initiatorLabel2);
		layoutLeft.getChildren().add(initiatorPoints);
		layoutLeft.getChildren().add(calculateInitator);
		
		layoutLeft.getChildren().add(generatorLabel1);
		layoutLeft.getChildren().add(generator1);
		layoutLeft.getChildren().add(generator2);
		layoutLeft.getChildren().add(generatorCustom);
		layoutLeft.getChildren().add(generatorLabel2);
		layoutLeft.getChildren().add(generatorPoints);
		layoutLeft.getChildren().add(calculateGenerator);
		
		// Ausrichtung der Elemente bearbeiten

		
		
		
		
		//initiatorLabel1.setTranslateX(5.0);
//		initiatorLabel1.setTranslateY(10);

		
		
		
		
		//Scene Initialisieren
		
		Scene scene = new Scene(layoutControl, 900, 600);
		
		this.stage.setScene(scene);
		this.stage.show();
		
		
		
		
	}

}
