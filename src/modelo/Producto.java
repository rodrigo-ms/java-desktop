/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author rodri
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private int precio;
    private int stock_min;
    private int stock_act;
    private String tipo_producto;

    public Producto() {
    }

    public Producto(int codigo, String descripcion, int precio, int stock_min, int stock_act, String tipo_producto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock_min = stock_min;
        this.stock_act = stock_act;
        this.tipo_producto = tipo_producto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock_min(int stock_min) {
        this.stock_min = stock_min;
    }

    public void setStock_act(int stock_act) {
        this.stock_act = stock_act;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock_min() {
        return stock_min;
    }

    public int getStock_act() {
        return stock_act;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", stock_min=" + stock_min + ", stock_act=" + stock_act + ", tipo_producto=" + tipo_producto + '}';
    }

    
    
    
    
    
}
