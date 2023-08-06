package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfUsername, tfPassword;

    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

//        Username Field
        JLabel lUsername = new JLabel("Username : ");
        lUsername.setBounds(40, 20, 100, 20);
        add(lUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 20, 150, 20);
        add(tfUsername);

//        password Field
        JLabel lPassword = new JLabel("Password : ");
        lPassword.setBounds(40, 70, 100, 20);
        add(lPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(150, 70, 150, 20);
        add(tfPassword);

//        Buttons
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.addActionListener(this);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFont(new Font("Open Sans", Font.BOLD, 14));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
//        addActionListener internally calls the action Performed method which is overrided
        cancel.addActionListener(this);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Open Sans", Font.BOLD, 14));
        add(cancel);

//        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(350, 0, 200, 200);
        add(j1);
        setVisible(true);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            String query = "select * from login where username='%s' and password='%s'".formatted(username, password);

            try {
                Conn c = new Conn();
                ResultSet r = c.s.executeQuery(query);

                if (r.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "invalid username and password");
                    setVisible(false);
                }

            } catch (Exception g) {
                g.printStackTrace();
            }
        } else if (e.getSource() == cancel) {

        }

    }

    public static void main(String[] args) {
        new Login();
    }



}
