package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
private static final long serialVersionUID = 1L;

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new BorderLayout());

        // Input fields panel
        JPanel fieldsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        fieldsPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        fieldsPanel.add(tfTitle);

        fieldsPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        fieldsPanel.add(tfCategory);

        fieldsPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField(20);
        fieldsPanel.add(tfDirector);

        fieldsPanel.add(new JLabel("Length:"));
        tfLength = new JTextField(20);
        fieldsPanel.add(tfLength);

        fieldsPanel.add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        fieldsPanel.add(tfCost);

        // Button panel
        JPanel buttonsPanel = new JPanel();
        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new AddDVDButtonListener());
        buttonsPanel.add(addButton);

        center.add(fieldsPanel, BorderLayout.CENTER);
        center.add(buttonsPanel, BorderLayout.SOUTH);

        return center;
    }

    @Override
    protected String getScreenTitle() {
        return "Add DVD to Store";
    }

    private class AddDVDButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = 0;
            float cost = 0.0f;

            try {
                length = Integer.parseInt(tfLength.getText());
                cost = Float.parseFloat(tfCost.getText());

                // Create new DVD and add to store
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(null, "DVD added successfully");

                // Clear fields after adding
                tfTitle.setText("");
                tfCategory.setText("");
                tfDirector.setText("");
                tfLength.setText("");
                tfCost.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format. Please enter numbers for length and cost.");
            }
        }
    }

}
