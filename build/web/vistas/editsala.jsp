<%-- 
    Document   : editsala
    Created on : 18 oct 2023, 15:22:12
    Author     : M4nu3h
--%>

<%@page import="com.adso.clasesPojo.SalaPOJO"%>
<%@page import="com.adso.ModeloDAO.SalaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-lg-6">
              <%
              SalaDAO dao=new SalaDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              SalaPOJO p=(SalaPOJO)dao.list(id);
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
            
            
            
        </div>     
    </body>
</html>
