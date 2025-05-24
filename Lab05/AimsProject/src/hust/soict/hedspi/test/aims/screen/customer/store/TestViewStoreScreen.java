package hust.soict.hedspi.test.aims.screen.customer.store;

import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	@Override
	public void start(Stage stage) throws Exception {
		final String fxmlFile = "viewStoreScreen.fxml";
	}

	public static void main(String[] args) {
		Store store = new Store();
		launch(args);
	}



}
