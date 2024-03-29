package edu.hitsz.application;

import edu.hitsz.application.game.CasualMode;
import edu.hitsz.application.game.HardMode;
import edu.hitsz.application.game.MediumMode;
import edu.hitsz.user.UserDao;
import edu.hitsz.user.UserDaoImpl;

import javax.swing.*;
import java.awt.*;

import static edu.hitsz.application.Settings.Difficulty.*;

/**
 * 程序入口
 * @author hitsz
 */
public class Main {

    public static JFrame frame=new JFrame();
    public static UserDao userDao = new UserDaoImpl();
    public static String name;
    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;

    public static void main(String[] args) throws InterruptedException {


        System.out.println("Hello Aircraft War");

        // 获得屏幕的分辨率，初始化 Frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        synchronized (frame) {
            frame = new JFrame("StartMenu");
            frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.setBounds(((int) screenSize.getWidth()-frame.getWidth()) / 2, (int) (screenSize.getHeight()-frame.getHeight())/2,frame.getWidth(), frame.getHeight());
            frame.setContentPane(new StartMenu().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

        /*
        switch ( Settings.difficulty) {
            case Casual:
                game = new CasualMode();break;
            case Medium:game=new MediumMode();break;
            case Hard:game=new HardMode();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Settings.difficulty);
        }
*/
        AbstractGame game;
        synchronized (frame) {
            frame.wait();
            game=        Settings.difficulty==Casual? new CasualMode():
                            (Settings.difficulty==Medium?
                                    new MediumMode():
                                    new HardMode()
                                    );
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
            frame.setBounds(((int) screenSize.getWidth()-frame.getWidth()) / 2, (int) (screenSize.getHeight()-frame.getHeight())/2,WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.pack();
            frame.setVisible(true);
        }
        synchronized (frame){
            frame.wait();
            frame=new JFrame("ScoreBoard");
            frame.setContentPane(new ScoreBoard(userDao,name,game.score).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(((int) screenSize.getWidth()) / 3, (int) (screenSize.getHeight()/4),WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
