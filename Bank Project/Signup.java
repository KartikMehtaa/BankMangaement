
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener {
    long random;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JRadioButton op1, op2, op3, o1, o2;
    JButton next;

    Signup() {
        setTitle("Welcome to Signup Page");
        setSize(600, 600);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);

        // Generating a random application form number
        Random ran = new Random();
        random = (Math.abs((ran.nextLong() % 9000L) + 1000L));
        JLabel pageno = new JLabel("Application form number ~" + random);
        pageno.setBounds(500, 20, 900, 30);
        pageno.setFont(new Font("OSWARD", Font.BOLD, 28));
        add(pageno);

        JLabel page = new JLabel("Pageno-1");
        page.setBounds(650, 50, 900, 30);
        page.setFont(new Font("OSWARD", Font.BOLD, 18));
        add(page);

        // Name label and text field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 80, 80, 25);
        add(nameLabel);
        t1 = new JTextField();
        t1.setBounds(100, 80, 165, 25);
        t1.setFont(new Font("Arial", Font.BOLD, 12));
        add(t1);

        // Contact No label and text field
        JLabel contactLabel = new JLabel("Contact No:");
        contactLabel.setBounds(10, 120, 80, 25);
        add(contactLabel);
        t2 = new JTextField();
        t2.setBounds(100, 120, 165, 25);
        t2.setFont(new Font("Arial", Font.BOLD, 12));
        add(t2);

        // Nationality label and text field
        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setBounds(10, 160, 80, 25);
        add(nationalityLabel);
        t3 = new JTextField();
        t3.setBounds(100, 160, 165, 25);
        t3.setFont(new Font("Arial", Font.BOLD, 12));
        add(t3);

        // Address label and text field
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 200, 80, 25);
        add(addressLabel);
        t4 = new JTextField();
        t4.setBounds(100, 200, 165, 25);
        t4.setFont(new Font("Arial", Font.BOLD, 12));
        add(t4);

        // Gender label
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(10, 240, 80, 25);
        add(genderLabel);

        // Gender radio buttons
        op1 = new JRadioButton("Male");
        op1.setBounds(100, 240, 80, 25);
        add(op1);
        op2 = new JRadioButton("Female");
        op2.setBounds(180, 240, 80, 25);
        add(op2);
        op3 = new JRadioButton("Other");
        op3.setBounds(260, 240, 80, 25);
        add(op3);

        // Group radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(op1);
        genderGroup.add(op2);
        genderGroup.add(op3);

        // Father Name label and text field
        JLabel fatherNameLabel = new JLabel("Father Name:");
        fatherNameLabel.setBounds(10, 280, 100, 25);
        add(fatherNameLabel);
        t5 = new JTextField();
        t5.setBounds(100, 280, 165, 25);
        t5.setFont(new Font("Arial", Font.BOLD, 12));
        add(t5);

        // Mother Name label and text field
        JLabel motherNameLabel = new JLabel("Mother Name:");
        motherNameLabel.setBounds(10, 320, 100, 25);
        add(motherNameLabel);
        t6 = new JTextField();
        t6.setBounds(100, 320, 165, 25);
        t6.setFont(new Font("Arial", Font.BOLD, 12));
        add(t6);

        // Pincode label and text field
        JLabel pincodeLabel = new JLabel("Pincode:");
        pincodeLabel.setBounds(10, 360, 80, 25);
        add(pincodeLabel);
        t7 = new JTextField();
        t7.setBounds(100, 360, 165, 25);
        t7.setFont(new Font("Arial", Font.BOLD, 12));
        add(t7);

        // Date of Birth label and text field
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(10, 400, 100, 25);
        add(dobLabel);
        t8 = new JTextField();
        t8.setBounds(100, 400, 165, 25);
        t8.setFont(new Font("Arial", Font.BOLD, 12));
        add(t8);

        // Marital Status label
        JLabel maritalStatusLabel = new JLabel("Marital Status:");
        maritalStatusLabel.setBounds(10, 440, 100, 25);
        add(maritalStatusLabel);

        o1 = new JRadioButton("Single");
        o1.setBounds(100, 440, 80, 25);
        add(o1);
        o2 = new JRadioButton("Married");
        o2.setBounds(200, 440, 80, 25);
        add(o2);

        // Group marital status radio buttons
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(o1);
        maritalGroup.add(o2);

        // Email label and text field
        JLabel emailLabel = new JLabel("Email ID:");
        emailLabel.setBounds(10, 480, 80, 25);
        add(emailLabel);
        t9 = new JTextField();
        t9.setBounds(100, 480, 165, 25);
        t9.setFont(new Font("Arial", Font.BOLD, 12));
        add(t9);

        // Nominee Name label and text field
        JLabel nomineeLabel = new JLabel("Nominee Name:");
        nomineeLabel.setBounds(10, 520, 100, 25);
        add(nomineeLabel);
        t10 = new JTextField();
        t10.setBounds(100, 520, 165, 25);
        t10.setFont(new Font("Arial", Font.BOLD, 12));
        add(t10);

        // Next button
        next = new JButton("NEXT");
        next.setBounds(400, 600, 80, 30);
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setFont(new Font("Arial", Font.BOLD, 12));
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent ae) {
        String form = "" + random;
        String name = t1.getText();
        String contact = t2.getText();
        String nationality = t3.getText();
        String address=t4.getText();
        String fatherName = t5.getText();
        String motherName = t6.getText();
        String pincode = t7.getText();
        String dob = t8.getText();
        String email = t9.getText();
        String nominee = t10.getText();


        String gender = "null";
        if (op1.isSelected()) {
            gender = "Male";
        } else if (op2.isSelected()) {
            gender = "Female";
        } else if (op3.isSelected()) {
            gender = "Other";
        }

        String married = "null";
        if (o1.isSelected()) {
            married = "Single";
        } else if (o2.isSelected()) {
            married = "Married";
        }

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty");
                return; 
            }
            Conn n = new Conn(); // Assuming Conn handles the database connection
            String query = "INSERT INTO signup values ('"+form+"','"+name+"','"+contact+"','"+address+"','"+nationality+"','"+fatherName+"','"+pincode+"','"+dob+"','"+email+"','"+motherName+"','"+nominee+"','"+gender+"','"+married+"')";
            n.s.executeUpdate(query);
            setVisible(false);
            new Signup2(form).setVisible(true);
        } catch (Exception e){
          System.out.println(e);
        }
      }

        public static void main(String[] args) {
          new Signup();
     }
 }
 