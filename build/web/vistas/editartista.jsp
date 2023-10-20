<%-- 
    Document   : editartista
    Created on : 19 oct 2023, 18:29:55
    Author     : M4nu3h
--%>

<%@page import="com.adso.clasesPojo.ArtistaPOJO"%>
<%@page import="com.adso.ModeloDAO.ArtistaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
              <%
              ArtistaDAO dao=new ArtistaDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              ArtistaPOJO p=(ArtistaPOJO)dao.listarartist(id);
          %>
            <h1>Modificar Persona</h1>
                <form action="controladorSala">
                    Nis:<br>
                    <input class="form-control" type="text" name="txtID" value="<%= p.getSalId() %>" ><br>
                    Nombre de la Sala:<br>
                    <input class="form-control" type="text" name="txtNom" value="<%= p.getSalNombre() %>"><br>
                    Edificio donde esté la sala: <br>
                    <input class="form-control" type="text" name="txtEdif" value="<%= p.getSalEdificio()%>"><br>
                    Planta:  <br>
                    <input class="form-control" type="text" name="txtPlan" value="<%= p.getSalPlanta()%>"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    
                    <input type="hidden" name="txtID" value="<%= p.getSalId()%>">
                    <a href="controladorSala?accion=listarObra">Regresar</a>
                   </form> 
            
    </body>
</html>
