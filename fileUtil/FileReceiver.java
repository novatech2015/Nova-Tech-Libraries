package file.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher Kha
 */
public class FileReceiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket m_client = null;
            ServerSocket m_socketServer = new ServerSocket (9090);
            m_client = m_socketServer.accept();
            InputStream m_socketIn = m_client.getInputStream();
            byte[] buffer = new byte[m_socketIn.available()]; 
            m_socketIn.read(buffer);
            System.out.println(new String(buffer));
        } catch (IOException ex) {
            Logger.getLogger(FileReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
