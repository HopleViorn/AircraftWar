package edu.hitsz.application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static edu.hitsz.application.Main.*;

public class StartMenu {
    public JPanel panel1;
    private JButton buttonCasual;
    private JButton buttonHard;
    private JButton buttonMedium;
    private JCheckBox checkboxMusic;
    private JCheckBox checkBoxFun;
    private JCheckBox checkBoxAgreement;
    private JCheckBox setBrowserHomepageToCheckBox;
    private JCheckBox installQQBrowserSuperCheckBox;
    private JCheckBox installNationalAntiFraudCheckBox;
    private JTextPane loremIpsumDolorSitTextPane;

    public StartMenu() {
        checkBoxFun.setSelected(true);
        setBrowserHomepageToCheckBox.setSelected(true);
        installQQBrowserSuperCheckBox.setSelected(true);
        buttonCasual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!checkBoxAgreement.isSelected()) {
                    Attention.hwhw("Please agree with the User Agreement");
                    return ;
                }
                if(!installNationalAntiFraudCheckBox.isSelected()){
                    Attention.hwhw("Have you installed the National Anti-Frau Center?");
                    return ;
                }
                synchronized (frame) {
                    Settings.difficulty= Settings.Difficulty.Casual;
                    frame.setVisible(false);
                    frame.notify();
                }
            }
        });
        buttonHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!checkBoxAgreement.isSelected()) {
                    Attention.hwhw("Please agree with the User Agreement");
                    return ;
                }
                if(!installNationalAntiFraudCheckBox.isSelected()){
                    Attention.hwhw("Have you installed the National Anti-Frau Center?");
                    return ;
                }
                synchronized (frame) {
                    Settings.difficulty= Settings.Difficulty.Hard;
                    frame.setVisible(false);
                    frame.notify();
                }
            }
        });
        buttonMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!checkBoxAgreement.isSelected()) {
                    Attention.hwhw("Please agree with the User Agreement");
                    return ;
                }
                if(!installNationalAntiFraudCheckBox.isSelected()){
                    Attention.hwhw("Have you installed the National Anti-Frau Center?");
                    return ;
                }
                synchronized (frame) {
                    Settings.difficulty= Settings.Difficulty.Medium;
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
