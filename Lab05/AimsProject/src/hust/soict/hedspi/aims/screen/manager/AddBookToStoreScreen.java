package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private static final long serialVersionUID = 1L;

    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthor;
    private JTextArea authorsArea;
    private ArrayList<String> authors = new ArrayList<>();

    public AddBookToStoreScreen(Store store, Cart cart) {
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

        fieldsPanel.add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        fieldsPanel.add(tfCost);

        // Authors panel
        JPanel authorsPanel = new JPanel(new BorderLayout());
        authorsPanel.setBorder(BorderFactory.createTitledBorder("Authors"));

        JPanel authorInputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        authorInputPanel.add(new JLabel("Author:"));
        tfAuthor = new JTextField(20);
        authorInputPanel.add(tfAuthor);

        JButton addAuthorButton = new JButton("Add Author");
        addAuthorButton.addActionListener(new AddAuthorButtonListener());


        authorsArea = new JTextArea(10, 40);
        authorsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(authorsArea);

        authorsPanel.add(authorInputPanel, BorderLayout.NORTH);
        authorsPanel.add(addAuthorButton, BorderLayout.CENTER);
        authorsPanel.add(scrollPane, BorderLayout.SOUTH);

        // Button panel
        JPanel buttonsPanel = new JPanel();
        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new AddBookButtonListener());
        buttonsPanel.add(addBookButton);

        // Assemble the center panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fieldsPanel, BorderLayout.NORTH);
        topPanel.add(authorsPanel, BorderLayout.CENTER);

        center.add(topPanel, BorderLayout.CENTER);
        center.add(buttonsPanel, BorderLayout.SOUTH);

        return center;
    }

    @Override
    protected String getScreenTitle() {
        return "Add Book to Store";
    }

    private class AddAuthorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String author = tfAuthor.getText().trim();

            if (!author.isEmpty()) {
                authors.add(author);
                authorsArea.append(author + "\n");
                tfAuthor.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter an author name");
            }
        }
    }

    private class AddBookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = tfTitle.getText();
            String category = tfCategory.getText();

            try {
                float cost = Float.parseFloat(tfCost.getText());

                // Create new book
                Book book = new Book(title, category, cost);

                // Add all authors to book
                for (String author : authors) {
                    book.addAuthor(author);
                }

                // Add book to store
                store.addMedia(book);

                JOptionPane.showMessageDialog(null, "Book added successfully");

                // Clear fields after adding
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfAuthor.setText("");
                authorsArea.setText("");
                authors.clear();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid cost format. Please enter a number.");
            }
        }
    }
}