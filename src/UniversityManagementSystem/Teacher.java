package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Teacher extends JFrame implements ActionListener {
    JTextField tfName, tfFatherName, tfAddress, tfPhone, tfDate, tfTenth, tf12th, tfEmail, tfAadhar;
    JLabel LEmpNo;
    JComboBox cbedu, cbDept;
    JButton submit, cancel;

    Random r = new Random();
    long emp = Math.abs((r.nextLong() % 9000L) + 1000L);

    Teacher(){
        setSize(700, 600);
        setLocation(300, 50);
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Information");
        heading.setBounds(250, 30, 500, 50);
        heading.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(heading);


//        name
        JLabel lName = new JLabel("Name : ");
        lName.setBounds(50, 70, 500, 50);
        lName.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lName);

        tfName = new JTextField();
        tfName.setBounds(120, 80, 150, 30);
        add(tfName);

//        Father name
        JLabel lfName = new JLabel("Father Name : ");
        lfName.setBounds(300, 70, 500, 50);
        lfName.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lfName);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(410, 80, 150, 30);
        add(tfFatherName);

//        Roll no.
        JLabel lEmpId = new JLabel("Emp ID : ");
        lEmpId.setBounds(50, 120, 500, 50);
        lEmpId.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lEmpId);

        LEmpNo = new JLabel("2031" + emp);
        LEmpNo.setBounds(120, 120, 500, 50);
        LEmpNo.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(LEmpNo);

//        DOB
        JLabel lfDOB = new JLabel("Date Of Birth : ");
        lfDOB.setBounds(300, 120, 500, 50);
        lfDOB.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lfDOB);

        tfDate = new JTextField();
        tfDate.setBounds(410, 130, 150, 30);
        add(tfDate);

//        Address
        JLabel lAddress = new JLabel("Address : ");
        lAddress.setBounds(50, 170, 500, 50);
        lAddress.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(120, 180, 150, 30);
        add(tfAddress);

//        phone
        JLabel lPhone = new JLabel("Phone : ");
        lPhone.setBounds(300, 170, 500, 50);
        lPhone.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(410, 180, 150, 30);
        add(tfPhone);

//        10th
        JLabel lTenth = new JLabel("10th % : ");
        lTenth.setBounds(50, 220, 500, 50);
        lTenth.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lTenth);

        tfTenth = new JTextField();
        tfTenth.setBounds(120, 230, 150, 30);
        add(tfTenth);

//        12th
        JLabel lTwelth = new JLabel("12th %: ");
        lTwelth.setBounds(300, 220, 500, 50);
        lTwelth.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lTwelth);

        tf12th = new JTextField();
        tf12th.setBounds(410, 230, 150, 30);
        add(tf12th);

//        Email
        JLabel lEmail = new JLabel("Email");
        lEmail.setBounds(50, 270, 500, 50);
        lEmail.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(120, 280, 150, 30);
        add(tfEmail);

//        Aadhaar
        JLabel lAadhaar = new JLabel("Aadhaar : ");
        lAadhaar.setBounds(300, 270, 500, 50);
        lAadhaar.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lAadhaar);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(410, 280, 150, 30);
        add(tfAadhar);

//        Course
        JLabel lEdu = new JLabel("Course : ");
        lEdu.setBounds(50, 320, 500, 50);
        lEdu.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lEdu);

        String[] courses = {"B.E/B.TECH", "M.TECH", "BCA", "MCA", "MBA", "BBA"};
        cbedu = new JComboBox(courses);
        cbedu.setBounds(120, 330, 150, 30);
        add(cbedu);

        JLabel lDept = new JLabel("Department : ");
        lDept.setBounds(300, 320, 500, 50);
        lDept.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lDept);
        String[] Branches = {"Mechanical Engineering", "Computer Science & Engineering",
                "Civil Engineering", "Electrical engineering",
                "Electronics and Communication Engineering", "Chemical Engineering"};
        cbDept = new JComboBox(Branches);
        cbDept.setBounds(410, 330, 150, 30);
        add(cbDept);

        submit = new JButton("Submit");
        submit.setBounds(70, 450, 200, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Open Sans", Font.BOLD, 14));
        add(submit);

        cancel = new JButton("cancel");
        cancel.setBounds(350, 450, 200, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Open Sans", Font.BOLD, 14));
        add(cancel);

        setVisible(true);




    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = tfName.getText();
            String fatherName = tfFatherName.getText();
            String EmpID = LEmpNo.getText();
            String DOB = tfDate.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String tenth = tfTenth.getText();
            String twelve = tf12th.getText();
            String email = tfEmail.getText();
            String aadhaar = tfAadhar.getText();
            String Department = (String) cbedu.getSelectedItem();
            String Branch = (String) cbDept.getSelectedItem();


            try {
                String query = "insert into teacher values('"+name+"', '"+fatherName+"', '"+EmpID+"', '"+DOB+"', '"+address+"', '"+phone+"', '"+tenth+"', '"+twelve+"', '"+email+"', '"+aadhaar+"', '"+Department+"', '"+Branch+"')";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showConfirmDialog(null, "Details updated successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);

        }

    }
    public static void main(String[] args) {
        new Teacher();
    }


}
