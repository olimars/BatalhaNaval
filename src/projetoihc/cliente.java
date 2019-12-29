package projetoihc;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gmarques
 */
public class Cliente implements Runnable {
    private String dados;
    
    public Cliente(String dados){
      super();
      this.dados=dados;
    
    }
    
    public Cliente(){
        super();
        dados="";
        
    }
    
    public void run(){
           try {
            Socket s= new Socket("192.168.1.70",2000);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream server = new ObjectInputStream(s.getInputStream());
            oos.writeObject(dados);
            oos.flush();
           
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
