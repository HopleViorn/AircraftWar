package edu.hitsz.application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static edu.hitsz.application.Main.*;

public class StartMenu {
    public JPanel panel1;
    private JButton buttonCasual;
    private JButton buttonMedium;
    private JButton buttonHard;
    private JCheckBox checkboxMusic;
    private JCheckBox checkBoxFun;
    private JCheckBox checkBoxAgreement;
    private JCheckBox setBrowserHomepageToCheckBox;
    private JCheckBox installQQBrowserSuperCheckBox;
    private JCheckBox checkBox1;

    public StartMenu() {
        buttonCasual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                synchronized (frame) {
                    Settings.difficulty= Settings.Difficulty.Casual;
                    frame.setVisible(false);
                    frame.notify();
                }
            }
        });
        buttonMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                synchronized (frame) {
                    Settings.difficulty= Settings.Difficulty.Medium;
                    frame.setVisible(false);
                    frame.notify();
                }
            }
        });
        buttonHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                synchronized (frame) {
                    Settings.difficulty= Settings.Difficulty.Hard;
                    frame.setVisible(false);
                    frame.notify();
                }
            }
        });
        checkboxMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Settings.systemMusicState= checkboxMusic.isSelected()?Settings.SystemMusicState.ON:Settings.SystemMusicState.OFF;
            }
        });
    }

}
