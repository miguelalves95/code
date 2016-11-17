/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_conection;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author miguel
 */
public class Sockets {

    private static final int portnumber = 1621;
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;
    private ServerSocket ss;
    
    public Sockets() {
        
        try {
           ss = new ServerSocket(portnumber);
           s = ss.accept();
           in  = new BufferedReader(new InputStreamReader( s.getInputStream()));
           out = new PrintWriter( s.getOutputStream(), true );
            
        } catch (IOException ex) {
            System.out.println("erro na sockets do server");
            System.out.println(ex);
        }
        
    }
       
    public void send(String mensagem)
    {
               out.println(mensagem);
    }
        
    public String receive() 
    {
        String dout = null;
    
        try {            
            dout = in.readLine();
        } catch (IOException ex) {
            System.out.println("ERRO no metodo RECEIVE sockets Problemas a receber");
        }
       
        return dout;
    }
    public void close() throws IOException{
      out.close();
      in.close();
      ss.close();
      s.close();
   }
}