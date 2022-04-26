package edu.hitsz.application;

import edu.hitsz.user.UserDao;
import edu.hitsz.user.UserDaoImpl;

import javax.swing.*;
import java.awt.*;

/**
 * 程序入口
 * @author hitsz
 */
public class Main {

    public static JFrame frame=new JFrame();
    public static UserDao userDao = new UserDaoImpl();
    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello Aircraft War");

        // 获得屏幕的分辨率，初始化 Frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Game game = new Game();

        synchronized (frame) {
            frame = new JFrame("StartMenu");
            frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setContentPane(new StartMenu().panel1);
            frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, (int) (screenSize.getHeight()/2),WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
        synchronized (frame) {
            frame.wait();
            frame = new JFrame("Aircraft War");
            frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setResizable(false);
            //设置窗口的大小和位置,居中放置
            frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, 0,
                    WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            frame.add(game);
            frame.setVisible(true);
            game.action();
        }

        synchronized (frame){
            frame.wait();
            frame = new JFrame("UserDataInput");
            frame.setContentPane(new UserDataInput(game.score).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, (int) (screenSize.getHeight()/2),WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.pack();
            frame.setVisible(true);
        }
        synchronized (frame){
            frame.wait();
            frame=new JFrame("ScoreBoard");
            frame.setContentPane(new ScoreBoard(userDao).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, (int) (screenSize.getHeight()/2),WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
