package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}

	public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);

        this.artist = artist;
        this.tracks = tracks;
    }

	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" already exists in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added.");
        }
    }

	public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been deleted.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" does not exist in the list.");
        }
    }

	public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

	@Override
	public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        } else {
            System.out.println("Playing CD: " + this.getTitle());
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel p = new JPanel();
            JDialog d = new JDialog();
            JLabel l1 = new JLabel("Now playing: " + this.getTitle());
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            l1.setAlignmentX(Component.CENTER_ALIGNMENT);
            d.setTitle("Media Player");
            p.add(Box.createVerticalGlue());
            p.add(l1);
            p.add(Box.createVerticalGlue());
            d.add(p);
            d.setSize(250,100);
            int w = d.getSize().width;
            int h = d.getSize().height;
            int x = (dim.width - w) / 2;
            int y = (dim.height - h) / 2;
            d.setLocation(x, y);
            d.setVisible(true);
            for (Track track: this.tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        }
    }


    public String toString() {
        return "ID: " + this.getId() + " - CD: " + this.getTitle() + " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() + " - Length: " + this.getLength() + " seconds" +
                " - Cost: " + this.getCost() + "$";
    }

}
