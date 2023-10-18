/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso.ModeloDAO;

import com.adso.clasesPojo.SalaPOJO;
import com.adso.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADSO
 */
public class SalaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    SalaPOJO sal = new SalaPOJO();
    int p = 0;
   
    public List listarsala() {
        
        ArrayList <SalaPOJO>list=new ArrayList<>();
        
        String sql = "SELECT * FROM museum.tblsalas";
        
        try{
          con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                SalaPOJO spo = new SalaPOJO();
                
                spo.setSalId(rs.getInt("salId"));
                spo.setSalNombre(rs.getString("salNombre"));
                spo.setSalEdificio(rs.getString("salEdificio"));
                spo.setSalPlanta(rs.getString("salPlanta"));
                
                list.add(spo);
                
                
            }
            
        }catch (SQLException e) {
            
        }
        return list;
        
        
        
    }
    
    public SalaPOJO list(int id) {
   
    
    String sql = "SELECT * FROM museum.tblsalas WHERE salId="+id;
    
     try{
          con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){

                
                sal.setSalId(rs.getInt("salId"));
                sal.setSalNombre(rs.getString("salNombre"));
                sal.setSalEdificio(rs.getString("salEdificio"));
                sal.setSalPlanta(rs.getString("salPlanta"));
                
            }
     }catch(SQLException e){
                    
                    }
        return sal;
    
    
}
    
    
    
    public boolean addsala(SalaPOJO so) {
        
        String sql= "INSERT INTO museum.tblsalas(salId,salNombre,salEdificio,salPlanta)"
                + "VALUES( '" + so.getSalId() + "' ,'" + so.getSalNombre()+ "' "
                + ",'" + so.getSalEdificio()+ "' ,'" + so.getSalPlanta()+ "');" ;
        
        try{
          con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(); 
            
            
        }catch(SQLException e) {
            
        }
        
        return false;
        
        
    }
    
     public boolean editsala(SalaPOJO so) {
       String sql= "UPDATE museum.tblsalas SET  salNombre = '"+so.getSalNombre()+"',salEdificio ='"+ so.getSalEdificio()+""
               + "',salPlanta ='" + so.getSalPlanta()+"'WHERE salId ="+so.getSalId();
       try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
     
     
     public boolean eliminarsala(int id) {
        String sql="DELETE FROM museum.tblsalas WHERE salId = "+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
