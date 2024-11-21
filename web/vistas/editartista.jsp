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
              int id=Integer.parseInt((String)request.getAttribute("idart"));
              ArtistaPOJO art=(ArtistaPOJO)dao.listarartist(id);
          %>
            <h1>Modificar Persona</h1>
                 <form action="CcntroladorArtista" enctype="multipart/form-data">
            
            <div class="form-group">
                <label for="txtID">NIS Artista:</label>
                <input type="number" class="form-control" id="codigoartista" name="txtID" value="<%= art.getArtId()%>" required>
            </div>
            
            <div class="form-group">
                <label for="txtcodigoartista">Codigo Artista:</label>
                <input type="number" class="form-control" id="codigoartista" name="txtcodigoartista" value="<%= art.getArtCodigoArtista()%>" required>
            </div>
            <div class="form-group">
                <label for="txtapellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido" name="txtapellido" value="<%= art.getArtapellidos()%>" required>
            </div>
            <div class="form-group">                   
                <label for="txtnombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="txtnombre" value="<%= art.getArtnombre()%>" required>
            </div>
            
            <div class="form-group">
                <label for="txtlugarnacim">Lugar:</label>
                <input type="text" class="form-control" id="lugar" name="txtlugarnacim" value="<%= art.getArtlugarNacimiento()%>" required>
            </div>                
            <div class="form-group">
                <label for="txtfechanacimiento">Fecha de nacimiento</label>
                <input type="date" class="form-control" id="fechanacimiento" name="txtfechanacimiento" value="<%= art.getArtfechaNacimiento()%>" required>
            </div>
            <div class="form-group">
                <label for="imagen">Foto</label>
                <input type="file" name="file" accept="image/jpeg" value="<%= art.getArtPathImagen()%>">
            </div>
            <br>
            <input type="hidden" name="txtID" value="<%= art.getArtId()%>">
            <button type="submit" name="accion" class="btn btn-primary" value="ActualizarArtista">Enviar</button>
                   </form> 
            
    </body>
</html>
