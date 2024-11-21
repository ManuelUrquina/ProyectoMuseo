package com.adso.ModeloDAO;

import com.adso.clasesPojo.ArtistaPOJO;
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
 * @author M4nu3h
 */
public class ArtistaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ArtistaPOJO art = new ArtistaPOJO();

    public List listarartista() {

        ArrayList<ArtistaPOJO> list = new ArrayList<>();

        String sql = "SELECT * FROM museum.tblartistas";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ArtistaPOJO ar = new ArtistaPOJO();

                ar.setArtId(rs.getInt("artId"));
                ar.setArtCodigoArtista(rs.getInt("artCodigoArtista"));
                ar.setArtapellidos(rs.getString("artapellidos"));
                ar.setArtnombre(rs.getString("artnombre"));
                ar.setArtlugarNacimiento(rs.getString("artlugarNacimiento"));
                ar.setArtfechaNacimiento(rs.getString("artfechaNacimiento"));
                ar.setArtPathImagen(rs.getString("artPathImagen"));
                list.add(ar);

            }

        } catch (SQLException e) {

        }
        return list;

    }

    public ArtistaPOJO listarartist(int id) {

        String sql = "SELECT * FROM museum.tblartistas WHERE artId = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                art.setArtId(rs.getInt("artId"));
                art.setArtCodigoArtista(rs.getInt("artCodigoArtista"));
                art.setArtapellidos(rs.getString("artapellidos"));
                art.setArtnombre(rs.getString("artnombre"));
                art.setArtlugarNacimiento(rs.getString("artlugarNacimiento"));
                art.setArtfechaNacimiento(rs.getString("artfechaNacimiento"));
                art.setArtPathImagen(rs.getString("artPathImagen"));

            }
        } catch (SQLException e) {

        }
        return art;

    }

    public boolean editartist(ArtistaPOJO arp) {
        String sql = "UPDATE museum.tblartistas SET artCodigoArtista = '" + arp.getArtCodigoArtista() + "', "
                + "artapellidos = '" + arp.getArtapellidos() + "', "
                + "artnombre = '" + arp.getArtnombre() + "', "
                + "artlugarNacimiento = '" + arp.getArtlugarNacimiento() + "', "
                + "artfechaNacimiento = '" + arp.getArtfechaNacimiento() + "', "
                + "artPathImagen = '" + arp.getArtPathImagen() + "' WHERE artId = " + arp.getArtId() + ";";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean eliminarartista(int id) {
        String sql = "DELETE FROM museum.tblartistas WHERE artId = " + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
