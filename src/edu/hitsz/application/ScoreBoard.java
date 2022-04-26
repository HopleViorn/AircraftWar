package edu.hitsz.application;

import edu.hitsz.user.User;
import edu.hitsz.user.UserDao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class ScoreBoard {
    public JPanel panel1;
    private JTable scoreTable;
    private JPanel tablePanel;
    private JScrollPane tableScrollPanel;
    private JPanel buttonPanel;
    private JLabel tittle;
    private JButton buttonDelete;
    private JButton exitButton;;

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
    }


//    public static void main(String[] args) {
//        JFrame frame = new JFrame("ScoreBoard");
//        frame.setContentPane(new ScoreBoard().panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
