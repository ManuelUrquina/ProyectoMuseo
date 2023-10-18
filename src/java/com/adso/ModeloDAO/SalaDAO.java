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
    
    
    public boolean addsala(SalaPOJO spo) {
        
        String sql= "INSERT INTO museum.tblsalas(salId,salNombre,salEdificio,salPlanta)"
                + "VALUES( '" + spo.getSalId() + "' ,'" + spo.getSalNombre()+ "' "
                + ",'" + spo.getSalEdificio()+ "' ,'" + spo.getSalPlanta()+ "' ,);" ;
        
        try{
          con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            
            
        }catch(SQLException e) {
            
        }
        
        return false;
        
        
    }
    
    
    
}
