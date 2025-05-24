package hust.soict.hedspi.aims.screen.customer.controller;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewStoreController {

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

}
