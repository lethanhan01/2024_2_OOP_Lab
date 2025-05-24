package hust.soict.hedspi.aims.screen.customer.controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewStoreController {
	private Store store;
	public ViewStoreController() {
		this.store = new Store();
	}

    @FXML
    private GridPane gridPane;

    @FXML
	void btnViewCartPressed(ActionEvent event) {
		// TODO Auto-generated method stub
		// new ViewCartScreen(cart);
		// dispose();
		try {
			final String CART_FXML_FILE_PATH = "hust/soict/hedspi/test/aims/screen/customer/view/Cart.fxml";
			FXMLLoader fmxLoader = new FXMLLoader(getClass().getClassLoader().getResource(CART_FXML_FILE_PATH));
			Parent root = fmxLoader.load();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Cart");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public void initialize() {
		// Initialize the grid pane or any other components if needed
		// This method can be used to set up the initial state of the view
    	final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
    	int column = 0;
    	int row = 1;
    	for(int i = 0; i < store.getItemsInStore().size(); i++) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource(STORE_FXML_FILE_PATH));
				ItemController itemController = new ItemController();
				fxmlLoader.setController(itemController);
				AnchorPane anchorPane = fxmlLoader.load();
				anchorPane = fxmlLoader.load();
				itemController.setData(store.getItemsInStore().get(i));

				if(column == 3) {
					column = 0;
					row++;
				}
				gridPane.add(anchorPane, column++, row);
				GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
