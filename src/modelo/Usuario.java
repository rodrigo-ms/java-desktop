/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author rodri
 */
public class Usuario {
    //ATRIBUTOS DE LA CLASE USUARIO
    private int id_usuario;
    private String username;
    private String password;
    //CONSTRUCTOR SIN PARAMETROS
    public Usuario() {
    }
    //CONSTRUCTOR CON PARAMETROS
    public Usuario(int id_usuario, String username, String password) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
    }
    //setters

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //getters

    public int getId_usuario() {
        return id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    
    //metodo mostrar datos no sobre escrito
    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", username=" + username + ", password=" + password + '}';
    }
    
    
    
    
    
    
    
    
}
