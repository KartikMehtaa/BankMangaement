import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton cancel, submit;
    String form;

    Signup3(String form) {
        this.form = form;
        setLayout(null);
        setSize(600, 600);
        setLocation(300, 200);
        setTitle("Signup - Page 3");
        getContentPane().setBackground(Color.white);
        setVisible(true);

        JLabel ad = new JLabel("Account Details");
        ad.setFont(new Font("Raleway", Font.BOLD, 28));
        ad.setBounds(180, 10, 300, 40);
        add(ad);

        JLabel k = new JLabel("Page-3");
        k.setFont(new Font("Raleway", Font.PLAIN, 12));
        k.setBounds(260, 50, 100, 20);
        add(k);

        JLabel type = new JLabel("Account Type:");
        type.setBounds(10, 80, 200, 28);
        type.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(10, 110, 200, 28);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(10, 140, 200, 28);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setBounds(10, 170, 200, 28);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(10, 200, 200, 28);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.PLAIN, 18));
        card.setBounds(10, 240, 300, 40);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-0001");
        number.setFont(new Font("Raleway", Font.PLAIN, 18));
        number.setBounds(200, 240, 300, 40);
        add(number);

        JLabel pin = new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway", Font.PLAIN, 18));
        pin.setBounds(10, 280, 300, 40);
        add(pin);

        JLabel nu = new JLabel("XXXX");
        nu.setFont(new Font("Raleway", Font.PLAIN, 18));
        nu.setBounds(200, 280, 300, 40);
        add(nu);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.PLAIN, 18));
        services.setBounds(10, 320, 300, 40);
        add(services);

        c1 = new JCheckBox("ATM");
        c1.setFont(new Font("Raleway", Font.PLAIN, 18));
        c1.setBounds(10, 360, 200, 28);
        add(c1);

        c2 = new JCheckBox("Online Banking");
        c2.setFont(new Font("Raleway", Font.PLAIN, 18));
        c2.setBounds(10, 390, 200, 28);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.PLAIN, 18));
        c3.setBounds(10, 420, 200, 28);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setFont(new Font("Raleway", Font.PLAIN, 18));
        c4.setBounds(10, 450, 200, 28);
        add(c4);

        c5 = new JCheckBox("SMS Notifications");
        c5.setFont(new Font("Raleway", Font.PLAIN, 18));
        c5.setBounds(10, 480, 200, 28);
        add(c5);

        c6 = new JCheckBox("Cheque Book");
        c6.setFont(new Font("Raleway", Font.PLAIN, 18));
        c6.setBounds(10, 510, 200, 28);
        add(c6);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Raleway", Font.BOLD, 18));
        submit.setBounds(150, 540, 100, 30);
        add(submit);
        submit.addActionListener(this);

        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBounds(300, 540, 100, 30);
        add(cancel);
        cancel.addActionListener(this);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String type = null;
            if (r1.isSelected()) {
                type = "Saving Account";  
            } else if (r2.isSelected()) {
                type = "Current Account";
            } else if (r3.isSelected()) {
                type = "Fixed Deposit Account";
            } else if (r4.isSelected()) {
                type = "Recurring Deposit Account";
            }

            String card = "" + Math.abs((new Random().nextLong() % 9000000L) + 4090121100000000L);
            String pin = "" + Math.abs((new Random().nextLong() % 9000L) + 1000L);
            String service = "";

            if (c1.isSelected()) service += "ATM, ";
            if (c2.isSelected()) service += "Online Banking, ";
            if (c3.isSelected()) service += "Mobile Banking, ";
            if (c4.isSelected()) service += "Email Alerts, ";
            if (c5.isSelected()) service += "SMS Notifications, ";
            if (c6.isSelected()) service += "Cheque Book, ";

            // Trim the last comma and space
            if (service.length() > 0) {
                service = service.substring(0, service.length() - 2);
            }

            try {
                if (type == null) {
                    JOptionPane.showMessageDialog(null, "Account type is required.");
                } else if (service.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "At least one service is required.");
                } else {
                    Conn c = new Conn();
                    String query = "INSERT INTO signup3 VALUES ('" + form + "','" + type + "','" + card + "','" + pin + "','" + service + "')";
                    String query1 = "INSERT INTO login VALUES ('" + card + "','" + pin + "')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Card Number: " + card + "\nPin: " + pin);
                    setVisible(false);
                    new Signup3(form); // Or navigate to the next step
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            // Close the form
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
