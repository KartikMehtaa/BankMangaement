import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Changepin extends JFrame implements ActionListener {
    JButton enter, back, clear;
    JTextField t1, t2;
    String pin;

    Changepin(String Pinchange) {
        this.pin = Pinchange; // Store the current PIN

        // Set up the JFrame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add components
        JLabel text = new JLabel("Enter New Pin");
        text.setBounds(160, 350, 200, 50);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        text.setForeground(Color.decode("#3F51B5"));
        image.add(text);

        t1 = new JTextField();
        t1.setBounds(290, 360, 180, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        image.add(t1);

        JLabel repin = new JLabel("Re-enter Pin");
        repin.setBounds(160, 400, 200, 50);
        repin.setFont(new Font("Raleway", Font.BOLD, 18));
        repin.setForeground(Color.decode("#3F51B5"));
        image.add(repin);

        t2 = new JTextField();
        t2.setBounds(290, 420, 180, 30);
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        image.add(t2);

        enter = new JButton("Enter");
        enter.setBounds(160, 460, 90, 30);
        enter.setBackground(Color.decode("#4CAF50"));
        enter.setForeground(Color.white);
        enter.addActionListener(this);
        image.add(enter);

        clear = new JButton("Clear");
        clear.setBounds(290, 460, 90, 30);
        clear.setBackground(Color.decode("#FF9800"));
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        image.add(clear);

        back = new JButton("Back");
        back.setBounds(420, 460, 90, 30);
        back.setBackground(Color.decode("#F44336"));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == enter) {
            String newPin = t1.getText();
            String reEnteredPin = t2.getText();

            if (newPin.isEmpty() || reEnteredPin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both pins");
            } else if (!newPin.equals(reEnteredPin)) {
                JOptionPane.showMessageDialog(null, "Pins do not match");
            } else if (newPin.length() < 4) {
                JOptionPane.showMessageDialog(null, "PIN must be at least 4 digits");
            } else {
                // Code to update the PIN in the database
                try {
                    Conn c = new Conn();
                    String query = "UPDATE login SET pin = '" + newPin + "' WHERE pin = '" + pin + "'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "PIN updated successfully");
                    t1.setText(""); 
                    t2.setText(""); 
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
                }
            }
        } else if (ae.getSource() == clear) {
            t1.setText(""); 
            t2.setText("");
        } else if (ae.getSource() == back) {
            new Transaction(pin); 
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Changepin(""); 
    }
}
