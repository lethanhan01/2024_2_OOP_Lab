package hust.soict.hedspi.aims.screen.customer.controller;

import java.awt.event.ActionEvent;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.*;

public class CartController {
	private Cart cart;
	public CartController(Cart cart) {
		this.cart = cart;
	}

    @FXML
    private TableColumn<?, ?> colMediaId;

    @FXML
    private TableView<?> tblMedia;

    @FXML
    private TableColumn<?, ?> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<?, ?> colMediaTitle;

    @FXML
    private TableColumn<?, ?> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = (Media) tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }

    @FXML
    public void initialize() {
		// TODO Auto-generated method stub
		colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

		btnPlay.setDisable(false);
		btnRemove.setDisable(false);
		Media newValue = null;
		tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			updateButtonBar(newValue);
		});

	}

	private void updateButtonBar(Media media) {
		// TODO Auto-generated method stub
		if (media != null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		} else {
			btnRemove.setVisible(true);

			if (media instanceof Playable) {
				btnPlay.setVisible(true);;
			} else {
				btnPlay.setVisible(false);
			}
		}
	}
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
