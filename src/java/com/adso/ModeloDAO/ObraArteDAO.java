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
    
    
    
    
    
    
    
    
    
    
    
    
}
