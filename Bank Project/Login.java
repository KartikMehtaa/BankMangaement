import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    JTextField t1; // Card number field
    JPasswordField t2; // PIN field

    Login() {
        // Frame properties
        setLayout(null);
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("1.jpg"));
        Image I2 = I1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(70, 10, 100, 100);
        
        // Change the content pane color to light gray
        getContentPane().setBackground(Color.decode("#D3D3D3")); // Light gray background
        add(label);

        // Overall interface
        setTitle("Welcome to Bank");
        setSize(900, 500);
        setLocation(350, 200);
        setVisible(true);
        
        JLabel text = new JLabel("WELCOME TO ATM OF KK");
        text.setBounds(200, 70, 500, 30);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.decode("#3F51B5")); // Title color
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setBounds(120, 200, 400, 30);
        cardno.setFont(new Font("Osward", Font.BOLD, 30));
        add(cardno);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120, 260, 400, 40);
        pin.setFont(new Font("Osward", Font.BOLD, 30));
        add(pin);

        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.BOLD, 14));
        t1.setBounds(280, 210, 200, 20);
        add(t1);

        t2 = new JPasswordField();
        t2.setFont(new Font("Arial", Font.BOLD, 14));
        t2.setBounds(280, 270, 200, 20);
        add(t2);

        b1 = new JButton("ENTER");
        b1.setBounds(280, 340, 90, 20);
        b1.setBackground(Color.decode("#4CAF50")); // Changed color
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CLEAR");
        b2.setBounds(400, 340, 90, 20);
        b2.setBackground(Color.decode("#FF9800")); // Changed color
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("SIGN UP");
        b3.setBounds(280, 380, 200, 20);
        b3.setBackground(Color.decode("#2196F3")); // Changed color
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Conn n = new Conn();
            String card = t1.getText(); 
            String pin = t2.getText();

            String query = "SELECT * FROM login WHERE card = '" + card + "' AND pin = '" + pin + "'";
            try {
                ResultSet rs = n.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pin);   
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } else if (ae.getSource() == b2) {
            t1.setText("");
            t2.setText("");
        } else if (ae.getSource() == b3) {
            new Signup();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
