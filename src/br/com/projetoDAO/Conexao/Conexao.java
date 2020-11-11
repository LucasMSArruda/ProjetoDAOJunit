/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas.A
 */
public class Conexao {
        
    public static Connection conectar()
    {
       Connection conn = null;
       final String URL = "jdbc:mysql://localhost:3306/projetoDAO?useTimezone=true&serverTimezone=UTC";
       final String USE = "root";
       final String PASS = "root";
       
       try{
       
           conn = DriverManager.getConnection(URL,USE,PASS);
           return conn;
       
       }catch (Exception e){
       
           return null;
       }           
    }
    
    public static void desconectar(Connection conn)
    {   
        try{
            conn.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            
        }
    
    }
}
