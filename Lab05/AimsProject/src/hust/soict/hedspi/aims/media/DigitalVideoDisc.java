package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import javax.swing.*;
import java.awt.*;

public class DigitalVideoDisc extends Disc implements Playable {
	// Attributes
	private String title;
	private String category;
	private float cost;
	// Added attributes
	private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    // Getters and setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Constructors - now properly chained
    public DigitalVideoDisc(String title) {
        this(title, "Unknown", 0.0f); // Calls 3-arg constructor
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost); // Calls full constructor
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, director, 0, cost); // Calls full constructor
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); // Initialize Media fields
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director +
               " - " + length + ": " + getCost() + "$";
    }

    public boolean isMatch(int id) {
        return getId() == id;
    }

    public boolean isMatch(String title) {
        if (title == null || getTitle() == null) return false;
        String[] tmp = title.split(" ");
        for (String s : tmp) {
            if (s != null && getTitle().toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

	public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        } else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel p = new JPanel();
            JDialog d = new JDialog();
            JLabel l1 = new JLabel("Now playing: " + this.getTitle());
            JLabel l2 = new JLabel("DVD length: " + this.getLength());
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            l1.setAlignmentX(Component.CENTER_ALIGNMENT);
            l2.setAlignmentX(Component.CENTER_ALIGNMENT);
            d.setTitle("Media Player");
            p.add(Box.createVerticalGlue());
            p.add(l1);
            p.add(l2);
            p.add(Box.createVerticalGlue());
            d.add(p);
            d.setSize(250,100);
            int w = d.getSize().width;
            int h = d.getSize().height;
            int x = (dim.width - w) / 2;
            int y = (dim.height - h) / 2;
            d.setLocation(x, y);
            d.setVisible(true);
        }
	}
}