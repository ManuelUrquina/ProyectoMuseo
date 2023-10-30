/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.adso.Controlador;

import com.adso.ModeloDAO.ObraArteDAO;
import com.adso.clasesPojo.ObraArtePojo;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ADSO
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ControladorObra extends HttpServlet {

    String listar = "listarobra.jsp";
    String add = "addObra.jsp";
    String edit = "vistas/editsala.jsp";

    ObraArteDAO oda = new ObraArteDAO();
    ObraArtePojo obr = new ObraArtePojo();

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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acceso = "";
        String action = request.getParameter("accion");

        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;

        if (action.equalsIgnoreCase("verobrasarte")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("agregarobraarte")) {

            String relativePath = "imagnees/";
            String relativePath1 = "imagen2/";
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
            filePart.write(getServletContext().getRealPath(relativePath1) + nombre_unico1);
            filePart.write(getServletContext().getRealPath(relativePathPdf) + nombre_unico2);

            String idt = request.getParameter("txtID");
            String numc = request.getParameter("Numc");
            String titulo = request.getParameter("titulo");
            String Fecha = request.getParameter("FechaR");
            String Arts = request.getParameter("Artist");
            String Categ = request.getParameter("Categ");

            obr.setObrId(Integer.parseInt(idt));
            obr.setObrNumCatalogo(numc);
            obr.setObrTitulo(titulo);
            obr.setObrFechaRealizacion(Fecha);
            obr.setObrPathImg1(relativePath + nombre_unico);
            obr.setObrPathImg2(relativePath1 + nombre_unico1);
            obr.setObrPathPDF(relativePath + nombre_unico2);
            obr.setTblartistas_artId(Integer.parseInt(Arts));
            obr.setTblcategoria_catId(Integer.parseInt(Categ));

            oda.agregarobra(obr);
            acceso = listar;

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
