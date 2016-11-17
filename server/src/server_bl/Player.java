/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_bl;

import server_data.*;

import java.sql.*;

/**
 *
 * @author miguel
 */
public class Player {

    public player_data fields;

    public Player(String user) {
        this.fields = new player_data(user);
    }
    
    public boolean checkPassword(String password){
        System.out.println("Entrou na checkPassword");
        System.out.println("password do login"+password);
        System.out.println("password da base de dados"+this.fields.getPassword());
        return password.equals(this.fields.getPassword());
    }
    
    
    
}