/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sangraj.scrap.ui.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Song Grudge Ranjit
 */
public class GrabberProcess extends Thread {
private JTextArea txtBrowser;
private JTextField txtURL;

public GrabberProcess(JTextArea txtBrowser,JTextField txtURL){
    this.txtBrowser=txtBrowser;
    this.txtURL=txtURL;

}
    @Override
    public void run() {
        if(txtURL.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter URL","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
try{
        URL url=new URL(txtURL.getText());
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line="";
        StringBuilder content=new StringBuilder();
        while((line=br.readLine())!=null){
            content.append(line).append("\r\n");
        }
        br.close();
        txtBrowser.setText(content.toString());
}catch(IOException ioe){
    JOptionPane.showMessageDialog(null, ioe.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
}
    }
    }
}
