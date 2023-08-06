package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame implements Runnable {

    Thread t;
    Splash(){
//        opening window dimensions
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        add(j1);
        setVisible(true);

        t = new Thread(this);
        t.start();

        int x = 1;
        for (int i =2; i <600; i+=4, x+=1) {
            setLocation(600 - ((i+x)/2), 350 - (i/2));
            setSize(i+3*x,i+(x/2));

        }

        try{
            Thread.sleep(10);
        }catch (Exception e){}
    }

    @Override
    public void run() {
        try{
//            opening frame is waiting for 7 second and next frame will appear
            Thread.sleep(3000);
            setVisible(false);

//            calling the next frame
            new Login();
        }catch (Exception e){}

    }

    public static void main(String[] args) {
        new Splash();
    }


}
