import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoneyTransfer extends JFrame implements ActionListener {
    JButton transfer, clear, back;
    JTextField recipientField, amountField;
    String pin;

    public MoneyTransfer(String pin) {
        this.pin = pin;
        
        // Set up the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);

        JLabel recipientLabel = new JLabel("Recipient Account Number:");
        recipientLabel.setBounds(160, 350, 250, 30);
        recipientLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        recipientLabel.setForeground(Color.decode("#3F51B5"));
        image.add(recipientLabel);

        recipientField = new JTextField();
        recipientField.setBounds(400, 350, 200, 30);
        image.add(recipientField);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(160, 400, 250, 30);
        amountLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        amountLabel.setForeground(Color.decode("#3F51B5"));
        image.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(400, 400, 180, 30);
        image.add(amountField);

        transfer = new JButton("Transfer");
        transfer.setBounds(160, 460, 120, 30);
        transfer.setBackground(Color.decode("#4CAF50"));
        transfer.setForeground(Color.white);
        transfer.addActionListener(this);
        image.add(transfer);

        clear = new JButton("Clear");
        clear.setBounds(300, 460, 120, 30);
        clear.setBackground(Color.decode("#FF9800"));
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        image.add(clear);

        back = new JButton("Back");
        back.setBounds(440, 460, 120, 30);
        back.setBackground(Color.decode("#F44336"));
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == transfer) {
            String recipient = recipientField.getText();
            String amount = amountField.getText();

            if (recipient.isEmpty() || amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else {
                try{
                    Conn n=new Conn();
                   
                // String query=Select* from deposit
                // n.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Successfully transferred " + amount + " to account " + recipient);
                recipientField.setText("");
                amountField.setText("");
            }
            catch (Exception e) {
                System.out.println(e);
            }
            }
        } else if (ae.getSource() == clear) {
            recipientField.setText("");
            amountField.setText("");
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin); // Assuming you have a Transaction class
        }
    }

    public static void main(String[] args) {
        new MoneyTransfer("");
    }
}
