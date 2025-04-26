package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	protected Store store;
	protected Cart cart;
    private static final long serialVersionUID = 1L;

	public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        // Set up container
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Add components to the container
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Set frame properties
        setTitle(getScreenTitle());
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(new ViewStoreListener());
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new AddBookListener());
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new AddCDListener());
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new AddDVDListener());
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Abstract methods to be implemented by subclasses
    protected abstract JPanel createCenter();
    protected abstract String getScreenTitle();

	// Event listeners for menu items
    private class ViewStoreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new StoreManagerScreen(store, cart);
            dispose();
        }
    }

    private class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddBookToStoreScreen(store, cart);
            dispose();
        }
    }

    private class AddCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddCompactDiscToStoreScreen(store, cart);
            dispose();
        }
    }

    private class AddDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddDigitalVideoDiscToStoreScreen(store, cart);
            dispose();
        }
    }

}
