package hust.soict.hedspi.test.aims.screen.customer.store;

import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Stage primaryStage;

	@Override
	public void start(Stage stage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController();
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();

		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

	public static void main(String[] args) {
		Store store = new Store();
		launch(args);
	}



}
