/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoihc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gmarques
 */
public class Servidor extends Thread {
    public Servidor(){
        super();
    }

public void run(){
try {
         
        ServerSocket s = new ServerSocket(2001);
        while(true){
        Socket n= s.accept();
        ObjectInputStream server = new ObjectInputStream(n.getInputStream());
        ObjectOutputStream oos= new ObjectOutputStream(n.getOutputStream());
        // LÊ OS VALORES 
        String recebido =(String)server.readObject();      

         }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
}  
}
