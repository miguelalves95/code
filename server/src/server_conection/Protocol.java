/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_conection;

import java.util.*;
import server_bl.*;
import server_conection.*;
import server_data.*;
import java.sql.*;



/**
 *
 * @author miguel
 */
public class Protocol {
      public player_data fields;

    
     
    private final Sockets ss;
    
    /** Construtor*/
    
    
    public Protocol(){
        
        
        
        
        ss = new Sockets();
    }
   
    /**
     *O método receiveLogin recebe uma string do cliente através do método receive.
     *Depois divide essa string em tokens de modo a interpretar os diferentes campos da
     * mesma. Retorna o username e a password recebidos.
     */
    
    
    public String[] protReceive()
    { 
        String toReceive;
        String[] stringTokens;
        toReceive = ss.receive();
        stringTokens= toReceive.split("#");
        if(stringTokens[0].equals("login"))
            return receiveLogin(stringTokens);
        else if(stringTokens[0].equals("register"))
            return receiveLogin(stringTokens);
        else return null;
    
	}
    
    
   
    public String[] receiveLogin(String[] stringTokens){
    
        String[] userPassword = new String[2];
        System.out.println("Login".equals(stringTokens[0]));
        System.out.println("teste do login antes devia dar true");
        userPassword[0]=stringTokens[1];
        userPassword[1]=stringTokens[2];
        Player player = new Player(userPassword[0]);
          
 
        if (userPassword[1].equals(this.fields.getPassword()))
            sendReply("LOGIN_FAIL");
        else
            sendReply("LOGIN_WITH_SUCCESS");
        return userPassword;
        
                   
    }
     
     public String[] receiveRegister(){
         String[] data_from_client_player = new String[7];
        String toReceive;
        String[] stringTokens;
        String[] data_player;
        toReceive = ss.receive();
        data_player = toReceive.split("#");
        stringTokens= toReceive.split("#");
        
        int state = 0;
        System.out.println("Login".equals(stringTokens[0]));
        if("register".equals(stringTokens[0])){
        System.out.println("teste do register antes devia dar true");
        data_from_client_player[0]=data_player[1];
        data_from_client_player[1]=data_player[2];
        data_from_client_player[2]=data_player[3];
        data_from_client_player[3]=data_player[4];
        data_from_client_player[4]=data_player[5];
        data_from_client_player[5]=data_player[6];
        data_from_client_player[6]=data_player[7];
        
        return data_from_client_player;
        }
        else
            return null;
     }
    
    
            
     /**
     *O método sendReply recebe uma string, colocada o header "Login@" na mesma
     * e envia a mesma para o cliente. Esta string corresponde ao resultado da 
     * verificação da combinação user/password.
     */
    
    public void sendReply(String reply){
        if(reply.isEmpty()){
        String toSend = "clean";
        ss.send(toSend);
        }    else{ 
          String toSend =reply;
          ss.send(toSend);  
        }
    }
    
    
    public boolean checkPassword(String password){
        System.out.println("Entrou na checkPassword");
        System.out.println("password do login"+password);
        System.out.println("password da base de dados"+this.fields.getPassword());
        return password.equals(this.fields.getPassword());
    }
}
