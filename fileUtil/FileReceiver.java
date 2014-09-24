/*
* Add readLine() functionality
* Test code with fileSender
*/

package fileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher Kha
 */
public class FileReceiver {

    private Socket m_client;
    private ServerSocket m_socketServer;
    private InputStream m_socketIn;
    
    public FileReceiver(int port){
        m_client = null;
        try {
            m_socketServer = new ServerSocket (port);
            m_client = m_socketServer.accept();
            m_socketIn = m_client.getInputStream();
        } catch (IOException ex){
            
        }
    }
    
    public String read() {
        try {
            byte[] buffer = new byte[m_socketIn.available()]; 
            m_socketIn.read(buffer);
            return new String(buffer);
        } catch (IOException ex){
            return null;
        }
    }
    
}
