/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.adso.Controlador;

import com.adso.ModeloDAO.ArtistaDAO;
import com.adso.clasesPojo.ArtistaPOJO;
import com.adso.conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author M4nu3h
 */


@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ControladorArtista extends HttpServlet {

    String listarArt = "listarartista.jsp";
    String editArt = "vistas/editartista.jsp";

    ArtistaDAO ar = new ArtistaDAO();
    ArtistaPOJO art = new ArtistaPOJO();

    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControladorArtista</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControladorArtista at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listarArt")) {
            acceso = listarArt;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            art.setArtId(id);
            ar.eliminarartista(id);
            acceso = listarArt;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idart", request.getParameter("id"));
            acceso = editArt;
        } else if (action.equalsIgnoreCase("ActualizarArtista")) {

            String id = request.getParameter("txtID");
            String codart = request.getParameter("txtcodigoartista");
            String apell = request.getParameter("txtapellido");
            String nomb = request.getParameter("txtnombre");
            String lugnac = request.getParameter("txtlugarnacim");
            String fecnacim = request.getParameter("txtfechanacimiento");
            String foto = request.getParameter("file");
            
            
            
            art.setArtId(Integer.parseInt(id));
            art.setArtCodigoArtista(Integer.parseInt(codart));
            art.setArtapellidos(apell);
            art.setArtnombre(nomb);
            art.setArtlugarNacimiento(lugnac);
            art.setArtfechaNacimiento(fecnacim);
            art.setArtPathImagen(foto);
            ar.editartist(art);
            acceso = listarArt;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String idt = request.getParameter("txtID");
        String codigoartista = request.getParameter("txtcodigoartista");
        String apellido = request.getParameter("txtapellido");
        String nombre = request.getParameter("txtnombre");
        String lugarnacim = request.getParameter("txtlugarnacim");
        String fechanacimiento = request.getParameter("txtfechanacimiento");

        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;

        String relativePath = "imagnees/";

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        String ext = fileName.substring(fileName.lastIndexOf('.'));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(formatter);

        String nombre_unico = formattedDateTime + ext;

        filePart.write(getServletContext().getRealPath(relativePath) + nombre_unico);

        try {

            con = cn.getConnection();
            String sql = "INSERT INTO museum.tblartistas(artId,artCodigoArtista,artapellidos,artnombre,artlugarNacimiento,"
                    + "artfechaNacimiento,artPathImagen)VALUES(?,?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idt));
            ps.setString(2, codigoartista);
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            ps.setString(5, lugarnacim);
            ps.setString(6, fechanacimiento);
            ps.setString(7, relativePath + nombre_unico);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                String message = "Solicitud enviada con éxito.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("listarartista.jsp").forward(request, response);
            } else {
                String errorMessage = "No se pudo enviar la solicitud.";
                request.setAttribute("error", errorMessage);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            System.out.println(e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
