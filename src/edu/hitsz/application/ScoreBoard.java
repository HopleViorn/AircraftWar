package edu.hitsz.application;

import edu.hitsz.user.User;
import edu.hitsz.user.UserDao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import static edu.hitsz.application.Main.frame;

public class ScoreBoard {
    public JPanel panel1;
    private JTable scoreTable;
    private JPanel tablePanel;
    private JScrollPane tableScrollPanel;
    private JPanel buttonPanel;
    private JLabel tittle;
    private JButton buttonDelete;
    private JButton buttonExit;;

    public ScoreBoard(UserDao userDao){
        String [] columName={"Rank","Name","Score","Date"};
        String [][] tableData=new String[userDao.getAllUsers().size()][4];

        int rank=0;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        for(User user: userDao.getAllUsers()){
            tableData[rank][0]=""+(rank+1);
            tableData[rank][1]=user.Name;
            tableData[rank][2]=""+user.score;
            tableData[rank][3]=formatter.format(user.date);
            rank++;
        }

        DefaultTableModel model=new DefaultTableModel(tableData,columName);
        scoreTable.setModel(model);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                synchronized (frame) {
                    frame.setVisible(false);
                }
            }
        });
    }


//    public static void main(String[] args) {
//        JFrame frame = new JFrame("ScoreBoard");
//        frame.setContentPane(new ScoreBoard().panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
