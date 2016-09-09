/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sangraj.scrap.ui.process;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Song Grudge Ranjit
 */
public class ScrapProcess  extends Thread{
    private JTextField txtRegEx;
    private JTextArea txtBrowser;
    private JTextArea txtScrap;
    public ScrapProcess(JTextField txtRegEx, JTextArea txtBrowser,JTextArea txtScrap){
        this.txtRegEx=txtRegEx;
        this.txtScrap=txtScrap;
        this.txtBrowser=txtBrowser;
    }

    @Override
    public void run() {
if(txtRegEx.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "NOTHING TO SCRAP","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
        Pattern pattern = Pattern.compile(txtRegEx.getText());
        Matcher matcher = pattern.matcher(txtBrowser.getText());
        StringBuilder conten = new StringBuilder();
        int counter = 0;
        while (matcher.find()) {
            ++counter;
            conten.append(matcher.group()).append("\r\n");
        }
        txtScrap.setText(conten.toString());
        JOptionPane.showMessageDialog(null, counter + " matches", "MATCHED ITEMS", JOptionPane.OK_OPTION);
        }
    }
    
}
