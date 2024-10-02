import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quick extends JFrame implements ActionListener {
    JButton enter, back, b1, b2, b3, b4, b5, b6;
    JTextField t1;
    String pin;
    String selectedAmount = ""; // Variable to store selected amount

    public Quick(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);

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

        b1 = new JButton("100");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.CYAN);
        b1.setBounds(160, 400, 120, 30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("500");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.CYAN);
        b2.setBounds(400, 400, 120, 30);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("1000");
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.CYAN);
        b3.setBounds(160, 440, 120, 30);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("5000");
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.CYAN);
        b4.setBounds(400, 440, 120, 30);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("10000");
        b5.setForeground(Color.BLACK);
        b5.setBackground(Color.CYAN);
        b5.setBounds(160, 480, 120, 30);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("20000");
        b6.setForeground(Color.BLACK);
        b6.setBackground(Color.CYAN);
        b6.setBounds(400, 480, 120, 30);
        b6.addActionListener(this);
        image.add(b6);

        enter = new JButton("Enter");
        enter.setBounds(160, 520, 90, 30);
        enter.setBackground(Color.decode("#4CAF50"));
        enter.setForeground(Color.white);
        enter.addActionListener(this);
        image.add(enter);

        back = new JButton("Back");
        back.setBounds(420, 520, 90, 30);
        back.setBackground(Color.decode("#F44336"));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            selectedAmount = "100";
            t1.setText(selectedAmount);
        } else if (ae.getSource() == b2) {
            selectedAmount = "500";
            t1.setText(selectedAmount);
        } else if (ae.getSource() == b3) {
            selectedAmount = "1000";
            t1.setText(selectedAmount);
        } else if (ae.getSource() == b4) {
            selectedAmount = "5000";
            t1.setText(selectedAmount);
        } else if (ae.getSource() == b5) {
            selectedAmount = "10000";
            t1.setText(selectedAmount);
        } else if (ae.getSource() == b6) {
            selectedAmount = "20000";
            t1.setText(selectedAmount);
        } else if (ae.getSource() == enter) {
            if (!selectedAmount.isEmpty()) {
                Conn c = new Conn();
                try {
                    ResultSet rs = c.s.executeQuery("SELECT * FROM deposit WHERE pin='" + pin + "'");
                    double balance = 0; // Change to double
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Double.parseDouble(rs.getString("amount")); // Use Double
                        } else {
                            balance -= Double.parseDouble(rs.getString("amount")); // Use Double
                        }
                    }
                    if (balance < Double.parseDouble(selectedAmount)) { // Use Double
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                    } else {
                        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                        String query = "INSERT INTO deposit (pin, date, amount, type) VALUES ('" + pin + "', '" + date + "', '" + selectedAmount + "', 'withdrawal')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Successfully withdrawn: " + selectedAmount);
                        new Transaction(pin); // Proceed to the Transaction screen
                        setVisible(false);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select an amount first.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin);
        }
    }

    public static void main(String[] args) {
        new Quick("");
    }
}
