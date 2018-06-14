package kochkurven;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
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
		
		VBox layoutLeft = new VBox();
		StackPane layoutRight = new StackPane();
		
		SplitPane layoutControl = new SplitPane(layoutLeft, layoutRight);

		// Elemente
		Label callMeTestLeft = new Label("THis is a Test! -> I am Left");
		Label callMeTestRight = new Label("THis is a Test! -> I am Right");
		
		ToggleGroup t1 = new ToggleGroup();
		RadioButton initiator1 = new RadioButton("Initiator 1");
		RadioButton initiator2 = new RadioButton("Initiator 2");
		
		initiator1.setToggleGroup(t1);
		initiator2.setToggleGroup(t1);
		// Waehl schon mal einen Aus
		initiator1.setSelected(true);
		
		
		
		// Hinzufuegen
		layoutLeft.getChildren().add(initiator1);
		layoutLeft.getChildren().add(initiator2);
		layoutLeft.getChildren().add(callMeTestLeft);
		layoutRight.getChildren().add(callMeTestRight);
		
		// layoutLeft.setAlignment(callMeTestLeft, Pos.BOTTOM_LEFT);
		
		Scene scene = new Scene(layoutControl, 500, 500);
		
		this.stage.setScene(scene);
		this.stage.show();
		
		
		
		
	}

}
