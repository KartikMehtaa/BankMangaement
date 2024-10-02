import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Check extends JFrame implements ActionListener {
    JLabel balanceLabel;
    JTextField balanceField;
    JButton backButton;
    String pin;

    Check(String pin) {
        this.pin = pin; // Store the provided pin

        // Load and scale the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setLayout(null);  // Set layout to null for absolute positioning

        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);  // Size according to the image
        setLocation(300, 0);
        setContentPane(imageLabel); // Add the image label as content pane

        // Create and configure balance label
        balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(160, 350, 200, 50);
        balanceLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        balanceLabel.setForeground(Color.decode("#3F51B5"));
        imageLabel.add(balanceLabel);

        // Create and configure balance text field
        balanceField = new JTextField();
        balanceField.setBounds(290, 360, 180, 30);
        balanceField.setBackground(Color.white);
        balanceField.setForeground(Color.black);
        balanceField.setEditable(false); // Make the field non-editable
        imageLabel.add(balanceField);

        // Create and configure back button
        backButton = new JButton("Back");
        backButton.setBounds(420, 460, 90, 30);
        backButton.setBackground(Color.decode("#F44336"));
        backButton.setForeground(Color.white);
        backButton.addActionListener(this);
        imageLabel.add(backButton);

        // Connect to the database and fetch the balance
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM deposit WHERE pin='" + pin + "'");
            double balance = 0; // Initialize balance
            while (rs.next()) {
                // Sum the balance based on the type of transaction
                if (rs.getString("type").equals("Deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            // Set the calculated balance in the text field
            balanceField.setText(String.valueOf(balance)); // Display the balance
            rs.close(); // Close ResultSet
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions
        }

        setVisible(true); // Make the frame visible after setup
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            new Transaction(pin);  // Pass the actual pin
            setVisible(false); 
        }
    }

    public static void main(String[] args) {
        new Check("pin"); 
    }
}
