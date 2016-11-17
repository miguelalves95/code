/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import server_conection.*;
import server_bl.*;
/**
 *
 * @author miguel
 */
public class Server {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("Server Started");
       String[] userPassword ;
        Protocol ps = new Protocol();
        System.out.println("antes do ciclo while do server");
        while (true){
            userPassword = ps.protReceive();
            System.out.println("dentro do ciclo while do server");
            Player player = new Player(userPassword[0]);

            
        }
      
        
  
        
    }
    
}
