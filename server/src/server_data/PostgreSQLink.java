/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_data;

import java.sql.*;
import java.util.logging.*;


/**
 *
 * @author miguel
 */
public class PostgreSQLink { 
    private static boolean connected = false;
    private static Connection connection = null;
    
   public static boolean isConnected() {
        return connected;
    }

    public static Connection getConnection() {
        return connection;
    }

    
    public static void setConnected(boolean connected) {
        PostgreSQLink.connected = connected;
    }
    
    /**
     * vê se está conectado.
     * Caso nao esteja, inicia a conecçao, se conseguir fica a true a boleana connected, senao dá o valor de falso 
     */
    void connect (){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgreSQLink.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (connected==false)
                connection = DriverManager.getConnection( "jdbc:postgresql://dbm.fe.up.pt/lpro1621", "lpro1621", "I!3716mwd");
            connected = true;
        } catch (SQLException ex) {
            System.out.println("erro no postgree server");
            Logger.getLogger(PostgreSQLink.class.getName()).log(Level.SEVERE, null, ex);
            connected = false;
        }
    }
    
    /**
     * Tenta derminar a coneccao a base de dados correctamente
     * Atribui o valor de false a variavel connected
     */
    void close(){
        connected = false;
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLink.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
