package hust.soict.hedspi.test.aims.screen.customer.controller;

import java.awt.*;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

public class ItemController {
	private Media media;
	@FXML
	private Button btnPlay;
	@FXML
	private Node btnAddToCart;
	@FXML
	private Label lbTitle;
	@FXML
	private Label lbCategory;
	@FXML
	private ImageView imgMedia;
	public void setData(Media media) {
		this.media = media;
		lbTitle.setText(media.getTitle());
		lbCategory.setText(media.getCategory() + "$");
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
			Insets inset  =new Insets(0, 0, 0, 60);
			HBox.setMargin(btnAddToCart, inset);
		}
	}

}