package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private static final long serialVersionUID = 1L;

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfArtist;
    private JTextField tfCost;
    private JTextField tfTrackTitle;
    private JTextField tfTrackLength;
    private JTextArea tracksArea;
    private ArrayList<Track> tracks = new ArrayList<>();

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new BorderLayout());

        // CD Info Panel
        JPanel cdInfoPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        cdInfoPanel.setBorder(BorderFactory.createTitledBorder("CD Information"));

        cdInfoPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        cdInfoPanel.add(tfTitle);

        cdInfoPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        cdInfoPanel.add(tfCategory);

        cdInfoPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField(20);
        cdInfoPanel.add(tfArtist);

        cdInfoPanel.add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        cdInfoPanel.add(tfCost);

        // Track Info Panel
        JPanel trackPanel = new JPanel(new BorderLayout());
        trackPanel.setBorder(BorderFactory.createTitledBorder("Track Information"));

        JPanel trackInputPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        trackInputPanel.add(new JLabel("Track Title:"));
        tfTrackTitle = new JTextField(20);
        trackInputPanel.add(tfTrackTitle);

        trackInputPanel.add(new JLabel("Track Length:"));
        tfTrackLength = new JTextField(20);
        trackInputPanel.add(tfTrackLength);

        JButton addTrackButton = new JButton("Add Track");
        addTrackButton.addActionListener(new AddTrackButtonListener());

        tracksArea = new JTextArea(10, 40);
        tracksArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tracksArea);

        trackPanel.add(trackInputPanel, BorderLayout.NORTH);
        trackPanel.add(addTrackButton, BorderLayout.CENTER);
        trackPanel.add(scrollPane, BorderLayout.SOUTH);

        // Button panel
        JPanel buttonsPanel = new JPanel();
        JButton addCDButton = new JButton("Add CD to Store");
        addCDButton.addActionListener(new AddCDButtonListener());
        buttonsPanel.add(addCDButton);

        // Add panels to center
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(cdInfoPanel, BorderLayout.NORTH);
        topPanel.add(trackPanel, BorderLayout.CENTER);

        center.add(topPanel, BorderLayout.CENTER);
        center.add(buttonsPanel, BorderLayout.SOUTH);

        return center;
    }

    @Override
    protected String getScreenTitle() {
        return "Add CD to Store";
    }

    private class AddTrackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = tfTrackTitle.getText();

            try {
                int length = Integer.parseInt(tfTrackLength.getText());

                Track track = new Track(title, length);
                tracks.add(track);

                tracksArea.append("Track: " + title + " - Length: " + length + "\n");

                // Clear track input fields
                tfTrackTitle.setText("");
                tfTrackLength.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid track length. Please enter a number.");
            }
        }
    }

    private class AddCDButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String artist = tfArtist.getText();

            try {
                float cost = Float.parseFloat(tfCost.getText());

                // Create new CD and add tracks
                CompactDisc cd = new CompactDisc(title, category, cost, artist);

                // Add all tracks to CD
                for (Track track : tracks) {
                    cd.addTrack(track);
                }

                // Add CD to store
                store.addMedia(cd);

                JOptionPane.showMessageDialog(null, "CD added successfully");

                // Clear all fields
                tfTitle.setText("");
                tfCategory.setText("");
                tfArtist.setText("");
                tfCost.setText("");
                tfTrackTitle.setText("");
                tfTrackLength.setText("");
                tracksArea.setText("");
                tracks.clear();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid cost format. Please enter a number.");
            }
        }
    }
}