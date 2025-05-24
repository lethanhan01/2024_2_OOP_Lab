package hust.soict.program.javafx;

import java.awt.Color;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Painter extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("painter.fxml"));
		Pane drawingAreaPane = new Pane();

		Scene scene = new Scene(root);
		stage.setTitle("Painter");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
