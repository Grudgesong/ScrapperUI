/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sangraj.scrap.ui.process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Song Grudge Ranjit
 */
public class MatcherSaveProcess extends Thread {
    JTextArea txtMatch;

    public MatcherSaveProcess(JTextArea txtMatch){
this.txtMatch=txtMatch;
}

    @Override
    public void run() {
                

    if(txtMatch.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nothing to Save","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(null);
        if (result == fc.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(txtMatch.getText().toString());
                writer.close();
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, ioe.getMessage());
            }
            }
        }
}
    }