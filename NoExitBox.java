package kochkurven;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Kann benutzt werden, um dem User eine aufploppende Meldung anzuzeigen, die er erst abhandeln muss, bevor er weitermachen kann
 * @author Lukas
 * @version 1.0
 */
public class NoExitBox {

	static boolean answer; // true fuer Bleiben, false fuer Exit
	
	/**
	 * Laesst die NoExitBox aufploppen und erwartet vom Nutzer per Button-Click eine Antwort
	 * Unterdrueckt alle anderen Fenster dieses Programms
	 * @param title Fenstertitel der Meldung
	 * @param message Nachricht, die dem User angezeigt wird
	 * @param buttonText Text des Buttons
	 * @return die Entscheidung des Nutzers
	 */
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
		
		window.setOnCloseRequest(e -> {
			answer = true;
			window.close();
		});
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
	
	/**
	 * Laesst ein kleines Fenster erscheinen, das eine Nachricht fuer den User enthaelt, und der nur Schliessen kann
	 * @param title Titel des Fensters
	 * @param message Nachricht fuer den User
	 */
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
