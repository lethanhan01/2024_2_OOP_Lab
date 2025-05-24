package hust.soict.hedspi.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton [] btnNumbers = new JButton [10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;
	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT);
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButtons(panelButtons);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH); cp.add(panelButtons, BorderLayout.CENTER);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}


	void addButtons (JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for(int i = 1; i <= 9; i++) {
		btnNumbers [i] = new JButton(""+i);
		panelButtons.add(btnNumbers[i]);
		btnNumbers[i].addActionListener(btnListener);
		}
		btnDelete = new JButton("DEL");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		btnNumbers [0] = new JButton("0");
		panelButtons.add(btnNumbers[0]);
		btnNumbers [0].addActionListener(btnListener);
		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
		}


	private class ButtonListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String button = e.getActionCommand();
	        String currentText = tfDisplay.getText();

	        if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
	            // Append the digit to the display
	            tfDisplay.setText(currentText + button);
	        }
	        else if (button.equals("DEL")) {
	            // Handle the "DEL" case - delete last character if not empty
	            if (!currentText.isEmpty()) {
	                tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
	            }
	        }
	        else {
	            // Handle the "C" case - clear all text
	            tfDisplay.setText("");
	        }
	    }
	}
}