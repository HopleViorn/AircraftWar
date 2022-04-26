package edu.hitsz.application;

import javax.swing.*;

public class UserDataInput {
    private JTextField textField1;
    private JPanel panel1;
    private JButton button1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserDataInput");
        frame.setContentPane(new UserDataInput().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
