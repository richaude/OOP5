package kochkurven;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Display {
	
	private Stage stage;
	
	
	public Display(Stage stage) {
		this.stage = stage;
	}
	
	
	public void start() {
		this.stage.setTitle("Kochkurven - stetige, aber undifferenzierbare Funktionen!");
		
		StackPane layoutLeft = new StackPane();
		StackPane layoutRight = new StackPane();
		
		SplitPane layoutControl = new SplitPane(layoutLeft, layoutRight);

		Label callMeTestLeft = new Label("THis is a Test! -> I am Left");
		Label callMeTestRight = new Label("THis is a Test! -> I am Right");
		
		layoutLeft.getChildren().add(callMeTestLeft);
		layoutRight.getChildren().add(callMeTestRight);
		
		Scene scene = new Scene(layoutControl, 500, 500);
		
		this.stage.setScene(scene);
		this.stage.show();
		
		
		
		
	}

}
