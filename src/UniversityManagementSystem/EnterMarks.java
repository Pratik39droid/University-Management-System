package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice cRollNo;
    JComboBox cbSemester;
    JTextField tfSub1, tfSub2,tfSub3,tfSub4,tfSub5,tfMarks1,tfMarks2,tfMarks3,tfMarks4,tfMarks5;
    JButton cancel, submit;
    EnterMarks(){
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 70, 150, 20);
        add(lblrollnumber);

        cRollNo = new Choice();
        cRollNo.setBounds(200, 70, 150, 20);
        add(cRollNo);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                cRollNo.add(rs.getString("rollNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);

        String[] semester = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
        cbSemester = new JComboBox(semester);
        cbSemester.setBounds(200, 110, 150, 20);
        cbSemester.setBackground(Color.WHITE);
        add(cbSemester);

        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 150, 200, 40);
        add(lblentersubject);

        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320, 150, 200, 40);
        add(lblentermarks);

        tfSub1 = new JTextField();
        tfSub1.setBounds(50, 200, 200, 20);
        add(tfSub1);

        tfSub2 = new JTextField();
        tfSub2.setBounds(50, 230, 200, 20);
        add(tfSub2);

        tfSub3 = new JTextField();
        tfSub3.setBounds(50, 260, 200, 20);
        add(tfSub3);

        tfSub4 = new JTextField();
        tfSub4.setBounds(50, 290, 200, 20);
        add(tfSub4);

        tfSub5 = new JTextField();
        tfSub5.setBounds(50, 320, 200, 20);
        add(tfSub5);

        tfMarks1 = new JTextField();
        tfMarks1.setBounds(250, 200, 200, 20);
        add(tfMarks1);

        tfMarks2 = new JTextField();
        tfMarks2.setBounds(250, 230, 200, 20);
        add(tfMarks2);

        tfMarks3 = new JTextField();
        tfMarks3.setBounds(250, 260, 200, 20);
        add(tfMarks3);

        tfMarks4 = new JTextField();
        tfMarks4.setBounds(250, 290, 200, 20);
        add(tfMarks4);

        tfMarks5 = new JTextField();
        tfMarks5.setBounds(250, 320, 200, 20);
        add(tfMarks5);

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                Conn c = new Conn();

                String query1 = "insert into subject values('"+cRollNo.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"', '"+tfSub1.getText()+"', '"+tfSub2.getText()+"', '"+tfSub3.getText()+"', '"+tfSub4.getText()+"', '"+tfSub5.getText()+"')";
                String query2 = "insert into marks values('"+cRollNo.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"', '"+tfMarks1.getText()+"', '"+tfMarks2.getText()+"', '"+tfMarks3.getText()+"', '"+tfMarks4.getText()+"', '"+tfMarks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception ez) {
                ez.printStackTrace();
            }
        } else {
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
