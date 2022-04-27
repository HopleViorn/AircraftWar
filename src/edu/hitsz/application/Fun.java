package edu.hitsz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fun {
    private JButton button1;
    public JLabel noName;
    private JPanel Jpanel1;

    private static JFrame frame;
    public Fun(String Mesg) {
        noName.setText(Mesg);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }

    private static int Wid=300;
    private static int Hei=100;

    public static void hwhw(String Mesg){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("Fun");
        frame.setContentPane(new Fun(Mesg).Jpanel1);
        frame.setSize(Wid,Hei);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(((int) screenSize.getWidth()-Wid) / 2, (int) (screenSize.getHeight()-Hei)/2,Wid,Hei);
//        frame.pack();
        frame.setVisible(true);
    }
}
