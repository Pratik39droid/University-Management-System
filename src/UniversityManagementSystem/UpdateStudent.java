package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfCourse, tfBranch, tfName, tfFatherName, tfAddress, tfPhone, tfDate, tfTenth, tf12th, tfEmail, tfAadhar;
    JLabel LRollNo;
    JButton submit, cancel;
    Choice crollno;

    Random r = new Random();
    long roll = Math.abs((r.nextLong() % 9000L) + 1000L);
    UpdateStudent(){
        setSize(700, 600);
        setLocation(300, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Information");
        heading.setBounds(250, 10, 500, 50);
        heading.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(heading);

        JLabel heading1 = new JLabel("Select Roll Number");
        heading1.setBounds(50, 70, 150, 20);
        add(heading1);

        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        name
        JLabel lName = new JLabel("Name : ");
        lName.setBounds(50, 100, 500, 50);
        lName.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lName);

        JLabel tfName = new JLabel();
        tfName.setBounds(120, 110, 150, 30);
        add(tfName);

//        Father name
        JLabel lfName = new JLabel("Father Name : ");
        lfName.setBounds(300, 100, 500, 50);
        lfName.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lfName);

        JLabel tfFatherName = new JLabel();
        tfFatherName.setBounds(410, 110, 150, 30);
        add(tfFatherName);

//        Roll no.
        JLabel lRoll = new JLabel("Roll : ");
        lRoll.setBounds(50, 150, 500, 50);
        lRoll.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lRoll);

        LRollNo = new JLabel();
        LRollNo.setBounds(120, 150, 500, 50);
        LRollNo.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(LRollNo);

//        DOB
        JLabel lfDOB = new JLabel("Date Of Birth : ");
        lfDOB.setBounds(300, 150, 500, 50);
        lfDOB.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lfDOB);

        JLabel tfDate = new JLabel();
        tfDate.setBounds(410, 160, 150, 30);
        add(tfDate);

//        Address
        JLabel lAddress = new JLabel("Address : ");
        lAddress.setBounds(50, 200, 500, 50);
        lAddress.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(120, 210, 150, 30);
        add(tfAddress);

//        phone
        JLabel lPhone = new JLabel("Phone : ");
        lPhone.setBounds(300, 200, 500, 50);
        lPhone.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(410, 210, 150, 30);
        add(tfPhone);

//        10th
        JLabel lTenth = new JLabel("10th % : ");
        lTenth.setBounds(50, 250, 500, 50);
        lTenth.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lTenth);

        JLabel tfTenth = new JLabel();
        tfTenth.setBounds(120, 260, 150, 30);
        add(tfTenth);

//        12th
        JLabel lTwelth = new JLabel("12th %: ");
        lTwelth.setBounds(300, 250, 500, 50);
        lTwelth.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lTwelth);

        JLabel tf12th = new JLabel();
        tf12th.setBounds(410, 260, 150, 30);
        add(tf12th);

//        Email
        JLabel lEmail = new JLabel("Email : ");
        lEmail.setBounds(50, 300, 500, 50);
        lEmail.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(120, 310, 150, 30);
        add(tfEmail);

//        Aadhaar
        JLabel lAadhaar = new JLabel("Aadhaar : ");
        lAadhaar.setBounds(300, 300, 500, 50);
        lAadhaar.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lAadhaar);

        JLabel tfAadhar = new JLabel();
        tfAadhar.setBounds(410, 310, 150, 30);
        add(tfAadhar);

//        Course
        JLabel lCourse = new JLabel("Course : ");
        lCourse.setBounds(50, 350, 500, 50);
        lCourse.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lCourse);

        tfCourse = new JTextField();
        tfCourse.setBounds(120, 360, 150, 30);
        add(tfCourse);

        JLabel lBranch = new JLabel("Branch : ");
        lBranch.setBounds(300, 350, 500, 50);
        lBranch.setFont(new Font("OpenSans", Font.BOLD, 14));
        add(lBranch);

        tfBranch = new JTextField();
        tfBranch.setBounds(410, 360, 150, 30);
        add(tfBranch);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollNumber='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                tfName.setText(rs.getString("name"));
                tfFatherName.setText(rs.getString("fatherName"));
                LRollNo.setText(rs.getString("rollNumber"));
                tfDate.setText(rs.getString("DOB"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfTenth.setText(rs.getString("tenth"));
                tf12th.setText(rs.getString("twelve"));
                tfEmail.setText(rs.getString("email"));
                tfAadhar.setText(rs.getString("aadhaar"));
                tfCourse.setText(rs.getString("course"));
                tfBranch.setText(rs.getString("Branch"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollNumber='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        tfName.setText(rs.getString("name"));
                        tfFatherName.setText(rs.getString("fatherName"));
                        LRollNo.setText(rs.getString("rollNumber"));
                        tfDate.setText(rs.getString("DOB"));
                        tfAddress.setText(rs.getString("address"));
                        tfPhone.setText(rs.getString("phone"));
                        tfTenth.setText(rs.getString("tenth"));
                        tf12th.setText(rs.getString("twelve"));
                        tfEmail.setText(rs.getString("email"));
                        tfAadhar.setText(rs.getString("aadhaar"));
                        tfCourse.setText(rs.getString("course"));
                        tfBranch.setText(rs.getString("Branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
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
            String rollNumber = LRollNo.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String course = tfCourse.getText();
            String Branch = tfBranch.getText();

            try {
                String query = "update student set address='"+address+"', phone='"+phone+"', email='"+email+"', course='"+course+"', branch='"+Branch+"' where rollNumber='"+rollNumber+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception ez) {
                ez.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
