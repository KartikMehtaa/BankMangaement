
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signup2 extends JFrame implements ActionListener {
    long random;
    JComboBox<String> religon,category,educationn;
    JTextField t1, t2;
    JRadioButton op1, op2, op3, o1, o2;
    JButton next;

    Signup2(String form) {
        setTitle("Welcome to Signup Page");
        setSize(600, 600);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);

        JLabel page = new JLabel("Pageno-2");
        page.setBounds(650, 50, 900, 30);
        page.setFont(new Font("OSWARD", Font.BOLD, 18));
        add(page);

        // Name label and text field
        JLabel nameLabel = new JLabel("Religon");
        nameLabel.setBounds(10, 80, 120, 25);
        add(nameLabel);
        String[] varrelgion = {"Hindu", "Sikh", "Christian", "Muslim", "Other"};
         religon = new JComboBox<>(varrelgion);
        religon.setBounds(100, 80, 165, 25);
        religon.setFont(new Font("Arial", Font.BOLD, 12));
        add(religon);
        religon.setBackground(Color.white);

        
        // Contact No label and text field
        JLabel contactLabel = new JLabel("Categories:");
        contactLabel.setBounds(10, 120, 80, 25);
        add(contactLabel);
        String[] cat = {"genral", "obc", "sc", "st", "Other"};
        category = new JComboBox<>(cat);
        category.setBounds(100, 80, 165, 25);
        category.setFont(new Font("Arial", Font.BOLD, 12));
        add(category);
        category.setBounds(100, 120, 165, 25);
        category.setFont(new Font("Arial", Font.BOLD, 12));
        category.setBackground(Color.white);

        // Nationality label and text field
        JLabel nationalityLabel = new JLabel("Pan Number:");
        nationalityLabel.setBounds(10, 160, 80, 25);
        add(nationalityLabel);
        t1= new JTextField();
        t1.setBounds(100, 160, 165, 25);
        t1.setFont(new Font("Arial", Font.BOLD, 12));
        add(t1);

        // Address label and text field
        JLabel addressLabel = new JLabel("Aaddhar no");
        addressLabel.setBounds(10, 200, 80, 25);
        add(addressLabel);
        t2 = new JTextField();
        t2.setBounds(100, 200, 165, 25);
        t2.setFont(new Font("Arial", Font.BOLD, 12));
        add(t2);

        // Gender label
        JLabel genderLabel = new JLabel("Existing Account");
        genderLabel.setBounds(10, 240, 80, 25);
        add(genderLabel);

        // Gender radio buttons
        op1 = new JRadioButton("yes");
        op1.setBounds(100, 240, 80, 25);
        add(op1);
        op2 = new JRadioButton("no");
        op2.setBounds(180, 240, 80, 25);
        add(op2);
        
        // Group radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(op1);
        genderGroup.add(op2);

        // Father Name label and text field
        JLabel fatherNameLabel = new JLabel("educational");
        fatherNameLabel.setBounds(10, 280, 100, 25);
        add(fatherNameLabel);
        String[] education = {"graduate", "intemidate", "highschool", "Other"};
         educationn = new JComboBox<>(education);
        add(educationn);
        educationn.setBounds(100, 280, 165, 25);
        educationn.setFont(new Font("Arial", Font.BOLD, 12));
        educationn.setBackground(Color.white);

        // Marital Status label
        JLabel maritalStatusLabel = new JLabel("senior citizen");
        maritalStatusLabel.setBounds(10, 320, 100, 25);
        add(maritalStatusLabel);

        o1 = new JRadioButton("yes");
        o1.setBounds(100, 320, 80, 25);
        add(o1);
        o2 = new JRadioButton("no");
        o2.setBounds(200, 320, 80, 25);
        add(o2);

        // Group marital status radio buttons
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(o1);
        maritalGroup.add(o2);

        
        next = new JButton("Submit");
        next.setBounds(400, 440, 80, 30);
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setFont(new Font("Arial", Font.BOLD, 12));
        next.addActionListener(this);
        add(next);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String form=""+random;
        String Religon=(String)religon.getSelectedItem();
        String Category =(String)category.getSelectedItem();
        String Education=(String)educationn.getSelectedItem();
        String ac=t1.getText();
        String pc=t2.getText();
        String sinor="null";
        if (o1.isSelected()) {
            sinor="yes";
            
        }
        else if (o2.isSelected()) {
            sinor="NO";
            
        }
        String Account="null";
        if(op1.isSelected()){
            Account="yes";

        }
       else if(op2.isSelected()){
            Account="no";
            
        }
        try {
            Conn b=new Conn();
            String query="INSERT INTO singup2 VALUES('"+form+"','"+Religon+"','"+Category+"','"+Education+"','"+ac+"','"+pc+"','"+sinor+"','"+Account+"')";
            b.s.executeUpdate(query);
        } catch (Exception e) {
         System.out.println(e);
         JOptionPane.showMessageDialog(null, "Signup successful!");
         setVisible(false);
        }



    }

           public static void main(String[] args) {
          new Signup2("");
     }
 }
 