/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez
 */
public class EmpleadosDAL {
    Connection conexion;
    
    public EmpleadosDAL(){
        Conexion con=new Conexion();
        conexion =con.getConexion();
    }
    
    public List<Empleados>listarEmpleados(){
        PreparedStatement  ps;
        ResultSet rs;
        
        List<Empleados> lista= new ArrayList<>();
        
        try{
            
            ps=conexion.prepareStatement("SELECT id,nombre,apellido,gmail,puesto  FROM empleados");
            rs=ps.executeQuery();
            
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String gmail = rs.getString ("gmail");
                 String puesto = rs.getString("puesto");

                Empleados empleados = new Empleados(id,nombre, apellido,gmail,puesto);
                lista.add(empleados);
            }
        
            return lista;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Empleados mostrarEmpleados(int _id){
         
     
        PreparedStatement  ps;
        ResultSet rs;
        Empleados empleados = null;
  
        try{
            
            ps=conexion.prepareStatement("SELECT id,nombre,apellido,gmail,puesto FROM empleados WHERE id=?");
            
            ps.setInt(1,_id);
            rs= ps.executeQuery();
  
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("titulo");
                String apellido  = rs.getString("apellido");
                String gmail = rs.getString ("gmail");
                String puesto= rs.getString ("puesto");

                 empleados = new Empleados(id,nombre, apellido,gmail,puesto);
                
            }
        
            return empleados;
        }catch (SQLException e) {
            System.out.println("Error al mostrar registro : " + e.toString());
            return null;     
        }
     }
    
    public boolean  insertar (Empleados empleados){
    PreparedStatement  ps;
  
        try{
            
            ps=conexion.prepareStatement("INSERT INTO  empleados(nombre,apellido,gmail,puesto) VALUES (?,?,?,?)");
            
            ps.setString(1,empleados.getNombre());
            ps.setString(2,empleados.getApellido());
            ps.setString(3,empleados.getGmail());
             ps.setString(4,empleados.getPuesto());
            
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
     }
     
    public boolean  actualizar(Empleados empleados){
    PreparedStatement  ps;
  
        try{
            
            ps=conexion.prepareStatement("UPDATE  empleados SET nombre=?,apellido=?,gmail=?,puesto=? WHERE id=?");
            
            
            ps.setString(1,empleados.getNombre());
            ps.setString(2,empleados.getApellido());
            ps.setString(3,empleados.getGmail());
            ps.setString(4,empleados.getPuesto());
             ps.setInt(5,empleados.getId());
            
         
            
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
     }
    
    
    public boolean  eliminar( int _id){
    PreparedStatement  ps;
  
        try{
            
            ps=conexion.prepareStatement("DELETE FROM empleados WHERE id=?");
            
            ps.setInt(1,_id);
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
     }
    }