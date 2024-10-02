import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener {
    JButton enter, clear, back;
    JTextField t1;
    String pin;
    Withdrawal(String pin) {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        setLayout(null);
        setLocation(300, 0);
        setSize(900, 900);

        JLabel text = new JLabel("Enter Amount");
        text.setBounds(160, 350, 200, 50);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        text.setForeground(Color.decode("#3F51B5"));
        image.add(text);

        t1 = new JTextField("");
        t1.setBounds(290, 360, 200, 30);
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        image.add(t1);

        enter = new JButton("Enter");
        enter.setBounds(160, 410, 90, 30);
        enter.setBackground(Color.decode("#4CAF50"));
        enter.setForeground(Color.white);
        enter.addActionListener(this);
        image.add(enter);

        clear = new JButton("Clear");
        clear.setBounds(290, 410, 90, 30);
        clear.setBackground(Color.decode("#FF9800"));
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        image.add(clear);

        back = new JButton("Back");
        back.setBounds(420, 410, 90, 30);
        back.setBackground(Color.decode("#F44336"));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
           if (ae.getSource() == enter) {
            String amount = t1.getText();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // Formatting date

            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an amount");
            } else {
                try {
                    Conn c = new Conn();
                    String query = "INSERT INTO deposit (pin, date, amount, type) VALUES ('" + pin + "', '" + date + "', '" + amount + "', 'withdrawl')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Deposit successful: " + amount);
                    t1.setText(""); // Clear input after successful deposit
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
                }
            }
        } else if (ae.getSource() == clear) {
            t1.setText(""); // Clear the text field
        } else if (ae.getSource() == back) {
            new Transaction(pin); // Ensure this class is defined
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
