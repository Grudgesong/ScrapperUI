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
public class MatcherProcess extends Thread {
private JTextField txtMatcher;
 private JTextField txtMatcher2;
 private JTextField txtMatcher3;
 private JTextField txtRegEx;
 private JTextArea txtBrowser;
  private JTextArea txtMatch;

public MatcherProcess(JTextArea txtBrowser, JTextField txtMatcher,JTextField txtMatcher2,JTextField txtMatcher3,JTextField txtRegEx,JTextArea txtMatch){
    this.txtBrowser=txtBrowser;
    this.txtMatcher=txtMatcher;
    this.txtMatcher2=txtMatcher2;
    this.txtMatcher3=txtMatcher3;
    this.txtRegEx=txtRegEx;
    this.txtMatch=txtMatch;
}
    @Override
    public void run() {
        //Gets the this you want from Scrap (.*?)=1++
        if(txtMatcher.getText().isEmpty() && txtMatcher2.getText().isEmpty() && txtMatcher3.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "ENTER MATCHER GROUP","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
        Pattern pattern = Pattern.compile(txtRegEx.getText());
        Matcher matcher = pattern.matcher(txtBrowser.getText());
        StringBuilder sb = new StringBuilder();  
        if(txtMatcher2.getText().isEmpty() && txtMatcher3.getText().isEmpty()){
            while (matcher.find()) {
                sb.append(matcher.group(Integer.parseInt(txtMatcher.getText()))).append("\r\n");
            }txtMatch.setText(sb.toString());
        }else if(txtMatcher.getText().isEmpty()){
            while (matcher.find()) {
                sb.append(matcher.group(Integer.parseInt(txtMatcher2.getText()))).append("\r\n");
                sb.append(matcher.group(Integer.parseInt(txtMatcher3.getText()))).append("\r\n");           
        }txtMatch.setText(sb.toString());   
        }else if(txtMatcher2.getText().isEmpty()){
            while (matcher.find()) {
                sb.append(matcher.group(Integer.parseInt(txtMatcher.getText()))).append("\r\n");
                sb.append(matcher.group(Integer.parseInt(txtMatcher3.getText()))).append("\r\n");        
        }txtMatch.setText(sb.toString());   
        }else if(txtMatcher3.getText().isEmpty()){
            while (matcher.find()) {
                sb.append(matcher.group(Integer.parseInt(txtMatcher.getText()))).append("\r\n");
                sb.append(matcher.group(Integer.parseInt(txtMatcher2.getText()))).append("\r\n");       
        }txtMatch.setText(sb.toString());   
        }else{
                while (matcher.find()) {
                sb.append(matcher.group(Integer.parseInt(txtMatcher.getText()))).append("\r\n");
                sb.append(matcher.group(Integer.parseInt(txtMatcher2.getText()))).append("\r\n");
                sb.append(matcher.group(Integer.parseInt(txtMatcher3.getText()))).append("\r\n");
        }txtMatch.setText(sb.toString());        
        }
        }
    }
    
    
}
