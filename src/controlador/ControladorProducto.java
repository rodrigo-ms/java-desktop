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
import java.util.ArrayList;
import static modelo.IDescuento.dCelular;
import static modelo.IDescuento.dComputador;
import static modelo.IDescuento.dConsola;
import modelo.Producto;
import modelo.Usuario;
/**
 *
 * @author rodri
 */
public class ControladorProducto {
    
    
    public boolean agregarProducto(Producto producto)
    {
    
        try {
            
            //creamos la conexion
            Conexion con = new Conexion();
            Connection cn = con.obtenerConexion();
            
            //Crear consulta SQL
            String query = "INSERT INTO producto(descripcion, precio, stock_min, stock_act, tipo_producto) VALUES(?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(query);
            
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getStock_min());
            ps.setInt(4, producto.getStock_act());
            ps.setString(5, producto.getTipo_producto());
            
            ps.executeUpdate();
            ps.close();
            cn.close();
            
            return true;
       
         
            
        } catch (SQLException e) {
            
            System.out.println("Error BD: "+ e.getMessage());
            return false;
        }
    
    }
    
     public boolean modificarProducto(Producto producto)
    {
    
        try {
            
            //creamos la conexion
            Conexion con = new Conexion();
            Connection cn = con.obtenerConexion();
            
            //Crear consulta SQL
            String query = "UPDATE producto SET descripcion=?, precio=?, stock_min=?, stock_act=?, tipo_producto=? WHERE codigo=?";
            PreparedStatement ps = cn.prepareStatement(query);
            
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getStock_min());
            ps.setInt(4, producto.getStock_act());
            ps.setString(5, producto.getTipo_producto());
            ps.setInt(6, producto.getCodigo());
            
            ps.executeUpdate();
            ps.close();
            cn.close();
            
            return true;
       
         
            
        } catch (SQLException e) {
            
            System.out.println("Error BD: "+ e.getMessage());
            return false;
        }
    
    }
     public boolean eliminar(int codigo)
    {
     try {
            //creamos la conexion
            Conexion con = new Conexion();
            Connection cn = con.obtenerConexion();
            //Crear consulta SQL
            String query = "DELETE FROM producto WHERE codigo = ?";
            PreparedStatement ps = cn.prepareStatement(query);
            
            ps.setInt(1, codigo);
            
            ps.executeUpdate();
            ps.close();
            cn.close();
            
            return true;
            
        } catch (SQLException e) {       
            System.out.println("Error BD: "+ e.getMessage());
            return false;
        }
    
    }
     
     
     public ArrayList<Producto> traerProducto()
    {
        ArrayList<Producto> listaProducto = new ArrayList<>();
        
           try {
            Conexion con = new Conexion();
            Connection cnt = con.obtenerConexion();
               
            String query = "SELECT codigo, descripcion, precio, stock_min, stock_act, tipo_producto   FROM producto";
            PreparedStatement ps = cnt.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock_min(rs.getInt("stock_min"));
                producto.setStock_act(rs.getInt("stock_act"));
                producto.setTipo_producto(rs.getString("tipo_producto"));
                
                
                listaProducto.add(producto);
                
            }
              
            rs.close();
            ps.close();
            cnt.close();
               
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage());
        }
  
        return listaProducto;
    
    }
     
    public ArrayList<Producto> filtrarPorStock()
    {
        ArrayList<Producto> listaProducto = new ArrayList<>();
        
           try {
            Conexion con = new Conexion();
            Connection cnt = con.obtenerConexion();
               
            String query = "SELECT codigo, descripcion, precio, stock_min, stock_act, tipo_producto   FROM producto";
            PreparedStatement ps = cnt.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock_min(rs.getInt("stock_min"));
                producto.setStock_act(rs.getInt("stock_act"));
                producto.setTipo_producto(rs.getString("tipo_producto"));
                
                if(producto.getStock_act()<=producto.getStock_min()){
                    listaProducto.add(producto);
                }
                
                
            }
              
            rs.close();
            ps.close();
            cnt.close();
               
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage());
        }
  
        return listaProducto;
    
    }
    
    public int obtener_stock_actual(int codigo){
        int stock_registrado = 0;
         try {
            Conexion con = new Conexion();
            try (Connection cnt = con.obtenerConexion()) {
                String query = "SELECT stock_act FROM producto WHERE codigo=?";
                try (PreparedStatement ps = cnt.prepareStatement(query)) {
                    ps.setInt(1, codigo);
                    
                    try (ResultSet rs = ps.executeQuery()) {
                           if(rs.next()){

                             stock_registrado = rs.getInt(1);

        }
                    }
                }
            }
           return stock_registrado; 
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage()+"EN EL obtener_stock_actual");
               return stock_registrado; 
        }
         
        
  
        
       
    }
    
  
    
    public double  calcular_venta(int codigo,int cantidad){
       int total=0;
         
            Conexion con = new Conexion();
            try (Connection cnt = con.obtenerConexion()) {
                String query = "SELECT precio FROM producto WHERE codigo=?";
                try (PreparedStatement ps = cnt.prepareStatement(query)) {
                    ps.setInt(1,codigo);
                    try (ResultSet rs = ps.executeQuery()) {
                        if(rs.next()){

                             total = rs.getInt(1);
                    }
                }
            }
           if(codigo==1){
               System.out.println("");
                    double totald = total*dCelular;
                    totald=total-totald;
               return totald*cantidad;
           }
           if(codigo==2){
               System.out.println("");
               double totald = total*dComputador;
               totald=total-totald;
               return totald*cantidad;
           }
           if(codigo==3){
               System.out.println("");
               double totald = total*dConsola;
               totald=total-totald;
               return totald*cantidad;
           }
           return total*cantidad;
           
           
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage()+"EN EL METODOcalcular_venta");
        }
        
        
  
        
        
        return total;
    }
    
    public void vender_producto(int codigo,int cantidad){
          try {
            
            //creamos la conexion
            Conexion con = new Conexion();
            Connection cn = con.obtenerConexion();
            
            //Crear consulta SQL
            String query = "UPDATE producto SET stock_act=? WHERE codigo=?";
            PreparedStatement ps = cn.prepareStatement(query);
            
            int nuevo_stock = obtener_stock_actual(codigo)-cantidad;
            
            ps.setInt(1, nuevo_stock);
            ps.setInt(2, codigo);
            
            
            ps.executeUpdate();
            ps.close();
            cn.close();
            
            
       
         
            
        } catch (SQLException e) {
            
            System.out.println("Error BD: "+ e.getMessage()+"EN EL vender_producto");
            
        }
        
        
        
    }
     
     public Producto validar_producto(int codigo){
          Producto producto = new Producto();
    
     try {
            Conexion con = new Conexion();
            Connection cnt = con.obtenerConexion();
               
            String query = "SELECT * FROM producto WHERE codigo = ?";
            PreparedStatement ps = cnt.prepareStatement(query);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
               
                producto.setStock_act(rs.getInt("stock_act"));
            
            }
              
            rs.close();
            ps.close();
            cnt.close();
               
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage());
        }
        
        return producto;
         
         
     }
     
    
}
