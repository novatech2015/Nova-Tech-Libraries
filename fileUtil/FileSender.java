/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr. Mallory
 */
public class FileSender {
    
    private Socket m_socket;
    private File m_file;
    private OutputStream m_socketOut;
    private BufferedReader m_fileIn;
    
    public FileSender(File file, String address){
        m_file = file;
        try {
            m_socket = new Socket(address, 9090);
            m_socketOut = m_socket.getOutputStream();
            m_fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(m_file)));
        } catch (IOException ex) {
            Logger.getLogger(FileSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(){
        try {
            char[] buffer = new char[(int)m_file.length()];
            m_fileIn.read(buffer);
            System.out.println(buffer);
            m_socketOut.write(new String(buffer).getBytes());
        } catch (IOException ex) {
            Logger.getLogger(FileSender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
