package edu.hitsz.application;

import edu.hitsz.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static edu.hitsz.application.Main.frame;
import static edu.hitsz.application.Main.userDao;

public class UserDataInput {
    private JTextField textField1;
    public JPanel panel1;
    private JButton buttonOK;

    public UserDataInput(int score) {
        Date date = new Date(System.currentTimeMillis());

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                synchronized (frame) {

                    userDao.addUser(new User((int) (Math.random() * 10000), textField1.getText(), score, date));
                    userDao.getAllUsers().sort((a, b) -> (a.score <= b.score ? (a.score < b.score ? 1 : 0) : -1));

                    System.out.println("Game Over!");

                    System.out.println("RankList");
                    System.out.println("******************************************************");
                    System.out.println("                      Score Board");
                    System.out.println("******************************************************");

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    int rank = 0;
                    for (User user : userDao.getAllUsers()) {
                        System.out.println("Rank " + (++rank) + ":userID:" + user.userID + ",score:" + user.score + "," + formatter.format(user.date));
                    }

                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.data"));
                        oos.writeObject(userDao);
                    } catch (Exception e) {
                        System.out.println("Save Failed!");
                        e.printStackTrace();
                    }

                    frame.setVisible(false);
                    frame.notify();
                }
            }
        });
    }
}
