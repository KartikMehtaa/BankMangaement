import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton b1, b2, b3,  b5, b6, b7;
   String pin;
   public Transaction(String pin) {
        this.pin=pin;
        // Frame properties
        setTitle("Transaction");
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using null layout for custom positioning

        // Load and scale the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);

        // Create and add label with the background image
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0, 0, 900, 900);
        add(label);

        // Add transaction selection text
        JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setBounds(200, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setForeground(Color.YELLOW); // Changed text color to yellow
        label.add(text);

        // Add buttons with new colors
        b1 = new JButton("Withdrawal");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.CYAN);
        b1.setBounds(160, 400, 120, 30);
        b1.addActionListener(this); // Action listener added
        label.add(b1);

        b2 = new JButton("Deposit");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.CYAN);
        b2.setBounds(400, 400, 120, 30);
        b2.addActionListener(this); // Action listener added
        label.add(b2);

        b3 = new JButton("Check Balance");
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.CYAN);
        b3.setBounds(160, 500, 120, 30);
        b3.addActionListener(this); // Action listener added
        label.add(b3);

       

        b5 = new JButton("Quick Cash");
        b5.setForeground(Color.BLACK);
        b5.setBackground(Color.CYAN);
        b5.setBounds(400, 450, 120, 30);
        b5.addActionListener(this); // Action listener added
        label.add(b5);

        b6 = new JButton("Change PIN");
        b6.setForeground(Color.BLACK);
        b6.setBackground(Color.CYAN);
        b6.setBounds(160, 450, 120, 30);
        b6.addActionListener(this); // Action listener added
        label.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.BLACK);
        b7.setBackground(Color.CYAN);
        b7.setBounds(400, 500, 120, 30);
        b7.addActionListener(this); // Action listener added
        label.add(b7);

        // Set visibility after adding all components
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b7) {
            System.exit(0);
        } else if (ae.getSource() == b1) {
            new Withdrawal("");
            setVisible(false);
        } else if (ae.getSource()==b2) {
            new Deposit(pin).setVisible(true);;
            setVisible(false);
        }else if (ae.getSource()==b6) {
            new Changepin(pin);
            setVisible(false);
            
        }
        else if (ae.getSource()==b3) {
            new Check(pin);
            setVisible(false);
        }
       else  {
            JOptionPane.showMessageDialog(this, "Feature not implemented yet.");
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
