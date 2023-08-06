package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    Project() {
        setSize(1540, 840);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        add(j1);
        setVisible(true);

//        menuItems
        JMenuBar menu = new JMenuBar();

        JMenu information = new JMenu("Information");
        information.setBackground(Color.white);
        menu.add(information);

        JMenuItem facultyInfo = new JMenuItem("Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        information.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        information.add(studentInfo);

//        details
        JMenu details = new JMenu("Details");
        details.setBackground(Color.white);
        menu.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        details.add(studentDetails);

//        leave details
        JMenu leave = new JMenu("Leave");
        leave.setBackground(Color.white);
        menu.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);


//      Exams
        JMenu exam = new JMenu("Examination");
        exam.setBackground(Color.white);
        menu.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Details");
        ExaminationDetails.setBackground(Color.white);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem examMarks = new JMenuItem("Student Marks");
        examMarks.setBackground(Color.white);
        examMarks.addActionListener(this);
        exam.add(examMarks);

//        update
        JMenu update = new JMenu("Update Details");
        update.setBackground(Color.white);
        menu.add(update);

        JMenuItem updateStudentDetails = new JMenuItem("update Student Details");
        updateStudentDetails.setBackground(Color.white);
        updateStudentDetails.addActionListener(this);
        update.add(updateStudentDetails);

        JMenuItem updateFacultyDetails = new JMenuItem("update Faculty Details");
        updateFacultyDetails.setBackground(Color.white);
        updateFacultyDetails.addActionListener(this);
        update.add(updateFacultyDetails);

//        fees
        JMenu feesDetails = new JMenu("Fees");
        feesDetails.setBackground(Color.white);
        menu.add(feesDetails);

        JMenuItem feesStructure = new JMenuItem("Fees Structure");
        feesStructure.setBackground(Color.white);
        feesStructure.addActionListener(this);
        feesDetails.add(feesStructure);

        JMenuItem examForm = new JMenuItem("Fees Form");
        examForm.setBackground(Color.white);
        examForm.addActionListener(this);
        feesDetails.add(examForm);

//        Utility
        JMenu utility = new JMenu("Utility");
        utility.setBackground(Color.white);
        menu.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu Exit = new JMenu("Exit");
        Exit.setBackground(Color.white);
        menu.add(Exit);

        JMenuItem ex = new JMenuItem("exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        Exit.add(ex);

        setJMenuBar(menu);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();

        if (msg.equals("exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {

            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception exx) {

            }
        } else if (msg.equals("Faculty Information")) {
            new Teacher();
        } else if (msg.equals("Student Information")) {
            new Student();
        }else if (msg.equals("View Faculty Details")) {
            new teacherLeave();
        } else if (msg.equals("View Student Details")) {
            new StudentLeave();
        }else if (msg.equals("Faculty Leave")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave")) {
            new StudentLeaveDetails();
        }else if (msg.equals("update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("update Faculty Details")) {
            new UpdateTeacher();
        }else if (msg.equals("Student Marks")) {
            new EnterMarks();
        }else if (msg.equals("Examination Details")) {
            new ExaminationDetails();
        }else if (msg.equals("Fees Structure")) {
            new FeesStructure();
        }else if (msg.equals("Fees Form")) {
            new FeesForm();
        }
    }

    public static void main(String[] args) {
        new Project();
    }

}
