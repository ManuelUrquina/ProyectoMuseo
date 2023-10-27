/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.adso.Controlador;

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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ADSO
 */
public class ControladorObra extends HttpServlet {
  String listar = "vistas/listarobra.jsp";
  String add = "vistas/addsala.jsp";
  String edit = "vistas/editsala.jsp";
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
//            out.println("<title>Servlet ControladorObra</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControladorObra at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listarobra")) {
            acceso = listar;
        }
        
        
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        
        
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idt = request.getParameter("txtID");
        
        
        
        
        
        
        
        

        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;

        String relativePath = "imagnees/";
        String relativePathPdf = "PDF/";

        Part filePart = request.getPart("file");
        Part filePart1 = request.getPart("file1");
        Part filePart2 = request.getPart("file2");
        
        String fileName = filePart.getSubmittedFileName();
        String fileName1 = filePart1.getSubmittedFileName();
        String fileName2 = filePart2.getSubmittedFileName();
        
        
        String ext = fileName.substring(fileName.lastIndexOf('.'));
        String ext1 = fileName1.substring(fileName1.lastIndexOf('.'));
        String ext2 = fileName2.substring(fileName2.lastIndexOf('.'));
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_SSS");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(formatter);

        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd_MM_yyyy_mm_ss_SSS");
        LocalDateTime now1 = LocalDateTime.now();
        String formattedDateTime1 = now1.format(formatter1);
        
        
        String nombre_unico = formattedDateTime + ext;
        String nombre_unico1 = formattedDateTime + ext1;
        String nombre_unico2 = formattedDateTime1 + ext2;
        

        filePart.write(getServletContext().getRealPath(relativePath) + nombre_unico);
        filePart.write(getServletContext().getRealPath(relativePath) + nombre_unico1);
        filePart.write(getServletContext().getRealPath(relativePathPdf) + nombre_unico2);
        
        try {

            con = cn.getConnection();
            String sql = "INSERT INTO museum.tblobraarte(obrId,obrNumCatalogo,obrTitulo,obrFechaRealizacion,obrPathPDF,obrPathImg1,"
                    + "obrPathImg2,tblartistas_artId,tblcategoria_catId)VALUES(?,?,?,?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idt));
            

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
