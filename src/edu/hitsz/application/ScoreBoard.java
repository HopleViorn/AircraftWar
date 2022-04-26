package edu.hitsz.application;

import edu.hitsz.user.User;
import edu.hitsz.user.UserDao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

import static edu.hitsz.application.Main.frame;
import static edu.hitsz.application.Main.userDao;

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
        buttonDelete.setEnabled(false);
        String [] columName={"Rank","UserID","Name","Score","Date"};
        String [][] tableData=new String[userDao.getAllUsers().size()][5];

        int rank=0;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        for(User user: userDao.getAllUsers()){
            tableData[rank][0]=""+(rank+1);
            tableData[rank][1]=""+user.userID;
            tableData[rank][2]=user.Name;
            tableData[rank][3]=""+user.score;
            tableData[rank][4]=formatter.format(user.date);
            rank++;
        }

        DefaultTableModel model=new DefaultTableModel(tableData,columName);
        scoreTable.setModel(model);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userDao.deleteUser(Integer.parseInt((String) scoreTable.getValueAt(scoreTable.getSelectedRow(),1)));
                model.removeRow(scoreTable.getSelectedRow());
                scoreTable.setModel(model);
                buttonDelete.setEnabled(false);
                userDao.writeToFile();
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                synchronized (frame) {
                    frame.setVisible(false);
                    System.exit(0);
                }
            }
        });
        scoreTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(scoreTable.getSelectedRow()==-1)
                    buttonDelete.setEnabled(false);
                else buttonDelete.setEnabled(true);
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
