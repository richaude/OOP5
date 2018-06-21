package kochkurven;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NoExitBox {

	static boolean answer; // true fuer Bleiben, false fuer Exit
	
	public static boolean display(String title, String message, String buttonText) {
		Stage window = new Stage();
		Label label = new Label();
		Label placeHolder1 = new Label("");
		Button closeButton = new Button(buttonText);
		Button stayButton = new Button("Verweile hier");
		VBox layout = new VBox();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300.0);
		window.setMaxHeight(115.0);
		label.setText(message);
		layout.getChildren().addAll(label, placeHolder1, closeButton,stayButton);
		layout.setAlignment(Pos.CENTER);
		
		closeButton.setTranslateX(60.0);
		stayButton.setTranslateX(-66.0);
		stayButton.setTranslateY(-25.0);
		
		
		closeButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		stayButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
		
		return answer;
	}
	
	public static void display(String title, String message) {
		Stage window = new Stage();
		Label label = new Label();
		Label placeHolder1 = new Label("");
		Button closeButton = new Button("Schliessen");
		VBox layout = new VBox();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300.0);
		window.setMinHeight(110.0);
		label.setText(message);
		layout.getChildren().addAll(label, placeHolder1, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		closeButton.setOnAction(e -> {
			window.close();
		});
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
	
	}
}
