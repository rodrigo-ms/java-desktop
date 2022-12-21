/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author rodri
 */
public class ControladorUsuario {
    
    public boolean agregarUsuario(Usuario usuario)
    {
    
        try {
            
            //creamos la conexion
            Conexion con = new Conexion();
            Connection cn = con.obtenerConexion();
            
            //Crear consulta SQL
            String query = "INSERT INTO usuario(username, password) VALUES(?,?)";
            PreparedStatement ps = cn.prepareStatement(query);
            
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            
            ps.executeUpdate();
            ps.close();
            cn.close();
            
            return true;
       
         
            
        } catch (SQLException e) {
            
            System.out.println("Error BD: "+ e.getMessage());
            return false;
        }
    
    }
    
    
    
    
    public Usuario buscarUsuario(String username,String password)
    {
        Usuario usuario = new Usuario();
    
     try {
            Conexion con = new Conexion();
            Connection cnt = con.obtenerConexion();
               
            String query = "SELECT * FROM usuario WHERE username = ? and password= ?";
            PreparedStatement ps = cnt.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
               
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
            }
              
            rs.close();
            ps.close();
            cnt.close();
               
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage());
        }
        
        return usuario;
    }
    
    
    
    
    
}
