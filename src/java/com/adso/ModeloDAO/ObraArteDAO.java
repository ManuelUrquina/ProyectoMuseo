/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso.ModeloDAO;

import com.adso.clasesPojo.ArtistaPOJO;
import com.adso.clasesPojo.ObraArtePojo;
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
public class ObraArteDAO {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ObraArtePojo art = new ObraArtePojo();

    public List listarobra() {

        ArrayList<ObraArtePojo> list = new ArrayList<>();

        String sql = "SELECT * FROM museum.tblobraarte";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ObraArtePojo obr = new ObraArtePojo();

                obr.setObrId(rs.getInt("obrId"));
                obr.setObrNumCatalogo(rs.getString("obrNumCatalogo"));
                obr.setObrTitulo(rs.getString("obrTitulo"));
                obr.setObrFechaRealizacion(rs.getString("obrFechaRealizacion"));
                obr.setObrPathImg1(rs.getString("obrPathImg1"));
                obr.setObrPathImg2(rs.getString("obrPathImg2"));
                obr.setObrPathPDF(rs.getString("obrPathPDF"));
                obr.setTblartistas_artId(rs.getInt("tblartistas_artId"));
                obr.setTblcategoria_catId(rs.getInt("tblcategoria_catId"));
                list.add(obr);

            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }
    
  public boolean agregarobra(ObraArtePojo poj){
      
      
      String sql = "INSERT INTO museum.tblobraarte(obrId,obrNumCatalogo,obrTitulo,obrFechaRealizacion,"
              + "obrPathImg1,obrPathImg2,obrPathPDF,tblartistas_artId,tblcategoria_catId)"
              + "VALUES('"+ poj.getObrId()+"','"+ poj.getObrNumCatalogo()+"','"+ poj.getObrTitulo()+"',"
              + "'"+ poj.getObrFechaRealizacion()+"','"+ poj.getObrPathImg1()+"',"
              + "'"+ poj.getObrPathImg2()+"','"+ poj.getObrPathPDF()+"','"+ poj.getTblartistas_artId()+"','"+ poj.getTblcategoria_catId()+"');";
      
      try {
          
          
          
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }
      
     
  public boolean editObra (ObraArtePojo obrj){
      
      String sql = "UPDATE museum.tblobraarte SET obrId = ?,obrNumCatalogo = ?,obrTitulo = ?,obrFechaRealizacion = ?,"
              + "obrPathImg1 = ?,obrPathImg2 = ?,obrPathPDF = ?,tblartistas_artId = ?,tblcategoria_catId = ?WHERE obrId = ?;";
      
      
      try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, obrj.getObrId());
            ps.setString(2, obrj.getObrNumCatalogo());
            ps.setString(3, obrj.getObrTitulo());
            ps.setString(4, obrj.getObrFechaRealizacion());
            ps.setString(5, obrj.getObrPathImg1());
            ps.setString(6, obrj.getObrPathImg2());
            ps.setString(7, obrj.getObrPathPDF());
            ps.setInt(8, obrj.getTblartistas_artId());
            ps.setInt(9, obrj.getTblcategoria_catId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
      
      return true;
  }
      
      
      
      
      
      
      
      
  }
    
    
    
    
    
    
    
    
    
    

