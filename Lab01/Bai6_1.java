package bai6_1;

import javax.swing.JOptionPane;

public class Bai6_1 {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}