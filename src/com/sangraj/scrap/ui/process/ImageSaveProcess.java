/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sangraj.scrap.ui.process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Song Grudge Ranjit
 */
public class ImageSaveProcess extends Thread {
    private  JTextField txtImage;
    
    public ImageSaveProcess(JTextField txtImage){
    this.txtImage=txtImage;
    }

    @Override
    public void run() {
         if(txtImage.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "NOTHING TO SAVE","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(null);
            if (result == fc.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
        try{
            URL url=new URL(txtImage.getText());
            URLConnection conn=url.openConnection();
            InputStream in=conn.getInputStream();
            FileOutputStream os=new FileOutputStream(file);
            byte [] data=new byte[1024];
            int i=0;
            while((i=in.read(data))!=-1){
                os.write(data, 0, i);
            }
            in.close();
            os.close();
            
        }catch(IOException ioe){
            JOptionPane.showMessageDialog(null, ioe.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
}
}
        }
    }
    
}
