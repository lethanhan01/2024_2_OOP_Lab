package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.exception.DupplicatedItemException;
import javax.swing.*;
import java.awt.*;

public class Track implements Playable  {

	private String artist;
	private int length;
	private String title;

	public String getArtist() {
		return artist;
	}

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public Track(String title, int length, String artist) {
		this.title = title;
		this.length = length;
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Track [title=" + getTitle() + ", artist=" + artist + ", length=" + length + "]";
	}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: Track length is non-positive!");
		} else {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());

			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			JLabel l2 = new JLabel("Track length: " + this.getLength());
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
//
//		// TODO Auto-generated method stub
//        System.out.println("Playing Track: " + title);
//        System.out.println("Track length: " + length);
	}
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track track = (Track) obj;
			return track.title.equals(this.title) && track.length == this.length;
		}
		return false;
	}
}
