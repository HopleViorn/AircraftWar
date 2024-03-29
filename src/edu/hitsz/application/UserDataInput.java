package edu.hitsz.application;

import edu.hitsz.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static edu.hitsz.application.Main.*;

public class UserDataInput {
    private JTextField textField1;
    public JPanel panel1;
    private JButton buttonOK;
    private JPasswordField passwordField1;

    public UserDataInput(int score) {
        Date date = new Date(System.currentTimeMillis());
        textField1.setText("Dr.Anonymous");
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(passwordField1.getPassword().length==0){
                    Attention.hwhw("Please enter your password");
                    return ;
                }
                synchronized (frame) {
                    name=textField1.getText();
                    userDao.addUser(new User((int) (Math.random() * 1000000), textField1.getText(), score, date));
                    userDao.getAllUsers().sort((a, b) -> (a.score <= b.score ? (a.score < b.score ? 1 : 0) : -1));
                    System.out.println("AbstractGame Over!");

                    System.out.println("RankList");
                    System.out.println("******************************************************");
                    System.out.println("                      Score Board");
                    System.out.println("******************************************************");

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    int rank = 0;
                    for (User user : userDao.getAllUsers()) {
                        System.out.println("Rank " + (++rank) + ":userID:" + user.userID + ",score:" + user.score + "," + formatter.format(user.date));
                    }
                    userDao.writeToFile();

                    frame.setVisible(false);
                    frame.notify();
                }
            }
        });
    }
}
